package com.eilfyt.starwarsinminecraft.commands;

import com.eilfyt.starwarsinminecraft.StarWarsInMinecraft;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.MessageArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ChatVisibility;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Explosion;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.apache.logging.log4j.Level;

public class NukeCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralArgumentBuilder<CommandSource> createexplosion
                = Commands.literal("createexplosion").requires((commandSource) -> commandSource.hasPermission(2))
                .then(Commands.argument("radius", IntegerArgumentType.integer(1, 500))
                                        .executes(NukeCommand::explosion));

        dispatcher.register(createexplosion);
    }

    static int explosion(CommandContext<CommandSource> commandContext) throws CommandSyntaxException {
        int radius = IntegerArgumentType.getInteger(commandContext, "radius");

           commandContext.getSource().getPlayerOrException().getCommandSenderWorld().explode(commandContext.getSource().getPlayerOrException(),
                    commandContext.getSource().getPlayerOrException().getX(),
                    commandContext.getSource().getPlayerOrException().getY(),
                    commandContext.getSource().getPlayerOrException().getZ(),
                    radius, Explosion.Mode.DESTROY);
            StarWarsInMinecraft.LOGGER.log(Level.INFO, "Successfully Created Explosion");
        commandContext.getSource().getPlayerOrException().sendMessage(ITextComponent.nullToEmpty("Successfully Created Explosion"),
                commandContext.getSource().getEntity().getUUID());
            return 1;
    }

}
