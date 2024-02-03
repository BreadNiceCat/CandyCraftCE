package cn.breadnicecat.candycraftce.datagen.forge.providers;

import cn.breadnicecat.candycraftce.CandyCraftCE;
import cn.breadnicecat.candycraftce.block.BlockEntry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static cn.breadnicecat.candycraftce.block.CBlockTags.CANDY_PLANT_CAN_ON;
import static cn.breadnicecat.candycraftce.block.CBlockTags.CARAMEL_PORTAL_FRAME;
import static cn.breadnicecat.candycraftce.block.CBlocks.*;
import static cn.breadnicecat.candycraftce.utils.CommonUtils.accept;
import static net.minecraft.tags.BlockTags.*;

/**
 * Created in 2023/10/14 22:39
 * Project: candycraftce
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 */
public class CBlockTagsProvider extends BlockTagsProvider {
	public CBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, CandyCraftCE.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider provider) {
		add(MINEABLE_WITH_SHOVEL, SUGAR_BLOCK, PUDDING, CUSTARD_PUDDING, PUDDING_FARMLAND);
		add(CARAMEL_PORTAL_FRAME, CARAMEL_BLOCK, SUGAR_BLOCK);
		add(CANDY_PLANT_CAN_ON, PUDDING, CUSTARD_PUDDING, PUDDING_FARMLAND);
		add(PORTALS, CARAMEL_PORTAL);
		add(WALLS, CANDY_CANE_WALL);
		add(FENCES, CANDY_CANE_FENCE);
		add(MINEABLE_WITH_PICKAXE, CARAMEL_BLOCK, CHOCOLATE_STONE, CHOCOLATE_COBBLESTONE,
				CANDY_CANE_BLOCK, CANDY_CANE_WALL, CANDY_CANE_FENCE, CANDY_CANE_SLAB, CANDY_CANE_STAIRS);
	}

	private void add(TagKey<Block> tagKey, BlockEntry<?>... be) {
		IntrinsicTagAppender<Block> tag = tag(tagKey);
		accept(i -> tag.add(i.get()), be);
	}
}
