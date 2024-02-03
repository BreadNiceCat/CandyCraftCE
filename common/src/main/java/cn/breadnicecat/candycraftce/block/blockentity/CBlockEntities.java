package cn.breadnicecat.candycraftce.block.blockentity;

import cn.breadnicecat.candycraftce.block.blockentity.entities.LicoriceFurnaceBE;
import cn.breadnicecat.candycraftce.utils.CLogUtils;
import cn.breadnicecat.candycraftce.utils.CommonUtils;
import org.slf4j.Logger;

import static cn.breadnicecat.candycraftce.block.CBlocks.LICORICE_FURNACE;
import static cn.breadnicecat.candycraftce.block.blockentity.CBlockEntityBuilder.create;

/**
 * Created in 2024/1/30 23:08
 * Project: candycraftce
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 */
public class CBlockEntities {
	public static final BlockEntityEntry<LicoriceFurnaceBE> LICORICE_FURNACE_BE = create(LICORICE_FURNACE.getName(), LicoriceFurnaceBE::new).setValidBlocks(LICORICE_FURNACE).save();

	private static final Logger LOGGER = CLogUtils.sign();

	public static void init() {
		CommonUtils.logInit(LOGGER);
	}


}
