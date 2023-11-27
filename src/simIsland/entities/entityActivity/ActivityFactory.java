package simIsland.entities.entityActivity;

import simIsland.entities.entityTale.EntityLive;

public abstract class ActivityFactory {
    public EntityLive entity;

    public abstract void activity(EntityLive entity);
}
