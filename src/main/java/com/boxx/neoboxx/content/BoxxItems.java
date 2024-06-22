package com.boxx.neoboxx.content;

import com.boxx.neoboxx.content.item.AssembleItem;
import com.boxx.neoboxx.utils.MainUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BoxxItems {
    public static final DeferredRegister.Items ITEMS = MainUtils.createRegister(DeferredRegister::createItems);

    public static final DeferredItem<AssembleItem> ASSEMBLE_ITEM =  register("assemble_item", () -> new AssembleItem(new Item.Properties()));

    private static <T extends Item> DeferredItem<T> register(String id, Supplier<T> pIProp) {
        return ITEMS.register(id.toLowerCase(), pIProp);
    }

    public static void staticInit() {

    }
}
