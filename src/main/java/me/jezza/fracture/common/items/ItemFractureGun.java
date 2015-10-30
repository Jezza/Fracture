package me.jezza.fracture.common.items;

import me.jezza.fracture.common.entity.EntityFracture;
import me.jezza.oc.common.items.ItemAbstract;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author Jezza
 */
public class ItemFractureGun extends ItemAbstract {
	public ItemFractureGun(String name) {
		super(name);
		setCreativeTab(CreativeTabs.tabMisc);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		// TODO Change sound.
		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if (!world.isRemote)
			world.spawnEntityInWorld(new EntityFracture(world, player));
		return itemStack;
	}
}
