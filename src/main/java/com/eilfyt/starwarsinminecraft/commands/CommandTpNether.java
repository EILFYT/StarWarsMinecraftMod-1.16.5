 package com.eilfyt.starwarsinminecraft.commands;

import com.eilfyt.starwarsinminecraft.tools.TeleportationTools;
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
                .requires(cs -> cs.hasPermission(1))
                .executes(CMDD);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().getPlayerOrException();
        int x = (int) player.getX();
        int z = (int) player.getZ();
        if (player.getCommandSenderWorld().dimension().equals(World.NETHER)) {
            ServerWorld world = player.getServer().getLevel(World.OVERWORLD);
            TeleportationTools.teleport(player, world, new BlockPos(x, 200, z));
            player.addEffect(CommandTpDim.NOT_THE_EFFECT_INSTANCE);
        } else {
            ServerWorld world = player.getServer().getLevel(World.NETHER);
            TeleportationTools.teleport(player, world, new BlockPos(x, 80, z));
            player.addEffect(CommandTpDim.EFFECT_INSTANCE);
        }
        return 0;
    }

}
