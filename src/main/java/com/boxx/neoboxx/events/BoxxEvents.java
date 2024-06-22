package com.boxx.neoboxx.events;

import com.boxx.neoboxx.Neoboxx;
import com.boxx.neoboxx.content.commands.AssembleCommand;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = Neoboxx.MODID)
public class BoxxEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new AssembleCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

}
