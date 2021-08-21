package com.eilfyt.starwarsinminecraft.commands;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.ItemArgument;
import net.minecraft.command.arguments.ItemInput;
import net.minecraft.command.impl.GiveCommand;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Explosion;
import org.apache.logging.log4j.Level;

public class GiveItemCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralArgumentBuilder<CommandSource> createexplosion
                = Commands.literal("i").requires((commandSource) -> commandSource.hasPermission(2))
                .then(Commands.argument("item", ItemArgument.item())
                        .executes(GiveItemCommand::giveitem));

        dispatcher.register(createexplosion);
    }

    static int giveitem(CommandContext<CommandSource> commandContext) throws CommandSyntaxException {
        ItemInput item = ItemArgument.getItem(commandContext, "item");
        commandContext.getSource().getPlayerOrException().inventory.add(new ItemStack(item.getItem(), 64));
        return 1;
    }
}
