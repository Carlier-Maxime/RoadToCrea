package fr.metouais.roadtocrea.item;

import fr.metouais.roadtocrea.RoadToCrea;
import fr.metouais.roadtocrea.init.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class RainTransformableItem extends Item {
    private final ItemStack cleanItem;
    private final ItemStack dirtyItem;
    private final int maxDirtyItemCount;

    public RainTransformableItem(ItemStack cleanItem, Properties properties) {
        this(cleanItem,null, properties);
    }

    public RainTransformableItem(ItemStack cleanItem, ItemStack dirtyItem, Properties properties) {
        this(cleanItem, dirtyItem, 1, properties);
    }

    public RainTransformableItem(ItemStack cleanItem, ItemStack dirtyItem, int maxDirtyItemCount, Properties properties) {
        super(properties);
        this.cleanItem = cleanItem;
        this.dirtyItem = dirtyItem;
        this.maxDirtyItemCount = maxDirtyItemCount;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        boolean playerHasSorrow = player.hasEffect(ModEffects.SORROW.get());
        BlockPos pos = player.blockPosition();
        if (playerHasSorrow || player.level.isRainingAt(pos)) {
            player.getItemInHand(interactionHand).shrink(1);
            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), cleanItem));
            if (dirtyItem != null) {
                int max = level.getRandom().nextInt(maxDirtyItemCount+1);
                if (max<1) max=1;
                for (int i=0; i<max; i++) level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), dirtyItem));
            }
            if (playerHasSorrow) {
                MobEffectInstance sorrow = player.getEffect(ModEffects.SORROW.get());
                if (sorrow == null) return super.use(level, player, interactionHand);
                int duration = sorrow.getDuration();
                player.removeEffect(sorrow.getEffect());
                player.addEffect(new MobEffectInstance(ModEffects.SORROW.get(), duration-100));
            }
        }
        return super.use(level, player, interactionHand);
    }
}
