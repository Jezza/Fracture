package me.jezza.fracture.client.gui;

import me.jezza.oc.client.gui.GuiContainerAbstract;
import me.jezza.oc.client.gui.components.GuiWidget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * @author Jezza
 */
public class GuiFracture extends GuiContainerAbstract {
	protected GuiFracture(EntityPlayer player) {
		super(player);
	}

	public GuiFracture(EntityPlayer player, Container container) {
		super(player, container);
	}

	@Override
	public void onActionPerformed(GuiWidget widget, int mouse) {

	}
}
