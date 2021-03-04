package com.eilfyt.starwarsinminecraft.commands;

import com.eilfyt.starwarsinminecraft.tools.TeleportationTools;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementList;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.client.gui.advancements.AdvancementState;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.PlayerData;

public class CommandTpEnd implements Command<CommandSource>  {
    private static final CommandTpEnd CMDDD = new CommandTpEnd();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("end")
                .requires(cs -> cs.hasPermissionLevel(1))
                .executes(CMDDD);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().asPlayer();
        int x = player.getPosition().getX();
        int z = player.getPosition().getZ();
        if (player.getEntityWorld().getDimensionKey().equals(World.THE_END)) {
            ServerWorld world = player.getServer().getWorld(World.OVERWORLD);
            TeleportationTools.teleport(player, world, new BlockPos(x, 200, z));
            player.addPotionEffect(CommandTpDim.NOT_THE_EFFECT_INSTANCE);
        } else {
            ServerWorld world = player.getServer().getWorld(World.THE_END);
            TeleportationTools.teleport(player, world, new BlockPos(0, 70, 0));
        }
        return 0;
    }

}


