package cn.breadnicecat.candycraftce.mixin.forge;

import cn.breadnicecat.candycraftce.block.blocks.CaramelPortalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Created in 2024/6/6 下午12:49
 * Project: candycraftce
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 * 放置岩浆的时候点燃焦糖门
 * <p>
 **/
@Mixin(BucketItem.class)
public abstract class MixinBucketItem {
	
	@Shadow(remap = false)
	public abstract Fluid getFluid();
	
	@Inject(method = "checkExtraContent", at = @At("HEAD"), cancellable = true)
	public void checkExtraContent(Player player, Level level, ItemStack containerStack, BlockPos pos, CallbackInfo ci) {
		if (CaramelPortalBlock.onBucketUse(player, level, pos, containerStack, getFluid())) ci.cancel();
	}
}
