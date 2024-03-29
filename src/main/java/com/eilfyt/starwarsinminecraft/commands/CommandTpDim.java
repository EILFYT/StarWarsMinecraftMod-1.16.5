package com.eilfyt.starwarsinminecraft.commands;

import com.eilfyt.starwarsinminecraft.dimensions.ModDimensions;
import com.eilfyt.starwarsinminecraft.tools.TeleportationTools;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class CommandTpDim implements Command<CommandSource> {
    public static EffectInstance EFFECT_INSTANCE = new EffectInstance(Effects.SLOW_FALLING, 200, 0);
    public static EffectInstance NOT_THE_EFFECT_INSTANCE = new EffectInstance(Effects.SLOW_FALLING, 600, 0);
    private static final CommandTpDim CMD = new CommandTpDim();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("mustafar")
                .requires(cs -> cs.hasPermission(1))
                
                .executes(CMD);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().getPlayerOrException();
        int x = (int) player.getX();
        int z = (int) player.getZ();
        if (player.getCommandSenderWorld().dimension().equals(ModDimensions.MUSTAFAR)) {
            ServerWorld world = player.getServer().overworld();
            TeleportationTools.teleport(player, world, new BlockPos(x, 200, z));
           player.addEffect(NOT_THE_EFFECT_INSTANCE);
        } else {
            ServerWorld world = player.getServer().getLevel(ModDimensions.MUSTAFAR);
            TeleportationTools.teleport(player, world, new BlockPos(x, 80, z));
            player.addEffect(EFFECT_INSTANCE);
        }
        return 0;
    }

}