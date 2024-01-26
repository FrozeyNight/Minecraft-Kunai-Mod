package net.bartek.kunaimod.event;

import net.bartek.kunaimod.KunaiMod;
import net.bartek.kunaimod.entities.ModEntities;
import net.bartek.kunaimod.entities.projectile.ThrownKunai;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = KunaiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        //event.put(ModEntities.THROWN_KUNAI.get(), ThrownKunai.createAttributes().build());
    }
}
