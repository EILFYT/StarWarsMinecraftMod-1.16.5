package com.eilfyt.starwarsinminecraft.commands;

import com.eilfyt.starwarsinminecraft.util.TestUtils;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.arguments.ItemArgument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;

public class ReloadFishHatNamesCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralArgumentBuilder<CommandSource> reloadhats
                = Commands.literal("reloadfishhats").requires((commandSource) -> commandSource.hasPermission(2))
                                .executes(ReloadFishHatNamesCommand::ReloadRepo);
        dispatcher.register(reloadhats);
    }
    static int ReloadRepo(CommandContext<CommandSource> commandContext) throws CommandSyntaxException {
        TestUtils.refreshRepo();
        return 1;
    }
}
