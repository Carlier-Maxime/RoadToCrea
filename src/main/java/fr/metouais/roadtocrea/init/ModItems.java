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
    public static final ItemStack ROAD_TO_CREA_BOOK_PART_1 = createRoadToCreaBook(0);
    public static final ItemStack ROAD_TO_CREA_BOOK_PART_2 = createRoadToCreaBook(1);

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

    private static ItemStack createRoadToCreaBook(int i) {
        ItemStack roadToCreaBook = Items.WRITTEN_BOOK.getDefaultInstance();
        CompoundTag nbt = new CompoundTag();
        nbt.putString("title","Road To Crea");
        nbt.putString("author", "?????");
        ListTag listTag = new ListTag();
        addTextLanguage(listTag, getEnTextForRoadToCreaBook()[i], "English");
        addTextLanguage(listTag, getFrTextForRoadToCreaBook()[i], "Français");
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

    private static String[][] getEnTextForRoadToCreaBook() {
        return new String[][]{
                {
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
                },
                {
                "You made it, excellent that must have been so difficult." +
                        "Now that you have collected this meat, you can eat it in order to regenerate your health.",
                "Replenishing infinite health by feeding on your own meat may seem impossible, but don't underestimate the power of the essence of the universe!" +
                        "You normally obtained a second universe essence in addition to the second part of the book.",
                "I know it's a lot of responsibility on your shoulders but you are the only hope." +
                        "In order to continue, you will need to successfully create a crafting table." +
                        "For this, here are the different steps that should allow you to achieve this objective:",
                "0) I advise you to consume the essence universe recover in order to increase the speed of resource harvesting.\n" +
                        "1) create dirty cobblestone pebble\n" +
                        "2) clean them by drying your tears.",
                "3) combine tiny mud pebble to create mud pebble.\n" +
                        "4) cut a meat into meat pieces\n" +
                        "5) combine the piece of meat with the mud pebble in order to fertilize it.",
                "6) wait until the final transformation of this one.\n" +
                        "7) detach the moss which to push on it\n" +
                        "8) fertilize the resulting moss ball\n" +
                        "9) wait until the final transformation\n" +
                        "10) collect the mangrove propagule on it\n" +
                        "11) repeat the previous operation",
                "12) make the different parts of the crafting table out of mangroves\n" +
                        "13) craft the crafting table.\n" +
                        "\n" +
                        "I know it's tedious but the crafting table is too essential to do without.\n" +
                        "\n" +
                        "Good luck.."
                }
        };
    }

    private static String[][] getFrTextForRoadToCreaBook() {
        return new String[][]{
                {
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
                },
                {
                "Vous avez réussie, excellent cela à du être si difficile. " +
                        "Maintenant que vous avez récupérer se bout de viande, vous pouvez le manger afin de régénérer votre santé. ",
                "Régénérer sa santé à l'infini en se nourissant de ça propre viande peut sembler impossible, mais ne sous estimer pas le pouvoir de l'essence de l'univers! " +
                        "Vous avez normalement obtenue une seconde essence de l'univers en plus de la seconde partie du livre.",
                "Je sais que cela fait beaucoup de responsabiliter sur vos épaules mais vous êtes l'unique éspoire. " +
                        "Afin de continuer, il va vous falloir réussir à créer une table de craft. " +
                        "Pour cela voici les différentes étape qui devrait vous permettent d'atteindre cette objectif :",
                "0) Je vous conseille de consommer l'univers essence récupérer afin d'augmenter la vitesse de récolte des ressources.\n" +
                        "1) créer des morceaux de pierre sale\n" +
                        "2) les nettoyer en séchant vos larmes.",
                "3) regrouper les petit morceaux de boue afin d'en créer des morceaux légérement plus grand.\n" +
                        "4) découper un morceaux de viande en petit morceaux\n" +
                        "5) combiner le petit morceaux de viande avec le morceaux de boue afin de fertiliser celui-ci.",
                "6) patienter jusqu'a la transformation final de celui-ci.\n" +
                        "7) détacher la mousse qui à pousser dessus\n" +
                        "8) fertiliser la boule de mousse obtenue\n" +
                        "9) patienter jusqu'a la transformation final\n" +
                        "10) récupérer la pousse de mangrove présente dessus\n" +
                        "11) répéter les opération précédente",
                "12) fabriquer les différente partie de la table de craft en mangrove\n" +
                        "13) fabriquer la table de craft.\n" +
                        "\n" +
                        "Je sais que cela est fastidieux mais la table de craft et trop indispensable pour s'en passer.\n" +
                        "\n" +
                        "Bon courage.."
                }
        };
    }
}
