package fr.metouais.roadtocrea.item;

import fr.metouais.roadtocrea.init.ModItems;
import net.minecraft.network.protocol.game.ClientboundCustomSoundPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class MossyDirtPebbleItem extends Item {
    public MossyDirtPebbleItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return ModItems.DIRT_PEBBLE.get().getDefaultInstance();
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}
