package com.boxx.neoboxx;

import com.boxx.neoboxx.content.BoxxEntityTypes;
import com.boxx.neoboxx.content.entity.TestContraption.TestContraptionRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@SuppressWarnings("removal")
@Mod.EventBusSubscriber(modid = Neoboxx.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NeoboxxClient {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {

    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(BoxxEntityTypes.TEST_CONTRAPTION_ENTITY.get(), TestContraptionRenderer::new);
    }
}
