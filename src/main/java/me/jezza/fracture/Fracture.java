package me.jezza.fracture;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import me.jezza.fracture.common.CommonProxy;
import me.jezza.fracture.common.entity.EntityFracture;
import me.jezza.fracture.common.items.ItemFractureGun;
import me.jezza.oc.common.core.config.Config.Controller;
import me.jezza.oc.common.interfaces.IChannel;
import me.jezza.oc.common.interfaces.SidedChannel;
import org.apache.logging.log4j.Logger;

import static me.jezza.fracture.common.core.FractureProperties.*;

/**
 * @author Jezza
 */
@Controller
@Mod(modid = MOD_ID, name = MOD_NAME, version = VERSION, dependencies = DEPENDENCIES)
public class Fracture {

	@Instance(MOD_ID)
	public static Fracture instance;

	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
	public static CommonProxy proxy;

	@SidedChannel(MOD_ID)
	public static IChannel channel;

	public static Logger logger; //  = LogManager.getLogger(MOD_ID);

	public static ItemFractureGun gun;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		logger.info("-- Pre-Initialising " + MOD_ID + " (" + VERSION + ") --");

		gun = new ItemFractureGun("fractureGun");
		EntityRegistry.registerModEntity(EntityFracture.class, "Fracture", 0, this, 32, 10, true);

		proxy.preInit();
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
}
