package me.jezza.fracture.common.entity;

import me.jezza.fracture.Fracture;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * @author Jezza
 */
public class EntityFracture extends EntityThrowable {

	private int lifeSpan = 0;

	public EntityFracture(World world) {
		super(world);
		this.setSize(0.5F, 0.5F);
	}

	public EntityFracture(World world, EntityLivingBase owner) {
		super(world, owner);
		this.setSize(0.5F, 0.5F);
	}

	@Override
	protected float func_70182_d() {
		return 0.9F;
	}

	@Override
	public void onUpdate() {
		if (lifeSpan++ >= 120 || getDistanceSqToEntity(getThrower()) > 32) {
			if (!worldObj.isRemote)
				setDead();
			return;
		}
		double motionX = this.motionX;
		double motionY = this.motionY;
		double motionZ = this.motionZ;
		super.onUpdate();
		this.motionX = motionX;
		this.motionY = motionY;
		this.motionZ = motionZ;
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if (!worldObj.isRemote) {
			setDead();
			EntityLivingBase thrower = getThrower();
			if (thrower instanceof EntityPlayer) {
				((EntityPlayer) thrower).openGui(Fracture.instance, 0, worldObj, 0, 0, 0);
			}
		}
	}
}
