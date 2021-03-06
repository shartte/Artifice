package shukaro.artifice;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import shukaro.artifice.block.decorative.BlockSteel;
import shukaro.artifice.block.ItemBlockArtifice;
import shukaro.artifice.block.decorative.*;
import shukaro.artifice.block.frame.*;
import shukaro.artifice.compat.ArtificeRegistry;

public class ArtificeBlocks
{
    public static BlockFrame blockFrame;
    public static BlockFlora blockFlora;
    public static BlockLotus blockLotus;
    public static BlockBasalt blockBasalt;
    public static BlockMarble blockMarble;
    public static BlockStairsArtifice blockBasaltBrickStairs;
    public static BlockStairsArtifice blockMarbleBrickStairs;
    public static BlockStairsArtifice blockBasaltCobbleStairs;
    public static BlockStairsArtifice blockMarbleCobbleStairs;
    public static BlockHalfSlab blockBasaltSlab;
    public static BlockHalfSlab blockBasaltDoubleSlab;
    public static BlockHalfSlab blockMarbleSlab;
    public static BlockHalfSlab blockMarbleDoubleSlab;
    public static BlockFrame blockDetector;
    public static BlockSteel blockSteel;
    public static BlockFrameBlastWall blockReinforced;
    public static BlockFrameGlassWall blockGlassWall;
    public static BlockFrameScaffold blockScaffold;

    public static void initBlocks()
    {
        if (ArtificeConfig.enableWorldGen.getBoolean(true))
        {
            blockFlora = new BlockFlora(ArtificeConfig.blockFloraID.getInt());
            blockLotus = new BlockLotus(ArtificeConfig.blockLotusID.getInt());
            blockBasalt = new BlockBasalt(ArtificeConfig.blockBasaltID.getInt());
            blockMarble = new BlockMarble(ArtificeConfig.blockMarbleID.getInt());
            blockBasaltBrickStairs = new BlockStairsArtifice(ArtificeConfig.blockBasaltBrickStairsID.getInt(), blockBasalt, 2);
            blockMarbleBrickStairs = new BlockStairsArtifice(ArtificeConfig.blockMarbleBrickStairsID.getInt(), blockMarble, 2);
            blockBasaltCobbleStairs = new BlockStairsArtifice(ArtificeConfig.blockBasaltCobbleStairsID.getInt(), blockBasalt, 1);
            blockMarbleCobbleStairs = new BlockStairsArtifice(ArtificeConfig.blockMarbleCobbleStairsID.getInt(), blockMarble, 1);
            blockBasaltSlab = new BlockBasaltSlab(ArtificeConfig.blockBasaltSlabID.getInt(), false);
            blockBasaltDoubleSlab = new BlockBasaltSlab(ArtificeConfig.blockBasaltDoubleSlabID.getInt(), true);
            blockMarbleSlab = new BlockMarbleSlab(ArtificeConfig.blockMarbleSlabID.getInt(), false);
            blockMarbleDoubleSlab = new BlockMarbleSlab(ArtificeConfig.blockMarbleDoubleSlabID.getInt(), true);
            Item.itemsList[ArtificeConfig.blockBasaltSlabID.getInt()] = new ItemBlockSlabArtifice(ArtificeConfig.blockBasaltSlabID.getInt() - 256, blockBasaltSlab, blockBasaltDoubleSlab, false);
            Item.itemsList[ArtificeConfig.blockBasaltDoubleSlabID.getInt()] = new ItemBlockSlabArtifice(ArtificeConfig.blockBasaltDoubleSlabID.getInt() - 256, blockBasaltSlab, blockBasaltDoubleSlab, true);
            Item.itemsList[ArtificeConfig.blockMarbleSlabID.getInt()] = new ItemBlockSlabArtifice(ArtificeConfig.blockMarbleSlabID.getInt() - 256, blockMarbleSlab, blockMarbleDoubleSlab, false);
            Item.itemsList[ArtificeConfig.blockMarbleDoubleSlabID.getInt()] = new ItemBlockSlabArtifice(ArtificeConfig.blockMarbleDoubleSlabID.getInt() - 256, blockMarbleSlab, blockMarbleDoubleSlab, true);
            GameRegistry.registerBlock(blockFlora, ItemBlockFlora.class, blockFlora.getUnlocalizedName());
            GameRegistry.registerBlock(blockLotus, ItemBlockLotus.class, blockLotus.getUnlocalizedName());
            GameRegistry.registerBlock(blockBasalt, ItemBlockBasalt.class, blockBasalt.getUnlocalizedName());
            GameRegistry.registerBlock(blockMarble, ItemBlockMarble.class, blockMarble.getUnlocalizedName());
            GameRegistry.registerBlock(blockBasaltBrickStairs, ItemBlockArtifice.class, blockBasaltBrickStairs.getUnlocalizedName());
            GameRegistry.registerBlock(blockMarbleBrickStairs, ItemBlockArtifice.class, blockMarbleBrickStairs.getUnlocalizedName());
            GameRegistry.registerBlock(blockBasaltCobbleStairs, ItemBlockArtifice.class, blockBasaltCobbleStairs.getUnlocalizedName());
            GameRegistry.registerBlock(blockMarbleCobbleStairs, ItemBlockArtifice.class, blockMarbleCobbleStairs.getUnlocalizedName());
            ArtificeRegistry.registerBasaltType(ArtificeBlocks.blockBasalt.blockID, 0);
            ArtificeRegistry.registerMarbleType(ArtificeBlocks.blockMarble.blockID, 0);
            //OreDictionary.registerOre("stone", new ItemStack(blockBasalt, 1, 0));
            //OreDictionary.registerOre("stone", new ItemStack(blockMarble, 1, 0));
            //OreDictionary.registerOre("cobblestone", new ItemStack(blockBasalt, 1, 1));
            //OreDictionary.registerOre("cobblestone", new ItemStack(blockMarble, 1, 1));
        }

        if (ArtificeConfig.enableFrames.getBoolean(true))
        {
            blockFrame = new BlockFrameBase(ArtificeConfig.blockFrameID.getInt());
            blockDetector = new BlockFrameDetector(ArtificeConfig.blockDetectorID.getInt());
            blockReinforced = new BlockFrameBlastWall(ArtificeConfig.blockReinforcedID.getInt());
            blockGlassWall = new BlockFrameGlassWall(ArtificeConfig.blockGlassWallID.getInt());
            blockScaffold = new BlockFrameScaffold(ArtificeConfig.blockScaffoldID.getInt());
            GameRegistry.registerBlock(blockFrame, ItemBlockFrame.class, blockFrame.getUnlocalizedName());
            GameRegistry.registerBlock(blockDetector, ItemBlockArtifice.class, blockDetector.getUnlocalizedName());
            GameRegistry.registerBlock(blockReinforced, ItemBlockFrame.class, blockReinforced.getUnlocalizedName());
            GameRegistry.registerBlock(blockGlassWall, ItemBlockFrame.class, blockGlassWall.getUnlocalizedName());
            GameRegistry.registerBlock(blockScaffold, ItemBlockFrame.class, blockScaffold.getUnlocalizedName());
        }

        if (ArtificeConfig.enableSteel.getBoolean(true))
        {
            blockSteel = new BlockSteel(ArtificeConfig.blockSteelID.getInt());
            GameRegistry.registerBlock(blockSteel, ItemBlockArtifice.class, blockSteel.getUnlocalizedName());
            OreDictionary.registerOre("blockSteel", blockSteel);
        }
    }
}
