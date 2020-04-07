package planes;		//the same style for all packages

import java.util.Objects;

public class PassengerPlane extends Plane{

    //obvicious comment in bad style
    private int passengersCapacity;

   //obvicious comment in bad style
    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }


    //obvicious comment in bad style
    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                '}');
    }

	//commented code should be deleted
	
    @Override
    public boolean equals(Object object) {		//bad object's name
        if (this == object) return true;		//o
        if (!(o instanceof PassengerPlane)) return false;
        if (!super.equals(o)) return false;
        PassengerPlane plane = (PassengerPlane) object;	//o
        return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
