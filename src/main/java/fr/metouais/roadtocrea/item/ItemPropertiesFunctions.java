package fr.metouais.roadtocrea.item;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ItemPropertiesFunctions {
    public interface NbtStep extends ClampedItemPropertyFunction {
        @Override
        default float unclampedCall(@NotNull ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity living, int id) {
            if (stack.getItem() instanceof GrowItem growItem) {
                return growItem.getStep(stack)/10f;
            }
            return 0.0f;
        }
    }
}
