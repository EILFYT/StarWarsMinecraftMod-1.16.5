package com.eilfyt.starwarsinminecraft.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.ItemArgument;
import net.minecraft.command.arguments.MessageArgument;
import net.minecraft.command.impl.GiveCommand;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;

public class CooldownResetCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralArgumentBuilder<CommandSource> createexplosion
                = Commands.literal("resetcooldown").requires((commandSource) -> commandSource.hasPermission(2))
                .then(Commands.argument("item", ItemArgument.item())
                        .executes(CooldownResetCommand::resetCooldown));

        dispatcher.register(createexplosion);
    }
    static int resetCooldown(CommandContext<CommandSource> commandContext) throws CommandSyntaxException {
        Item e = ItemArgument.getItem(commandContext, "item").getItem();
    commandContext.getSource().getPlayerOrException().getCooldowns().removeCooldown(e);
        commandContext.getSource().getPlayerOrException().sendMessage(ITextComponent.nullToEmpty("Cooldown reset!"),
                commandContext.getSource().getEntity().getUUID());
    return 1;
    }

}
