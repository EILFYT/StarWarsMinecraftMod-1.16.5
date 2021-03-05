package com.neonfish.starwarsinminecraft.commands;

import com.neonfish.starwarsinminecraft.StarWarsInMinecraft;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class FlyHax {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralCommandNode<CommandSource> cmdFly = dispatcher.register(
                Commands.literal(StarWarsInMinecraft.MOD_ID)
                        .then(FlyHack.register(dispatcher))

        );

        dispatcher.register(Commands.literal("open").redirect(cmdFly));
    }
}
