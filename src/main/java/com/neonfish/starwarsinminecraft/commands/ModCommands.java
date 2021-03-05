package com.neonfish.starwarsinminecraft.commands;

import com.neonfish.starwarsinminecraft.StarWarsInMinecraft;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class ModCommands {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralCommandNode<CommandSource> cmdTlp = dispatcher.register(
                Commands.literal(StarWarsInMinecraft.MOD_ID)
                        .then(CommandTpDim.register(dispatcher))
                        .then(CommandTpNether.register(dispatcher))
                        .then(CommandTpEnd.register(dispatcher))
        );

        dispatcher.register(Commands.literal("tlp").redirect(cmdTlp));
    }


}