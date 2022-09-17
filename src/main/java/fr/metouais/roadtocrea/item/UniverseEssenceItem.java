package fr.metouais.roadtocrea.item;

import fr.metouais.roadtocrea.universeEssence.PlayerUniverseEssenceProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
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
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        if (player instanceof ServerPlayer) {
            player.getCapability(PlayerUniverseEssenceProvider.PLAYER_UNIVERSE_ESSENCE).ifPresent(universeEssence -> {
                universeEssence.addUniverseEssence(1);
                player.getItemInHand(interactionHand).shrink(1);
                player.sendSystemMessage(Component.literal("§3You have absorbed universe essence"));
            });
        }
        return super.use(level, player, interactionHand);
    }
}
