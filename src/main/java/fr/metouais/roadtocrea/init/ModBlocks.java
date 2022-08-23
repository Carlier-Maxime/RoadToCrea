package fr.metouais.roadtocrea.init;

import fr.metouais.roadtocrea.RoadToCrea;
import fr.metouais.roadtocrea.block.CustomCraftingTableBlock;
import fr.metouais.roadtocrea.block.UltimateBedrockBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RoadToCrea.MODID);

    public static final RegistryObject<Block> ULTIMATE_BEDROCK = createBlock("ultimate_bedrock", () -> new UltimateBedrockBlock(BlockBehaviour.Properties.of(Material.STONE).destroyTime(-1f).speedFactor(0.001f).lightLevel((param) -> 15)));
    public static final RegistryObject<Block> MANGROVE_CRAFTING_TABLE = createBlock("mangrove_crafting_table", () -> new CustomCraftingTableBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MOSS_SLAB = createBlock("moss_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.MOSS, MaterialColor.COLOR_GREEN).strength(0.1F).sound(SoundType.MOSS)));

    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier) {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
        return block;
    }
}
