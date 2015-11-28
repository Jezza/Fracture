package me.jezza.fracture.common.data;

import me.jezza.fracture.common.lib.FractureData;
import me.jezza.fracture.common.lib.FractureField;
import net.minecraft.tileentity.TileEntity;

import java.util.Collections;
import java.util.List;

/**
 * @author Jezza
 */
public class TileFractureData implements FractureData<TileEntity> {
	@Override
	public String title(TileEntity tile) {
		return tile.getClass().getCanonicalName();
	}

	@Override
	public List<FractureField> fields(TileEntity object) {
		return Collections.emptyList();
	}
}
