package com.boxx.neoboxx.content;

import com.boxx.neoboxx.content.entity.TestContraption.TestContraptionEntity;
import com.boxx.neoboxx.content.entity.TestContraption.TestContraptionRenderer;
import com.boxx.neoboxx.utils.MainUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BoxxEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = MainUtils.createRegister(Registries.ENTITY_TYPE);

    //public static final DeferredHolder<EntityType<?>, EntityType<TestContraptionEntity>> TEST_CONTRAPTION_ENTITY = ENTITY_TYPES.register("test_contraption_entity",
    //        () -> EntityType.Builder.of((EntityType.EntityFactory<TestContraptionEntity>)TestContraptionEntity::new, MobCategory.MISC).build("test_contraption_entity"));

    public static final DeferredHolder<EntityType<?>, EntityType<TestContraptionEntity>> TEST_CONTRAPTION_ENTITY = register(
            "test_contraption_entity",
            EntityType.Builder.of((EntityType.EntityFactory<TestContraptionEntity>) TestContraptionEntity::new, MobCategory.MISC));



    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(
            String id, EntityType.Builder pEntityBuilder
    ) {
        return ENTITY_TYPES.register(id, () -> pEntityBuilder.build(id));
    }

    public static void staticInit() {

    }
}
