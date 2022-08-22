package fr.metouais.roadtocrea.init;

import fr.metouais.roadtocrea.RoadToCrea;
import fr.metouais.roadtocrea.item.GrowItem;
import fr.metouais.roadtocrea.item.ItemWithRemainingItem;
import fr.metouais.roadtocrea.item.RainTransformableItem;
import fr.metouais.roadtocrea.item.KnifeItem;
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
    public static final RegistryObject<Item> TINY_MUD_PEBBLE = ITEMS.register("tiny_mud_pebble", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> MUD_PEBBLE = ITEMS.register("mud_pebble", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> BIG_MUD_PEBBLE = ITEMS.register("big_mud_pebble", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> COBBLESTONE_KNIFE = ITEMS.register("cobblestone_knife", () -> new KnifeItem(Tiers.WOOD,2,0.1f,new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> RAW_HUMAN_MEAT = ITEMS.register("raw_human_meat", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB).food(ModFoods.RAW_HUMAN_MEAT)));
    public static final RegistryObject<Item> TINY_DIRTY_COBBLESTONE_PEBBLE = ITEMS.register("tiny_dirty_cobblestone_pebble", () -> new RainTransformableItem(TINY_COBBLESTONE_PEBBLE.get(), new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> DIRTY_COBBLESTONE_PEBBLE = ITEMS.register("dirty_cobblestone_pebble", () -> new RainTransformableItem(COBBLESTONE_PEBBLE.get(), TINY_MUD_PEBBLE.get(), new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> BIG_DIRTY_COBBLESTONE_PEBBLE = ITEMS.register("big_dirty_cobblestone_pebble", () -> new RainTransformableItem(BIG_COBBLESTONE_PEBBLE.get(), MUD_PEBBLE.get(), 6, new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> COOKED_HUMAN_MEAT = ITEMS.register("cooked_human_meat", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB).food(ModFoods.COOKED_HUMAN_MEAT)));
    public static final RegistryObject<Item> RAW_HUMAN_MEAT_PIECE = ITEMS.register("raw_human_meat_piece", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB).food(ModFoods.RAW_HUMAN_MEAT_PIECE)));
    public static final RegistryObject<Item> COOKED_HUMAN_MEAT_PIECE = ITEMS.register("cooked_human_meat_piece", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB).food(ModFoods.COOKED_HUMAN_MEAT_PIECE)));
    public static final RegistryObject<Item> DIRT_PEBBLE = ITEMS.register("dirt_pebble", () -> new RainTransformableItem(MUD_PEBBLE.get(), new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> MOSSY_DIRT_PEBBLE = ITEMS.register("mossy_dirt_pebble", () -> new ItemWithRemainingItem(DIRT_PEBBLE.get() ,new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> FERTILIZED_MUD_PEBBLE = ITEMS.register("fertilized_mud_pebble", () -> new GrowItem(MOSSY_DIRT_PEBBLE.get(), 4, new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> MOSS_BALL = ITEMS.register("moss_ball", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> MANGROVE_PROPAGULE_AND_MOSS_BALL = ITEMS.register("mangrove_propagule_and_moss_ball", () -> new ItemWithRemainingItem(MOSS_BALL.get() ,new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> FERTILIZED_MOSS_BALL = ITEMS.register("fertilized_moss_ball", () -> new GrowItem(MANGROVE_PROPAGULE_AND_MOSS_BALL.get(), 5, new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
}
