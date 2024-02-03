package cn.breadnicecat.candycraftce.block.blockentity.data;

import cn.breadnicecat.candycraftce.utils.tools.Accessor;
import net.minecraft.world.inventory.ContainerData;

/**
 * 用来更加方便写方块实体的同步
 *
 * @author <a href="https://gitee.com/Bread_NiceCat">Bread_NiceCat</a>
 * @date 2023/1/24 20:34
 */
public class CContainerData implements ContainerData {

	private final Accessor<Integer>[] accessors;

	@SafeVarargs
	public CContainerData(Accessor<Integer>... accessors) {
		this.accessors = accessors;
	}

	@Override
	public int get(int pIndex) {
		return accessors[pIndex].get();
	}

	@Override
	public void set(int pIndex, int pValue) {
		accessors[pIndex].accept(pValue);
	}

	@Override
	public int getCount() {
		return accessors.length;
	}
}
