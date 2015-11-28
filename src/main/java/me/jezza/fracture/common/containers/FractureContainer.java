package me.jezza.fracture.common.containers;

import me.jezza.fracture.common.lib.FractureData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * @author Jezza
 */
public class FractureContainer<T> extends Container {
	private final EntityPlayer player;
	private final FractureData<T> data;
	private final T object;

	@SuppressWarnings("unchecked")
	public FractureContainer(EntityPlayer player, FractureData<T> data, Object object) {
		this.player = player;
		this.data = data;
		this.object = (T) object;
	}

	public FractureData<T> data() {
		return data;
	}

	public T object() {
		return object;
	}

	@Override
	public void onContainerClosed(EntityPlayer p_75134_1_) {
	}

	@Override
	public boolean canInteractWith(EntityPlayer entity) {
		return true;
	}
}
