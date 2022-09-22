package fr.metouais.roadtocrea.init;

import fr.metouais.roadtocrea.RoadToCrea;
import fr.metouais.roadtocrea.item.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final ItemStack ROAD_TO_CREA_BOOK = createRoadToCreaBook();

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
    public static final RegistryObject<Item> UNIVERSE_ESSENCE = ITEMS.register("universe_essence", () -> new UniverseEssenceItem(new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB).food(ModFoods.UNIVERSE_ESSENCE)));

    private static ItemStack createRoadToCreaBook() {
        ItemStack roadToCreaBook = Items.WRITTEN_BOOK.getDefaultInstance();
        CompoundTag nbt = new CompoundTag();
        nbt.putString("title","Road To Crea");
        nbt.putString("author", "?????");
        ListTag listTag = new ListTag();
        addTextLanguage(listTag, getEnTextForRoadToCreaBook(), "English");
        addTextLanguage(listTag, getFrTextForRoadToCreaBook(), "Français");
        nbt.put("pages", listTag);
        roadToCreaBook.setTag(nbt);
        return roadToCreaBook;
    }

    private static void addTextLanguage(ListTag listTag, String[] text, String lang) {
        for (int i=0; i< text.length; i++) {
            if (i==0) listTag.add(StringTag.valueOf("[{text:\""+lang+"\n\n\", color:blue},{text:\""+text[i]+"\", color:black}]"));
            else listTag.add(StringTag.valueOf("{text:\""+text[i]+"\"}"));
        }
    }

    private static String[] getEnTextForRoadToCreaBook() {
        return new String[]{
                "If you are reading this book, you are the universe's last hope. " +
                        "This one had become too unstable, between the pigs which became creeper at nightfall and the crafts which gave a random result, " +
                        "the universe can see that end is approaching.",
                "To avoid this I condensed the entire universe into a single block called the ultimate bedrock. " +
                        "The only things I haven't put together in this block are this book, you, and the remaining part of me.",
                "But back to this present. You will have to go through a long ordeal in order to recreate the world as it was before. " +
                        "Because the universe is now in your hands.",
                "To begin with,\n" +
                        "You will have to absorb part of the essence of the universe in order to be able to resonate with the ultimate bedrock and thus allow you to harvest the first resources. " +
                        "(If you can't absorb the essence of the universe, try eating it)",
                "Once the essence is absorbed, simply tap the ultimate bedrock by hand, staying above it. " +
                        "It is indeed necessary that you are above the block so that the little essence universe that you possess resonates with the ultimate bedrock",
                "So that you can pass the first layer of protection of the ultimate bedrock. " +
                        "The resources you will get should allow you to craft a cobblestone knife in order to recover meat from the living being present...",
                "And yes, you unfortunately understood what that meant. " +
                "If you're low on strength, resonate with the ultimate bedrock as much as possible by crouching over it."
        };
    }

    private static String[] getFrTextForRoadToCreaBook() {
        return new String[]{
                "Si vous lisez ce livre c'est que vous êtes le dernier espoire de l'univers. " +
                        "Celui-ci était devenu trop instable, entre les cochon qui devenait creeper à la tomber de la nuit et les craft qui donnait un résultat aléatoire, " +
                        "l'univers voyez ça fin aprocher.",
                "Pour éviter cela j'ai condenser l'intégraliter de l'univers en un unique bloc appelait l'ultime bedrock. " +
                        "Les seul chose que je n'ai pas réunie dans ce block sont ce livre, vous, et la partie restante de moi.",
                "Mais revenont à ce présent. Il va vous falloir traverser une longue épreuve afin de recréer le monde telle qu'il était auparavant. " +
                        "Car l'univers est désormais entre vos main.",
                "Pour commencer il va falloir que vous absorber une partie de l'essence de l'univers afin de pouvoir entrer en résonance avec l'ultimate bedrock et ainsi vous permettre de récolter les première resource. " +
                        "(si vous arrivez pas à l'absorber, essayez de la manger)",
                "Une fois l'essence absorber, taper simplement l'ultimate bedrock à la main en restant au dessus de celle ci. " +
                        "Il est en effet nécessaire que vous soyez au dessus du bloc pour que le peu d'univers essence que vous posséder entre en résonance avec l'ultimate bedrock",
                "Afin de pouvoir passer la première couche de protection de l'ultimate bedrock. " +
                        "Les resources que vous obtiendrai devrait vous permettre de crafter un couteau en cobblestone afin de récupérer de la viande sur l'être vivant présent...",
                "Et Ouais, vous avez malheureusement bien compris ce que ceci signifier. " +
                        "Si la force vous manque entrer le plus possible en résonance avec l'ultimate bedrock en vous accroupissant au dessus de celle ci."
        };
    }
}
