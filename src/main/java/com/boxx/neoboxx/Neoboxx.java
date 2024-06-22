package com.boxx.neoboxx;

import com.boxx.neoboxx.content.BoxxEntityTypes;
import com.boxx.neoboxx.content.BoxxItems;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@SuppressWarnings({"removal", "deprecation", "all"})
@Mod(Neoboxx.MODID)
public class Neoboxx
{
    private static Neoboxx INSTANCE;
    public static final String MODID = "neoboxx";
    public static final Logger LOGGER = LogUtils.getLogger();
    private final IEventBus modEventBus;

    public Neoboxx(IEventBus modEventBus)
    {
        this.modEventBus = modEventBus;
        INSTANCE = this;

        BoxxEntityTypes.staticInit();
        BoxxItems.staticInit();

        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }


    public static IEventBus getEventBus() {
        return INSTANCE.modEventBus;
    }
}
