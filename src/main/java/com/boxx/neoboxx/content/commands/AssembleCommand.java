package com.boxx.neoboxx.content.commands;

import com.boxx.neoboxx.Neoboxx;
import com.boxx.neoboxx.content.entity.TestContraption.TestContraptionEntity;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.server.commands.FillCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.Vec3;

public class AssembleCommand {
    public AssembleCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("assemble")
                .then(
                        Commands.argument("from", BlockPosArgument.blockPos())
                                .then(
                                        Commands.argument("to", BlockPosArgument.blockPos())
                                                .executes((command) ->
                                                        assemble(
                                                                command.getSource(),
                                                                BoundingBox.fromCorners(
                                                                        BlockPosArgument.getLoadedBlockPos(command, "from"),
                                                                        BlockPosArgument.getLoadedBlockPos(command, "to")
                                                                )
                                                        )
                                                )
                                )
                        )

        );
    }

    private int assemble(CommandSourceStack sourceStack, BoundingBox pArea) throws CommandSyntaxException {
        ServerPlayer player = sourceStack.getPlayer();
        Level level = player.level();

        TestContraptionEntity contraptionEntity = new TestContraptionEntity(level);
        contraptionEntity.setPos(new Vec3(player.getX(),player.getY(),player.getZ()));
        contraptionEntity.setBlockArea(pArea);

        level.addFreshEntity(contraptionEntity);

        return 1;
    }
}
