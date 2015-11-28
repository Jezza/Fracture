package me.jezza.fracture.common.core;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

import java.util.Comparator;

/**
 * Calculates the distance from TileEntity.class, Block.class, and Entity.class, and then compares them.
 *
 * @author Jezza
 */
public enum ClassComparator implements Comparator<Class<?>> {
	INSTANCE;

	@Override
	public int compare(Class<?> o1, Class<?> o2) {
		return Integer.compare(distance(o2), distance(o1));
	}

	private int distance(Class<?> clazz) {
		if (Entity.class.isAssignableFrom(clazz))
			return distanceFrom(clazz, Entity.class);
		if (TileEntity.class.isAssignableFrom(clazz))
			return distanceFrom(clazz, TileEntity.class);
		if (Block.class.isAssignableFrom(clazz))
			return distanceFrom(clazz, Block.class);
		return -1;
	}

	private int distanceFrom(Class<?> clazz, Class<?> to) {
		int distance = 0;
		Class<?> parent = clazz;
		while ((parent = parent.getSuperclass()) != null) {
			distance++;
			if (parent == to)
				return distance;
		}
		return -1;
	}
}
