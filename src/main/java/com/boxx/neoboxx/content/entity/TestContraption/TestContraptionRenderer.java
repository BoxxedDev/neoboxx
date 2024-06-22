package com.boxx.neoboxx.content.entity.TestContraption;

import com.boxx.neoboxx.Neoboxx;
import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.FallingBlockRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Vector3fc;

public class TestContraptionRenderer extends EntityRenderer<TestContraptionEntity> {
    public TestContraptionRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(TestContraptionEntity pEntity) {
        return null;
    }

    @Override
    public void render(TestContraptionEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
        BlockRenderDispatcher blockRenderDispatcher = Minecraft.getInstance().getBlockRenderer();

        Quaternionf quatX = new Quaternionf().fromAxisAngleDeg(1.f,0.f,0.f, 15f);
        Quaternionf quatY = new Quaternionf().fromAxisAngleDeg(0.f,1.f,0.f, 15f);
        Quaternionf quatZ = new Quaternionf().fromAxisAngleDeg(0.f,0.f,1.f, 15f);

        pPoseStack.translate(-0.5,-0.5,-0.5);
        pPoseStack.mulPose(
                quatX.mul(quatY).mul(quatZ)
        );

        BoundingBox area = pEntity.getBlockArea();
        Level level = pEntity.level();

        if (area == null)
            return;

        Vec3 vecStart = new Vec3(area.minX(), area.minY(), area.minZ());
        Vec3 vecEnd = new Vec3(area.maxX(), area.maxY(), area.maxZ());

        /*

        for (BlockPos pos : BlockPos.betweenClosed(
                area.minX(), area.minY(), area.minZ(), area.maxX(), area.maxY(), area.maxZ())) {
            BlockState state = level.getBlockState(pos);
            blockRenderDispatcher.renderBatched(
                    state,
                    pos,
                    level,
                    pPoseStack,
                    pBuffer.getBuffer(RenderType.cutout()),
                    true,
                    RandomSource.createNewThreadLocalInstance());
        }

         */
        BlockState state = level.getBlockState(
                new BlockPos(
                        (int) vecStart.x,
                        (int) vecStart.y,
                        (int) vecStart.z)
        );

        Neoboxx.LOGGER.info(String.valueOf(state));

        blockRenderDispatcher.renderSingleBlock(
                state,
                pPoseStack,
                pBuffer,
                pPackedLight,
                OverlayTexture.NO_OVERLAY
        );
    }
}
