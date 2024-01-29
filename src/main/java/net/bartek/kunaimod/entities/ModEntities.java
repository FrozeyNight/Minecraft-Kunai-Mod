package net.bartek.kunaimod.entities;

import net.bartek.kunaimod.KunaiMod;
import net.bartek.kunaimod.entities.projectile.IronThrownKunai;
import net.bartek.kunaimod.entities.projectile.ThrownKunai;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, KunaiMod.MOD_ID);


    public static final RegistryObject<EntityType<ThrownKunai>> THROWN_KUNAI =
            ENTITY_TYPES.register("thrown_kunai", () -> EntityType.Builder.<ThrownKunai>of(ThrownKunai::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("thrown_kunai"));

    public static final RegistryObject<EntityType<IronThrownKunai>> IRON_THROWN_KUNAI =
            ENTITY_TYPES.register("iron_thrown_kunai", () -> EntityType.Builder.<IronThrownKunai>of(IronThrownKunai::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("iron_thrown_kunai"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
