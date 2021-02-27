
        package com.eilfyt.starwarsinminecraft.dimensions;

        import com.mojang.serialization.Codec;
        import net.minecraft.util.RegistryKey;
        import net.minecraft.util.registry.Registry;
        import net.minecraft.util.registry.RegistryLookupCodec;
        import net.minecraft.world.biome.Biome;
        import net.minecraft.world.biome.Biomes;
        import net.minecraft.world.biome.provider.BiomeProvider;
        import net.minecraft.world.gen.feature.structure.Structure;

        import java.util.Collections;
        import java.util.List;
        import java.util.stream.Collectors;

        public class MustafarBiomeProvider extends BiomeProvider {

        public static final Codec<MustafarBiomeProvider> CODEC = RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY)
        .xmap(MustafarBiomeProvider::new, MustafarBiomeProvider::getBiomeRegistry).codec();

        private final Biome biome;
        private final Registry<Biome> biomeRegistry;
        private static final List<RegistryKey<Biome>> SPAWN = Collections.singletonList(Biomes.PLAINS);

        public MustafarBiomeProvider(Registry<Biome> biomeRegistry) {
        super(getStartBiomes(biomeRegistry));
        this.biomeRegistry = biomeRegistry;
        biome = biomeRegistry.getOrDefault(Biomes.PLAINS.getLocation());
        }

        private static List<Biome> getStartBiomes(Registry<Biome> registry) {
        return SPAWN.stream().map(s -> registry.getOrDefault(s.getLocation())).collect(Collectors.toList());
        }

        public Registry<Biome> getBiomeRegistry() {
        return biomeRegistry;
        }

        @Override
        public boolean hasStructure(Structure<?> structure) {
        return false;
        }

        @Override
        protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return CODEC;
        }

        @Override
        public BiomeProvider getBiomeProvider(long seed) {
        return this;
        }

        @Override
        public Biome getNoiseBiome(int x, int y, int z) {
        return biome;
        }
        }
