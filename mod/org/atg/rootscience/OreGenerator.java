package org.atg.rootscience;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import static org.atg.rootscience.RSBlocks.*;

public class OreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		
		switch(world.provider.dimensionId){
		case -1:
		    break;
		case 0:
		    generateSurface(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 1:
		    break;
		}

	}
	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        generate(oreFe2O3, 4, 8, 48, world, rand, chunkX, chunkZ);
        generate(oreCopper, 6, 6, 64, world, rand, chunkX, chunkZ);
        generate(oreTin, 6, 6, 48, world, rand, chunkX, chunkZ);
        generate(oreSilver, 6, 3, 32, world, rand, chunkX, chunkZ);
        generate(oreRuby, 3, 4, 24, world, rand, chunkX, chunkZ);
        generate(oreSapphire, 3, 4, 24, world, rand, chunkX, chunkZ);
        generate(oreCorundum, 3, 4, 24, world, rand, chunkX, chunkZ);
	}
	
	private void generate(Block block , int tries , int quantity , int minDepth , World world, Random rand, int chunkX, int chunkZ)
	{
        for(int k = 0; k < tries; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(minDepth);
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	
        	(new WorldGenMinable(block.blockID, quantity)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
        }
	}
	

}
