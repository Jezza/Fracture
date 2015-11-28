package me.jezza.fracture.common.lib;

import java.util.List;

/**
 * @author Jezza
 */
public interface FractureData<T> {
	String title(T object);

	List<FractureField> fields(T object);
}
