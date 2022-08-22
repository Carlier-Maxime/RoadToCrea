package fr.metouais.roadtocrea.item;

import fr.metouais.roadtocrea.RoadToCrea;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemWithRemainingItem extends Item {
    private final Item remainingItem;

    public ItemWithRemainingItem(Item remainingItem, Properties p_41383_) {
        super(p_41383_);
        this.remainingItem = remainingItem;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return remainingItem.getDefaultInstance();
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}
