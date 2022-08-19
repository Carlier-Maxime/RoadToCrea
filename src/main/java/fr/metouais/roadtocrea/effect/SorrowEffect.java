package fr.metouais.roadtocrea.effect;

import fr.metouais.roadtocrea.init.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundCustomSoundPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class SorrowEffect extends MobEffect {
    private boolean playing;
    private long timeStartSound;

    public SorrowEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
        playing = false;
        timeStartSound = 0;
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level.isClientSide() || !(livingEntity instanceof Player player)) return;
        ServerPlayer serverPlayer = (ServerPlayer) player;
        if (!playing) {
            BlockPos pos = player.blockPosition();
            Vec3 vec3 = new Vec3(pos.getX(), pos.getY(), pos.getZ());
            serverPlayer.connection.send(new ClientboundCustomSoundPacket(ModSounds.SORROW.getId(), SoundSource.PLAYERS, vec3, 1f, 1f, 0));
            playing = true;
            timeStartSound = player.level.getGameTime();
        } else if (player.level.getGameTime() >= timeStartSound+20*3.5) {
            playing = false;
        }
        Vec3 pos =  player.position();
        RandomSource rng = player.level.getRandom();
        for (int i=0; i<4*(amplifier+1); i++) ((ServerLevel) player.level).sendParticles(serverPlayer, ParticleTypes.RAIN, false, pos.x+rng.nextFloat()-0.5, pos.y+1.5+rng.nextFloat()-0.5, pos.z+rng.nextFloat()-0.5, 0,0.1D, 0.0D, 0.1D, 0.2D);
        super.applyEffectTick(livingEntity, amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
        return true;
    }
}
