import planes.ExperimentalPlane;      //it's better to import classes from one package one by one
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);		 

    @Test
    public void testGetTransportMilitaryPlanes() {		
        Airport airport = new Airport(planes);
		List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        Assert.assertTrue(!transportMilitaryPlanes.isEmpty());				//excess code
     
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {														//do not use System.out.println
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity(); 
        Assert.assertTrue(expectedPlaneWithMaxPassengersCapacity.equals(planeWithMaxPassengerCapacity));
    }

    @Test
    public void testSortByMaxLoadCapacity() {	//test3 is bad name for method 
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> sortedPlanes = airport.getPlanes(); //too long name for variable
		boolean nextPlaneMaxLoadCapacity = true; //do not put condition in variable's name
        for (int i = 0; i < sortedPlanes.size() - 1; i++) {	//next and current plane variables, it is the reason for cycle
			if (sortedPlanes.get(i).getMinLoadCapacity() > sortedPlanes.get(i + 1).getMinLoadCapacity()) {															//currentPlane
                nextPlaneMaxLoadCapacity = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacity);		
    }

    @Test
    public void testIsBomberAmongMilitaryPlanes() {	
        Airport airport = new Airport(planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        Assert.assertTrue(!bomberMilitaryPlanes.isEmpty());	//excess code
        // if not failed									//obvicious comment
    }

    @Test
    public void testIsUnclassifiedPlanesAmongExperimental(){	
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> ExperimentalPlanes = airport.getExperimentalPlanes();
        boolean unclassifiedPlanes = false;		//verb in variable's name
        for(ExperimentalPlane experimentalPlane : ExperimentalPlanes){
            if(experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED){
                unclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(unclassifiedPlanes);	
    }
}
