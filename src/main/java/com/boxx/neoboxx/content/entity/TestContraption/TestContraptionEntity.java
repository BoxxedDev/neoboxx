package com.boxx.neoboxx.content.entity.TestContraption;

import com.boxx.neoboxx.Neoboxx;
import com.boxx.neoboxx.content.BoxxEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class TestContraptionEntity extends Entity {
    private Vec3 vecStart;
    private Vec3 vecEnd;
    private BoundingBox blockArea;

    public TestContraptionEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public TestContraptionEntity(Level pLevel) {
        super(BoxxEntityTypes.TEST_CONTRAPTION_ENTITY.get(), pLevel);

    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Area")) {
            int[] blockAreaIntArray = pCompound.getIntArray("Area");
            this.blockArea = new BoundingBox(
                    blockAreaIntArray[0],
                    blockAreaIntArray[1],
                    blockAreaIntArray[2],
                    blockAreaIntArray[3],
                    blockAreaIntArray[4],
                    blockAreaIntArray[5]
            );
        };
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        int[] blockAreaIntArray = {
                this.blockArea.minX(),
                this.blockArea.minY(),
                this.blockArea.minZ(),
                this.blockArea.maxX(),
                this.blockArea.maxY(),
                this.blockArea.maxZ()
        };

        if (this.blockArea != null) {
            pCompound.putIntArray("Area", blockAreaIntArray);
        }
    }

    @Override
    public void setPos(double x, double y, double z) {
        super.setPos(x, y, z);

        //setBoundingBox(new AABB(vecStart, vecEnd).move(position()));
    }

    public void setBlockArea(BoundingBox pArea) {
        this.blockArea = pArea;
    }

    public BoundingBox getBlockArea() {
        return blockArea;
    }

    @Override
    public InteractionResult interactAt(Player pPlayer, Vec3 pVec, InteractionHand pHand) {
        return InteractionResult.SUCCESS;
    }
}
