package fr.metouais.roadtocrea.init;

import fr.metouais.roadtocrea.RoadToCrea;
import fr.metouais.roadtocrea.item.KnifeItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RoadToCrea.MODID);

    public static final RegistryObject<Item> TINY_COBBLESTONE_PEBBLE = ITEMS.register("tiny_cobblestone_pebble", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> COBBLESTONE_PEBBLE = ITEMS.register("cobblestone_pebble", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> BIG_COBBLESTONE_PEBBLE = ITEMS.register("big_cobblestone_pebble", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> COBBLESTONE_KNIFE = ITEMS.register("cobblestone_knife", () -> new KnifeItem(Tiers.WOOD,2,0.1f,new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> RAW_HUMAN_MEAT = ITEMS.register("raw_human_meat", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB).food((new FoodProperties.Builder()).nutrition(25).saturationMod(12.5f).effect(new MobEffectInstance(MobEffects.HUNGER, 250), 0.9f).effect(new MobEffectInstance(MobEffects.CONFUSION, 1200, 9), 1f).effect(new MobEffectInstance(MobEffects.POISON, 60), 0.1f).meat().build())));
    public static final RegistryObject<Item> TINY_DIRTY_COBBLESTONE_PEBBLE = ITEMS.register("tiny_dirty_cobblestone_pebble", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> DIRTY_COBBLESTONE_PEBBLE = ITEMS.register("dirty_cobblestone_pebble", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> BIG_DIRTY_COBBLESTONE_PEBBLE = ITEMS.register("big_dirty_cobblestone_pebble", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
}
