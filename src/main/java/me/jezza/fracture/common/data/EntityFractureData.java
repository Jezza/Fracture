package me.jezza.fracture.common.data;

import me.jezza.fracture.common.lib.FractureData;
import me.jezza.fracture.common.lib.FractureField;
import net.minecraft.entity.Entity;

import java.util.Collections;
import java.util.List;

/**
 * @author Jezza
 */
public class EntityFractureData implements FractureData<Entity> {
	@Override
	public String title(Entity entity) {
		return "Bitch's id: " + entity.getEntityId();
	}

	@Override
	public List<FractureField> fields(Entity object) {
		return Collections.emptyList();
	}
}
