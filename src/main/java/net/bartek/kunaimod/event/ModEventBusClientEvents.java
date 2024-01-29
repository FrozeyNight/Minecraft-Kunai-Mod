package net.bartek.kunaimod.event;

import net.bartek.kunaimod.KunaiMod;
import net.bartek.kunaimod.entities.client.ModModelLayers;
import net.bartek.kunaimod.entities.client.ThrownKunaiModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = KunaiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.THROWN_KUNAI_LAYER, ThrownKunaiModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.IRON_THROWN_KUNAI_LAYER, IronThrownKunaiModel::createBodyLayer);
    }
}
