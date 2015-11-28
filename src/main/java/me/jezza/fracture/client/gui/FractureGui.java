package me.jezza.fracture.client.gui;

import me.jezza.fracture.common.containers.FractureContainer;
import me.jezza.fracture.common.lib.FractureData;
import me.jezza.oc.client.gui.GuiContainerAbstract;
import me.jezza.oc.client.gui.components.GuiWidget;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author Jezza
 */
public class FractureGui<T> extends GuiContainerAbstract {
	private final FractureData<T> data;
	private final T object;

	public FractureGui(EntityPlayer player, FractureContainer<T> container) {
		super(player, container);
		this.data = container.data();
		this.object = container.object();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int mouseX, int mouseY) {
		super.drawGuiContainerBackgroundLayer(var1, mouseX, mouseY);
		drawDefaultBackground();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);

		drawCentredText(0, 0, data.title(object));
	}

	@Override
	public void onActionPerformed(GuiWidget widget, int mouse) {
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
