package shukaro.artifice.event;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import net.minecraft.world.World;
import shukaro.artifice.ArtificeCore;
import shukaro.artifice.util.ChunkCoord;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;

public class WorldTicker implements ITickHandler
{
    public static HashMap chunksToGen = new HashMap();
    private int count = 0;

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData)
    {
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {
        World world = (World) tickData[0];
        int dim = world.provider.dimensionId;

        ArrayList chunks = (ArrayList) chunksToGen.get(Integer.valueOf(dim));

        if ((chunks != null) && (chunks.size() > 0))
        {
            count++;
            ChunkCoord c = (ChunkCoord) chunks.get(0);
            long worldSeed = world.getSeed();
            Random rand = new Random(worldSeed);
            long xSeed = rand.nextLong() >> 3;
            long zSeed = rand.nextLong() >> 3;
            rand.setSeed(xSeed * c.chunkX + zSeed * c.chunkZ ^ worldSeed);
            ArtificeCore.worldGen.generateWorld(rand, c.chunkX, c.chunkZ, world, false);
            chunks.remove(0);
            chunksToGen.put(dim, chunks);
            ArtificeCore.logger.log(Level.INFO, "Regenerated " + count + " chunks. " + Math.max(0, chunks.size()) + " chunks left");
        }
    }

    @Override
    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.WORLD);
    }

    @Override
    public String getLabel()
    {
        return "Artifice.World";
    }

}
