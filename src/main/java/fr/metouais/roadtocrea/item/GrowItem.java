package fr.metouais.roadtocrea.item;

import fr.metouais.roadtocrea.RoadToCrea;
import fr.metouais.roadtocrea.init.ModBlocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GrowItem extends Item{
    private final ItemStack growingResult;
    public GrowItem(ItemStack growingResult, Properties p_41383_) {
        super(p_41383_);
        this.growingResult = growingResult;
    }

    @Override
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int itemSlot, boolean isSelected) {
        super.inventoryTick(itemStack, level, entity, itemSlot, isSelected);
        if (level.isClientSide() && !(entity instanceof Player)) return;
        Player player = (Player) entity;
        long gameTime = level.getGameTime();
        long stepStartTime = getStepStartTime(itemStack);
        int delayStep = level.getBlockState(entity.blockPosition().below()).getBlock().equals(ModBlocks.ULTIMATE_BEDROCK.get()) ? 600 : 1200;
        if (gameTime > stepStartTime) {
            if (stepStartTime <= 0) setStepStartTime(itemStack, gameTime);
            else if (gameTime - stepStartTime > delayStep) {
                nextStep(itemStack);
                setStepStartTime(itemStack, gameTime);
                if (getStep(itemStack) > 3) {
                    int count = itemStack.getCount();
                    itemStack.shrink(count);
                    growingResult.setCount(count);
                    player.getInventory().add(itemSlot, growingResult);
                }
            }
        }
    }

    private void setStep(ItemStack stack, int i) {
        stack.getOrCreateTag().putInt("step", i);
    }

    @Override
    public @NotNull ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        setStep(stack, 0);
        setStepStartTime(stack, -1);
        return stack;
    }

    public int getStep(ItemStack stack) {
        return stack.getOrCreateTag().getInt("step");
    }

    private void nextStep(ItemStack stack) {
        setStep(stack, getStep(stack)+1);
    }

    private void setStepStartTime(ItemStack stack, long i) {
        stack.getOrCreateTag().putLong("stepStartTime", i);
    }

    private long getStepStartTime(ItemStack stack) {
        return stack.getOrCreateTag().getLong("stepStartTime");
    }
}
