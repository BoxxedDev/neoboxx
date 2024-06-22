package com.boxx.neoboxx.utils;

import com.boxx.neoboxx.Neoboxx;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class MainUtils {
    public static ResourceLocation location(String path) {
        return new ResourceLocation(Neoboxx.MODID, path);
    }

    public static <DR extends DeferredRegister<T>, T> DR createRegister(Function<String, DR> factory) {
        return registerToBus(factory.apply(Neoboxx.MODID));
    }

    public static <T> DeferredRegister<T> createRegister(ResourceKey<Registry<T>> registry) {
        return registerToBus(DeferredRegister.create(registry, Neoboxx.MODID));
    }

    private static <DR extends DeferredRegister<T>, T> DR registerToBus(DR deferredRegister) {
        deferredRegister.register(Neoboxx.getEventBus());
        return deferredRegister;
    }
}
