package net.bartek.kunaimod.enchantment;

import net.bartek.kunaimod.KunaiMod;
import net.bartek.kunaimod.item.ModItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, KunaiMod.MOD_ID);

    public static RegistryObject<Enchantment> KUNAI_TELEPORTATION = ENCHANTMENTS.register("kunai_teleportation",
            () -> new KunaiTeleportationEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static RegistryObject<Enchantment> KUNAI_EXPLOSION = ENCHANTMENTS.register("kunai_explosion",
            () -> new KunaiExplosionEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static RegistryObject<Enchantment> KUNAI_GRAVITY_PULL = ENCHANTMENTS.register("kunai_gravity_pull",
            () -> new KunaiGravityPullEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static RegistryObject<Enchantment> KUNAI_BLINDING = ENCHANTMENTS.register("kunai_blinding",
            () -> new KunaiBlindingEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus){
        ENCHANTMENTS.register(eventBus);
    }
}
