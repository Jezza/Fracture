package me.jezza.fracture.common.data;

import me.jezza.fracture.common.lib.FractureData;
import me.jezza.fracture.common.lib.FractureField;
import net.minecraft.block.Block;

import java.util.Collections;
import java.util.List;

/**
 * @author Jezza
 */
public class BlockFractureData implements FractureData<Block> {
	@Override
	public String title(Block block) {
		return block.getLocalizedName();
	}

	@Override
	public List<FractureField> fields(Block object) {
		return Collections.emptyList();
	}
}
