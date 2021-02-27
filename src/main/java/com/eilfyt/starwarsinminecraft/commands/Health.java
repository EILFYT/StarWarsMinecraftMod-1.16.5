package com.eilfyt.starwarsinminecraft.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class Health implements Command<CommandSource> {
    private static final Health G = new Health();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("me")
                .requires(cs -> cs.hasPermissionLevel(2))
                .executes(G);
    }

    @Override
    public int run(CommandContext<CommandSource> commandContext) throws CommandSyntaxException {
        Minecraft.getInstance().player.heal(200f);
        return 0;
    }
}
