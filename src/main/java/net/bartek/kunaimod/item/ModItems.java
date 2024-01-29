package net.bartek.kunaimod.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.bartek.kunaimod.KunaiMod;
import net.bartek.kunaimod.item.custom.KunaiItem;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KunaiMod.MOD_ID);

    //public static final RegistryObject<Item> KUNAI = ITEMS.register("kunai",
      //      () -> new KunaiItem(createDefaultModifiers()));

    public static final RegistryObject<Item> KUNAI = ITEMS.register("kunai",
            () -> new KunaiItem(Tiers.NETHERITE,2, -2,new Item.Properties().stacksTo(1).fireResistant().durability(2500)));

    public static final RegistryObject<Item> IRON_KUNAI = ITEMS.register("iron_kunai",
            () -> new IronKunaiItem(Tiers.NETHERITE,0, -2,new Item.Properties().stacksTo(1).fireResistant().durability(750)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
