package me.jezza.fracture.client.renderer;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;

/**
 * @author Jezza
 */
public class EntityFractureRenderer extends Render {

	private final RenderSnowball snowball;

	public EntityFractureRenderer() {
		snowball = new RenderSnowball(Items.snowball);
		snowball.setRenderManager(RenderManager.instance);
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float tick) {
		snowball.doRender(entity, x, y, z, yaw, tick);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return TextureMap.locationItemsTexture;
	}
}
