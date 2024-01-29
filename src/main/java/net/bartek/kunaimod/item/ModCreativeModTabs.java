package net.bartek.kunaimod.item;

import net.bartek.kunaimod.KunaiMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KunaiMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("kunaimod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KUNAI.get()))
                    .title(Component.translatable("creativetab.kunaimod_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.KUNAI.get());
                        pOutput.accept(ModItems.IRON_KUNAI.get());

                    })
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
