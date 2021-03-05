package com.neonfish.starwarsinminecraft.commands;

import com.neonfish.starwarsinminecraft.tools.TeleportationTools;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class CommandTpNether implements Command<CommandSource> {
    private static final CommandTpNether CMDD = new CommandTpNether();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("nether")
                .requires(cs -> cs.hasPermissionLevel(1))
                .executes(CMDD);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().asPlayer();
        int x = player.getPosition().getX();
        int z = player.getPosition().getZ();
        if (player.getEntityWorld().getDimensionKey().equals(World.THE_NETHER)) {
            ServerWorld world = player.getServer().getWorld(World.OVERWORLD);
            TeleportationTools.teleport(player, world, new BlockPos(x, 200, z));
            player.addPotionEffect(CommandTpDim.NOT_THE_EFFECT_INSTANCE);
        } else {
            ServerWorld world = player.getServer().getWorld(World.THE_NETHER);
            TeleportationTools.teleport(player, world, new BlockPos(x, 80, z));
            player.addPotionEffect(CommandTpDim.EFFECT_INSTANCE);
        }
        return 0;
    }

}
