package me.jezza.fracture.common.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * @author Jezza
 */
public class ContainerFracture extends Container {

	public ContainerFracture() {
	}

	@Override
	public boolean canInteractWith(EntityPlayer entity) {
		return false;
	}
}
