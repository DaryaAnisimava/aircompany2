package planes;	//the same style for all packages

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryType militaryType;	//type should be specified

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType militaryType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryType = militaryType;	//type
    }

    public MilitaryType getType() {
        return militaryType;	//type
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + militaryType +
                '}');
    }

    @Override
    public boolean equals(Object object) {	//object's name without sense
        if (this == object) return true;		//o
        if (!(object instanceof MilitaryPlane)) return false;
        if (!super.equals(object)) return false;	//o
        MilitaryPlane plane = (MilitaryPlane) object;		//o
        return militaryType == plane.militaryType;	//type
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryType);	//type
    }
}
