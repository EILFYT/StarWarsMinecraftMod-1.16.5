package com.eilfyt.starwarsinminecraft.commands;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import org.apache.logging.log4j.Level;

public class CustomGamemodeConfig {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralArgumentBuilder<CommandSource> customGamemode
                = Commands.literal("customgamemode").requires((commandSource) -> commandSource.hasPermission(2))
                .then(Commands.literal("fly")
                            .executes(CustomGamemodeConfig::fly))
                .then(Commands.literal("invulnerability")
                        .executes(CustomGamemodeConfig::invulnerable))
                .then(Commands.literal("creativeInventory")
                        .executes(CustomGamemodeConfig::creativeInventory))
                .then(Commands.literal("log")
                .executes(CustomGamemodeConfig::log));

        dispatcher.register(customGamemode);
    }

    private static int log(CommandContext<CommandSource> commandContext) throws CommandSyntaxException{
        PlayerEntity player = commandContext.getSource().getPlayerOrException();
        StarWarsInMinecraft.LOGGER.log(Level.INFO, player.abilities.mayfly);
        StarWarsInMinecraft.LOGGER.log(Level.INFO, player.abilities.invulnerable);
        StarWarsInMinecraft.LOGGER.log(Level.INFO, player.abilities.instabuild);
        return 1;
    }

    private static int creativeInventory(CommandContext<CommandSource> commandContext) throws CommandSyntaxException {
        PlayerEntity player = commandContext.getSource().getPlayerOrException();
        player.abilities.instabuild = !player.abilities.instabuild;
        player.sendMessage(ITextComponent.nullToEmpty(StarWarsInMinecraft.MESSAGE_PREFIX + "Ability to use the creative inventory has been set to " + player.abilities.instabuild), player.getUUID());
        return 1;
    }

    static int fly(CommandContext<CommandSource> commandContext) throws CommandSyntaxException {
        PlayerEntity player = commandContext.getSource().getPlayerOrException();
        player.abilities.mayfly = !player.abilities.mayfly;
        player.sendMessage(ITextComponent.nullToEmpty(StarWarsInMinecraft.MESSAGE_PREFIX + "Ability to fly has been set to " + player.abilities.mayfly), player.getUUID());
        StarWarsInMinecraft.LOGGER.log(Level.INFO, player.abilities.mayfly);
        return 1;
    }
    static int invulnerable(CommandContext<CommandSource> commandContext) throws CommandSyntaxException {
        PlayerEntity player = commandContext.getSource().getPlayerOrException();
        player.abilities.invulnerable = !player.abilities.invulnerable;
        player.sendMessage(ITextComponent.nullToEmpty(StarWarsInMinecraft.MESSAGE_PREFIX + "Invulnerability has been set to " + player.abilities.invulnerable), player.getUUID());
        StarWarsInMinecraft.LOGGER.log(Level.INFO, player.abilities.invulnerable);
        return 1;
    }
    static int flying(CommandContext<CommandSource> commandContext) throws CommandSyntaxException {
        PlayerEntity player = commandContext.getSource().getPlayerOrException();
        player.abilities.flying = !player.abilities.flying;
        player.sendMessage(ITextComponent.nullToEmpty(StarWarsInMinecraft.MESSAGE_PREFIX + "Flight has been set to " + player.abilities.flying), player.getUUID());
        StarWarsInMinecraft.LOGGER.log(Level.INFO, player.abilities.flying);
        return 1;
    }
}
