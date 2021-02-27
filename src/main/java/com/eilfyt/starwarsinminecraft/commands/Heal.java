package com.eilfyt.starwarsinminecraft.commands;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class Heal {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralCommandNode<CommandSource> cmdHeal = dispatcher.register(
                Commands.literal(StarWarsInMinecraft.MOD_ID)
                .then(Health.register(dispatcher))
        );

        dispatcher.register(Commands.literal("heal").redirect(cmdHeal));
    }
}

