package com.eilfyt.starwarsinminecraft.dimensions;
import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.Blockreader;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;

public class MustafarChunkGenerator extends ChunkGenerator {

    private static final Codec<Settings> SETTINGS_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("base").forGetter(Settings::getBaseHeight),
                    Codec.FLOAT.fieldOf("verticalvariance").forGetter(Settings::getVerticalVariance),
                    Codec.FLOAT.fieldOf("horizontalvariance").forGetter(Settings::getHorizontalVariance)
            ).apply(instance, Settings::new));

    public static final Codec<MustafarChunkGenerator> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter(MustafarChunkGenerator::getBiomeRegistry),
                    SETTINGS_CODEC.fieldOf("settings").forGetter(MustafarChunkGenerator::getSettings)
            ).apply(instance, MustafarChunkGenerator::new));

    private final Settings settings;

    public MustafarChunkGenerator(Registry<Biome> registry, Settings settings) {
        super(new MustafarBiomeProvider(registry), new DimensionStructuresSettings(false));
        this.settings = settings;
        StarWarsInMinecraft.LOGGER.info("Chunk generator settings: " + settings.getBaseHeight() + ", " + settings.getHorizontalVariance() + ", " + settings.getVerticalVariance());
    }

    public MustafarChunkGenerator(BiomeProvider p_i231888_1_, DimensionStructuresSettings p_i231888_2_, Settings settings) {
        super(p_i231888_1_, p_i231888_2_);
        this.settings = settings;
    }

    public Settings getSettings() {
        return settings;
    }

    public Registry<Biome> getBiomeRegistry() {
        return ((MustafarBiomeProvider)biomeProvider).getBiomeRegistry();
    }

    @Override
    public void generateSurface(WorldGenRegion region, IChunk chunk) {
        BlockState bedrock = Blocks.BEDROCK.getDefaultState();
        BlockState stone = Blocks.BLACKSTONE.getDefaultState();
        ChunkPos chunkpos = chunk.getPos();

        BlockPos.Mutable pos = new BlockPos.Mutable();

        int x;
        int z;

        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                chunk.setBlockState(pos.setPos(x, 0, z), bedrock, false);
            }
        }

        int baseHeight = settings.getBaseHeight();
        float verticalVariance = settings.getVerticalVariance();
        float horizontalVariance = settings.getHorizontalVariance();
        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                int realx = chunkpos.x * 16 + x;
                int realz = chunkpos.z * 16 + z;
                int height = (int) (baseHeight + Math.sin(realx / horizontalVariance)*verticalVariance + Math.cos(realz / horizontalVariance)*verticalVariance);
                for (int y = 1 ; y < height ; y++) {
                    chunk.setBlockState(pos.setPos(x, y, z), stone, false);
                }
            }
        }
    }

    @Override
    protected Codec<? extends ChunkGenerator> func_230347_a_() {
        return CODEC;
    }

    @Override
    public ChunkGenerator func_230349_a_(long seed) {
        return new MustafarChunkGenerator(getBiomeRegistry(), settings);
    }

    @Override
    public void func_230352_b_(IWorld world, StructureManager structureManager, IChunk chunk) {

    }

    @Override
    public int getHeight(int x, int z, Heightmap.Type heightmapType) {
        return 0;
    }

    @Override
    public IBlockReader func_230348_a_(int p_230348_1_, int p_230348_2_) {
        return new Blockreader(new BlockState[0]);
    }

    private static class Settings {
        private final int baseHeight;
        private final float verticalVariance;
        private final float horizontalVariance;

        public Settings(int baseHeight, float verticalVariance, float horizontalVariance) {
            this.baseHeight = baseHeight;
            this.verticalVariance = verticalVariance;
            this.horizontalVariance = horizontalVariance;
        }

        public float getVerticalVariance() {
            return verticalVariance;
        }

        public int getBaseHeight() {
            return baseHeight;
        }

        public float getHorizontalVariance() {
            return horizontalVariance;
        }
    }
}