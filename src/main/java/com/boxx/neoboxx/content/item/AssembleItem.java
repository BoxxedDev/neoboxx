package com.boxx.neoboxx.content.item;

import com.boxx.neoboxx.content.entity.TestContraption.TestContraptionEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AssembleItem extends Item {
    private Vec3 startVec;
    private Vec3 endVec;

    public AssembleItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {



        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Vec3 pos = pContext.getClickedPos().getCenter();
        if (startVec == null) {
            startVec = pos;
        } else {
            endVec = pos;
            TestContraptionEntity contraptionEntity = new TestContraptionEntity(pContext.getLevel());
            contraptionEntity.setPos(pos);
            pContext.getLevel().addFreshEntity(contraptionEntity);
            startVec = null;
            endVec = null;
        }
        return super.useOn(pContext);
    }
}
