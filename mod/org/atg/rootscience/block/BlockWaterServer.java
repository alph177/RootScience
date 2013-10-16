package org.atg.rootscience.block;

import org.atg.rootscience.RootScienceCore;
import org.atg.rootscience.TileEntityWaterServer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWaterServer extends BlockContainer {

	public BlockWaterServer(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock);//クリエイティブタブの選択
		this.setUnlocalizedName("blockSample");	//システム名の設定
		this.setTextureName(RootScienceCore.domain + ":waterserver");	//ブロックのテクスチャの指定
		//いらないものは消してください
		this.setHardness(5F);			//硬さ
		this.setResistance(Block.furnaceIdle.blockResistance);		//爆破耐性
		this.setStepSound(Block.soundStoneFootstep);	//ブロックの音
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		// TileEntityの生成
		return new TileEntityWaterServer();
	}
	
	
}
