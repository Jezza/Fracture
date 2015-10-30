package me.jezza.fracture.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import me.jezza.fracture.client.renderer.EntityFractureRenderer;
import me.jezza.fracture.common.CommonProxy;
import me.jezza.fracture.common.entity.EntityFracture;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * @author Jezza
 */
public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		RenderingRegistry.registerEntityRenderingHandler(EntityFracture.class, new EntityFractureRenderer());
	}

	@Override
	public void init() {
	}

	@Override
	public void postInit() {
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
}
