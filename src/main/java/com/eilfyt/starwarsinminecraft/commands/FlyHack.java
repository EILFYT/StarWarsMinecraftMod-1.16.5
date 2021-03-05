package com.eilfyt.starwarsinminecraft.commands;

import com.eilfyt.starwarsinminecraft.items.HackerPhoneScreen;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class FlyHack implements Command<CommandSource> {
    private static final FlyHack FLY = new FlyHack();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("gui")
                .requires(cs -> cs.hasPermissionLevel(2))
                .executes(FLY);
    }
    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        Minecraft.getInstance().displayGuiScreen(new HackerPhoneScreen());
        return 0;
    }
}
