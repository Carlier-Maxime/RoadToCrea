package fr.metouais.roadtocrea.block;

import fr.metouais.roadtocrea.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class UltimateBedrockBlock extends Block {
    public UltimateBedrockBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public float getDestroyProgress(@NotNull BlockState blockState, @NotNull Player player, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        player.hurt(new DamageSource("ultimate_bedrock"), 1f);
        player.causeFoodExhaustion(1f);
        if (player.blockPosition().equals(blockPos.above()) && player.getMainHandItem().isEmpty()) {
            if (player.level.getRandom().nextInt(100) <= 10) {
                popResource(player.level, blockPos.above(), new ItemStack(ModItems.TINY_COBBLESTONE_PEBBLE::get));
            }
        }
        return super.getDestroyProgress(blockState, player, blockGetter, blockPos);
    }
}
