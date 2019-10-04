import java.util.ArrayList;

/**
 * This is Ticket class.
 * Here comes the flight selection for the traveler.
 */
public class Ticket {

    /**
     * See which planes fly on the specified route
     * @param departure enter the place of departure
     * @param arrival enter the place of arrival
     * @param airplanes transfer the list of all planes
     * @return cheapest plane
     */
    public Airplane getAirplaneByWay(String departure, String arrival, ArrayList<Airplane> airplanes){
        int cheapFlight = 10000000;
        Airplane plane = null;
        for (Airplane a: airplanes){
            if (departure.equals(a.getCurrentLocation()) && arrival.equals(a.getDestination())){
                if (a.getEconomyCost() < cheapFlight){
                    plane = a;
                    cheapFlight = a.getEconomyCost();
                }
            }
        }
        if (plane != null){
            airplanes.remove(plane);
        }
        return plane;
    }

    /**
     * Seen which plane the traveler can fly on.
     * @param passenger traveller data
     * @param airplanes transfer list of all airplanes
     * @return updated list of airplanes, where we changed available places
     */
    public ArrayList<Airplane> search(Passenger passenger, ArrayList<Airplane> airplanes){
        Airplane airplane = getAirplaneByWay(passenger.getCurrentLocation(), passenger.getDestination(), airplanes);
        ArrayList<Passenger> passengers = airplane.getPassengers();
        if (airplane == null){
            System.out.println("you can't leave your city");
        } else {
            if (passenger.getBudget() >= airplane.getBusinessCost()){
                System.out.println("Cost: " + airplane.getBusinessCost() + " " + airplane.toString());
                airplane.setAvailableBusinessPlaces(airplane.getAvailableBusinessPlaces() - 1);
                passengers.add(passenger);
                airplane.setPassengers(passengers);
                airplanes.add(airplane);
            } else {
                if (passenger.getBudget() >= airplane.getEconomyCost()){
                    System.out.println("Cost: " + airplane.getEconomyCost() + " " + airplane.toString());
                    airplane.setAvailableEconomyPlaces(airplane.getAvailableEconomyPlaces() - 1);
                    passengers.add(passenger);
                    airplane.setPassengers(passengers);
                    airplanes.add(airplane);
                } else {
                    System.out.println("you can't leave your city");
                    airplanes.add(airplane);
                }
            }
        }
        return airplanes;
    }
}
