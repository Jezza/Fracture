package me.jezza.fracture.common;

import me.jezza.fracture.Fracture;
import me.jezza.fracture.common.containers.FractureContainer;
import me.jezza.fracture.common.lib.FractureData;
import me.jezza.oc.common.interfaces.IGuiElementHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

/**
 * @author Jezza
 */
public class CommonProxy implements IGuiElementHandler {

	public void preInit() {
	}

	public void init() {
	}

	public void postInit() {
	}

	@Override
	public Container getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		FractureData<?> data;
		switch (id) {
			case 0:
				Object object = world.getTileEntity(x, y, z);
				if (object != null) {
					data = Fracture.data(object.getClass());
				} else {
					object = world.getBlock(x, y, z);
					data = Fracture.data(object.getClass());
				}
				return new FractureContainer<>(player, data, object);
			case 1:
				Entity entity = world.getEntityByID(x);
				if (entity != null) {
					data = Fracture.data(entity.getClass());
					return new FractureContainer<>(player, data, entity);
				}
			default:
		}
		return null;
	}

	@Override
	public GuiScreen getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
}
