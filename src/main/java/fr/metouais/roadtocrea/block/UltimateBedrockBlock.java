package fr.metouais.roadtocrea.block;

import fr.metouais.roadtocrea.init.ModItems;
import fr.metouais.roadtocrea.universeEssence.PlayerUniverseEssenceProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicBoolean;

public class UltimateBedrockBlock extends Block {
    public UltimateBedrockBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public float getDestroyProgress(@NotNull BlockState blockState, @NotNull Player player, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        if (!(player instanceof ServerPlayer)) return super.getDestroyProgress(blockState, player, blockGetter, blockPos);
        player.hurt(new DamageSource("ultimate_bedrock"), 0.8f);
        player.causeFoodExhaustion(0.5f);
        MutableComponent component = Component.translatable("block.roadtocrea.ultimate_bedrock.dig.fail");
        component.setStyle(component.getStyle().withColor(16733525));
        AtomicBoolean hasUniverseEssence = new AtomicBoolean(false);
        player.getCapability(PlayerUniverseEssenceProvider.PLAYER_UNIVERSE_ESSENCE).ifPresent(universeEssence -> {
            if (universeEssence.getUniverseEssence()>0) hasUniverseEssence.set(true);
        });
        if (!hasUniverseEssence.get()) player.sendSystemMessage(component);
        else if (player.blockPosition().equals(blockPos.above()) && player.getMainHandItem().isEmpty()) {
            if (player.level.getRandom().nextInt(100) <= 10) {
                popResource(player.level, blockPos.above(), new ItemStack(ModItems.TINY_COBBLESTONE_PEBBLE::get));
                if (player.level.getRandom().nextInt(100) <= 15) {
                    popResource(player.level, blockPos.above(), new ItemStack(ModItems.TINY_DIRTY_COBBLESTONE_PEBBLE::get));
                }
            }
        }
        return super.getDestroyProgress(blockState, player, blockGetter, blockPos);
    }
}
