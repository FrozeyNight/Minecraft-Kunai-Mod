package net.bartek.kunaimod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_KUNAI = "key.category.kunaimod.kunai";
    public static final String KEY_TELEPORTING_TO_KUNAI = "key.kunaimod.teleporting_to_kunai";

    public static final KeyMapping TELEPORTING_KEY = new KeyMapping(KEY_TELEPORTING_TO_KUNAI, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_CATEGORY_KUNAI);
}
