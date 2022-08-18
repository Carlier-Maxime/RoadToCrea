package fr.metouais.roadtocrea.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
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
        player.hurt(new DamageSource("ultimate_bedrock"), 0.5f);
        player.causeFoodExhaustion(1f);
        return super.getDestroyProgress(blockState, player, blockGetter, blockPos);
    }
}
