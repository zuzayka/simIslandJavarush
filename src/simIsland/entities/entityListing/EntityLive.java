package simIsland.entities.entityListing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import simIsland.immutableParameters.EntityProperties;
import simIsland.immutableParameters.EntityType;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public abstract class EntityLive {
    String name;
    private int intervalProcreation;

    public EntityLive() {
        this.name = this.getClass().getSimpleName().toUpperCase();
        this.intervalProcreation = EntityProperties.valueOf(this.getClass().getSimpleName().toUpperCase()).getIntervalProcreation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityLive that = (EntityLive) o;

        if (intervalProcreation != that.intervalProcreation) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + intervalProcreation;
        return result;
    }

    public static void main(String[] args) {
        EntityLive el = new Bear();
        System.out.println(el.getName());
        EntityType et = EntityType.BEAR;
        System.out.println(et.name());
    }
}
