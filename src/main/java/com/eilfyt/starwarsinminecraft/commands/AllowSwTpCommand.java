package com.eilfyt.starwarsinminecraft.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class AllowSwTpCommand {
    public static int swtpconfig = 0;
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralArgumentBuilder<CommandSource> swtpconfig
                = Commands.literal("swtpconfig").requires((commandSource) -> commandSource.hasPermission(2))
                .then(Commands.literal("allow")
                        .executes(AllowSwTpCommand::allow))
                        .then(Commands.literal("deny")
                .executes(AllowSwTpCommand::deny));

        dispatcher.register(swtpconfig);
    }

     static int allow(CommandContext<CommandSource> commandContext) throws CommandSyntaxException {
    swtpconfig = 0;
        return 1;
    }
    static int deny(CommandContext<CommandSource> commandContext) throws CommandSyntaxException {
        swtpconfig = 3;
        return 1;
    }
}
