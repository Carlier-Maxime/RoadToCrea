package fr.metouais.roadtocrea.item;

import fr.metouais.roadtocrea.universeEssence.PlayerUniverseEssenceProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class UniverseEssenceItem extends Item {
    public UniverseEssenceItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack p_41409_, Level p_41410_, LivingEntity livingEntity) {
        ItemStack itemStack = super.finishUsingItem(p_41409_, p_41410_, livingEntity);
        if (livingEntity instanceof Player player && player instanceof ServerPlayer) {
            player.getCapability(PlayerUniverseEssenceProvider.PLAYER_UNIVERSE_ESSENCE).ifPresent(universeEssence -> {
                universeEssence.addUniverseEssence(1);
                MutableComponent component = Component.translatable("item.roadtocrea.universe_essence.consume");
                component.setStyle(component.getStyle().withColor(43690));
                player.sendSystemMessage(component);
            });
        }
        return itemStack;
    }
}
