package fr.metouais.roadtocrea.item;

import fr.metouais.roadtocrea.init.ModBlocks;
import fr.metouais.roadtocrea.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class KnifeItem extends SwordItem {
    public KnifeItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext useOnContext) {
        Player player = useOnContext.getPlayer();
        if (player == null) return super.useOn(useOnContext);
        Level level = useOnContext.getLevel();
        if (player.isCrouching() && level.getBlockState(player.blockPosition().below()).getBlock().equals(ModBlocks.ULTIMATE_BEDROCK.get())) {
            player.hurt(new DamageSource("cobblestone_knife"), this.getDamage()*3);
            player.causeFoodExhaustion(3f);
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1800));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1800));
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1800));
            player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100));
            BlockPos pos = player.blockPosition();
            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), ModItems.RAW_HUMAN_MEAT.get().getDefaultInstance()));
            useOnContext.getItemInHand().hurtAndBreak(4, player, (param) -> param.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
        return super.useOn(useOnContext);
    }
}
