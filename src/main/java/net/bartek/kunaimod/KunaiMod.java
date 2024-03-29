package net.bartek.kunaimod;

import com.mojang.logging.LogUtils;
import net.bartek.kunaimod.entities.ModEntities;
import net.bartek.kunaimod.entities.client.ThrownKunaiRenderer;
import net.bartek.kunaimod.item.ModCreativeModTabs;
import net.bartek.kunaimod.item.ModItems;
import net.bartek.kunaimod.networking.ModMessages;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;

import javax.swing.text.JTextComponent;
import java.util.Arrays;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(KunaiMod.MOD_ID)
public class KunaiMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "kunaimod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public KunaiMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        ModItems.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);

        ModEntities.register(modEventBus);


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);


    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(ModMessages::register);
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.THROWN_KUNAI.get(), ThrownKunaiRenderer::new);
            EntityRenderers.register(ModEntities.IRON_THROWN_KUNAI.get(), IronThrownKunaiRenderer::new);
        }
    }
}
