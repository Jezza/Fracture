package me.jezza.fracture.common.items;

import me.jezza.oc.common.items.ItemAbstract;
import me.jezza.oc.common.utils.RayTrace;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import static me.jezza.fracture.common.core.FractureProperties.MOD_ID;

/**
 * @author Jezza
 */
public class ItemFractureGun extends ItemAbstract {
	public ItemFractureGun(String name) {
		super(name);
		setCreativeTab(CreativeTabs.tabMisc);
		textureless(true);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		//	TODO add sound.
		//	Sounds.FRACTURE_OPEN.playAtEntity(player, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		//	world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if (world.isRemote)
			return itemStack;
		MovingObjectPosition trace = RayTrace.create(player).distance(128).trace();
		switch (trace.typeOfHit) {
			case MISS:
				break;
			case BLOCK:
				player.openGui(MOD_ID, 0, world, trace.blockX, trace.blockY, trace.blockZ);
				break;
			case ENTITY:
				player.openGui(MOD_ID, 1, world, trace.entityHit.getEntityId(), 0, 0);
				break;
		}
		player.addChatComponentMessage(new ChatComponentText("" + trace));
		return itemStack;
	}
}
