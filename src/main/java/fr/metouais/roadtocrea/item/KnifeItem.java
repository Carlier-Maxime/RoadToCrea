package fr.metouais.roadtocrea.item;

import fr.metouais.roadtocrea.RoadToCrea;
import fr.metouais.roadtocrea.init.ModBlocks;
import fr.metouais.roadtocrea.init.ModEffects;
import fr.metouais.roadtocrea.init.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundCustomSoundPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class KnifeItem extends SwordItem {
    private Player playerCrafter;

    public KnifeItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
        this.playerCrafter = null;
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext useOnContext) {
        Player player = useOnContext.getPlayer();
        if (!(player instanceof ServerPlayer)) return super.useOn(useOnContext);
        Level level = useOnContext.getLevel();
        if (player.isCrouching() && level.getBlockState(player.blockPosition().below()).getBlock().equals(ModBlocks.ULTIMATE_BEDROCK.get())) {
            player.hurt(new DamageSource("knife"), this.getDamage()*3);
            player.causeFoodExhaustion(3f);
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1800));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1800));
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1800));
            player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100));
            player.addEffect(new MobEffectInstance(ModEffects.SORROW.get(), 500));
            BlockPos pos = player.blockPosition();
            ServerPlayer serverPlayer = (ServerPlayer) player;
            if (serverPlayer.getStats().getValue(Stats.ITEM_PICKED_UP.get(ModItems.RAW_HUMAN_MEAT.get())) < 1) {
                level.addFreshEntity(new ItemEntity(level,pos.getX(), pos.getY(), pos.getZ(), ModItems.UNIVERSE_ESSENCE.get().getDefaultInstance()));
                level.addFreshEntity(new ItemEntity(level,pos.getX(), pos.getY(), pos.getZ(), ModItems.ROAD_TO_CREA_BOOK_PART_2));
            }
            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), ModItems.RAW_HUMAN_MEAT.get().getDefaultInstance()));
            useOnContext.getItemInHand().hurtAndBreak(4, player, (param) -> param.broadcastBreakEvent(EquipmentSlot.MAINHAND));
            player.setInvulnerable(false);
            player.invulnerableTime = 0;
        }
        return super.useOn(useOnContext);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack remainingItem = getDefaultInstance();
        ServerPlayer serverPlayer = (ServerPlayer) playerCrafter;
        remainingItem.hurt(3+itemStack.getDamageValue(), RandomSource.create(), serverPlayer);
        if (remainingItem.getDamageValue()>remainingItem.getMaxDamage()) {
            remainingItem.shrink(1);
            if (serverPlayer != null) {
                Vec3 vec3 = playerCrafter.position();
                serverPlayer.connection.send(new ClientboundCustomSoundPacket(SoundEvents.ITEM_BREAK.getLocation(), SoundSource.PLAYERS, vec3, 1f, 1f, 0));
            }
        }
        return remainingItem;
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public void onCraftedBy(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Player player) {
        this.playerCrafter = player;
        super.onCraftedBy(itemStack, level, player);
    }
}
