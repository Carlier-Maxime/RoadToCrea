package fr.metouais.roadtocrea.item;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public final class ItemPropertiesFunctions {
    public static float getNbtStep(ItemStack stack, ClientLevel level, LivingEntity living, int id) {
        if (stack.getItem() instanceof GrowItem growItem) {
            return growItem.getStep(stack)/10f;
        }
        return 0.0f;
    }
}
