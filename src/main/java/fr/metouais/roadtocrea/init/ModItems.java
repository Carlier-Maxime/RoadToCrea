package fr.metouais.roadtocrea.init;

import fr.metouais.roadtocrea.RoadToCrea;
import fr.metouais.roadtocrea.item.*;
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
    public static final RegistryObject<Item> CRAFTING_CHISEL = ITEMS.register("crafting_chisel", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> CRAFTING_HAMMER = ITEMS.register("crafting_hammer", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> CRAFTING_SAW = ITEMS.register("crafting_saw", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> MANGROVE_CRAFTING_ALL_SIDE = ITEMS.register("mangrove_crafting_all_side", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> MANGROVE_CRAFTING_ALL_SIDE_STACK = ITEMS.register("mangrove_crafting_all_side_stack", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> MANGROVE_PLANK = ITEMS.register("mangrove_plank", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> MANGROVE_PLANK_GRID = ITEMS.register("mangrove_plank_grid", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> PACKED_STICK = ITEMS.register("packed_stick", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> STICK_FRAME = ITEMS.register("stick_frame", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> STICK_GRID = ITEMS.register("stick_grid", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> TOOL_ROD = ITEMS.register("tool_rod", () -> new Item(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
    public static final RegistryObject<Item> UNIVERSE_ESSENCE = ITEMS.register("universe_essence", () -> new UniverseEssenceItem(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
}
