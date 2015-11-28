package me.jezza.fracture;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import me.jezza.fracture.common.CommonProxy;
import me.jezza.fracture.common.core.ClassComparator;
import me.jezza.fracture.common.data.BlockFractureData;
import me.jezza.fracture.common.data.EntityFractureData;
import me.jezza.fracture.common.data.TileFractureData;
import me.jezza.fracture.common.items.ItemFractureGun;
import me.jezza.fracture.common.lib.FractureData;
import me.jezza.oc.common.core.config.Config.Controller;
import me.jezza.oc.common.utils.helpers.StringHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import org.apache.logging.log4j.Logger;

import java.util.*;

import static me.jezza.fracture.common.core.FractureProperties.*;

/**
 * @author Jezza
 */
@Controller
@Mod(modid = MOD_ID, name = MOD_NAME, version = VERSION, dependencies = DEPENDENCIES)
public class Fracture {
	private static final Map<Class<?>, FractureData<?>> dataMap = new HashMap<>();

	@Instance(MOD_ID)
	public static Fracture instance;

	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
	public static CommonProxy proxy;

	public static Logger logger; // = LogManager.getLogger(MOD_ID);

	public static ItemFractureGun gun;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		logger.info("-- Pre-Initialising " + MOD_ID + " (" + VERSION + ") --");

		gun = new ItemFractureGun("fractureGun");

		proxy.preInit();
		dataMap.put(Entity.class, defaultEntity());
		dataMap.put(TileEntity.class, defaultTile());
		dataMap.put(Block.class, defaultBlock());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		logger.info("-- Initialising --");
		proxy.init();

		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		logger.info("-- Post-Initialising --");
		proxy.postInit();
	}

	public static <T> boolean register(Class<T> clazz, FractureData<T> data) {
		if (dataMap.containsKey(clazz))
			return false;
		dataMap.put(clazz, data);
		return true;
	}

	@SuppressWarnings("unchecked")
	public static <T> FractureData<T> data(Class<T> clazz) {
		FractureData<T> data = (FractureData<T>) dataMap.get(clazz);
		if (data != null)
			return data;
		List<Class<? super T>> results = new ArrayList<>();
		for (Class<?> dataClass : dataMap.keySet())
			if (dataClass.isAssignableFrom(clazz))
				results.add((Class<? super T>) dataClass);
		Collections.sort(results, ClassComparator.INSTANCE);
		if (results.isEmpty())
			throw new IllegalArgumentException(StringHelper.format("Failed to locate FractureData for {}.", clazz.getCanonicalName()));
		Class<? super T> dataClass = results.get(0);
		data = (FractureData<T>) dataMap.get(dataClass);
		dataMap.put(clazz, data);
		return data;
	}

	public static FractureData<Entity> defaultEntity() {
		return new EntityFractureData();
	}

	public static FractureData<TileEntity> defaultTile() {
		return new TileFractureData();
	}

	public static FractureData<Block> defaultBlock() {
		return new BlockFractureData();
	}
}
