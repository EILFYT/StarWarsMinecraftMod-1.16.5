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

public class CommandTpEnd implements Command<CommandSource>  {
    private static final CommandTpEnd CMDDD = new CommandTpEnd();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("end")
                .requires(cs -> cs.hasPermission(1))
                .executes(CMDDD);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().getPlayerOrException();
        int x = (int) player.getX();
        int z = (int) player.getZ();
        if (player.getCommandSenderWorld().dimension().equals(World.END)) {
            ServerWorld world = player.getServer().getLevel(World.OVERWORLD);
            TeleportationTools.teleport(player, world, new BlockPos(x, 200, z));
            player.addEffect(CommandTpDim.NOT_THE_EFFECT_INSTANCE);
        } else {
            ServerWorld world = player.getServer().getLevel(World.END);
            TeleportationTools.teleport(player, world, new BlockPos(0, 70, 0));
        }
        return 0;
    }

}
