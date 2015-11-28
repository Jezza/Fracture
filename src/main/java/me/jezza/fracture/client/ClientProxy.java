package me.jezza.fracture.client;

import me.jezza.fracture.Fracture;
import me.jezza.fracture.client.gui.FractureGui;
import me.jezza.fracture.common.CommonProxy;
import me.jezza.fracture.common.containers.FractureContainer;
import me.jezza.fracture.common.lib.FractureData;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * @author Jezza
 */
public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
	}

	@Override
	public void init() {
	}

	@Override
	public void postInit() {
	}

	@Override
	public GuiScreen getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
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
				return new FractureGui<>(player, new FractureContainer<>(player, data, object));
			case 1:
				Entity entity = world.getEntityByID(x);
				if (entity != null) {
					data = Fracture.data(entity.getClass());
					return new FractureGui<>(player, new FractureContainer<>(player, data, entity));
				}
			default:
		}
		return null;
	}
}
