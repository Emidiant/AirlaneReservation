import java.util.ArrayList;

/**
 * The program is able to distribute prices in different sections depending on the place on the plane.
 * Business class will cost more than an economy class.
 * @author Sergeeva Julia M3304
 * @version 0.1
 */
public class Main {


    public static void main(String[] args) {
        ArrayList<Airplane> airplanes = new ArrayList<>();
        Airplane airplane1 = new Airplane("SPB", "MSK", "1", "Airbus A320-200",20201002, "1720", "1920");
        Airplane airplane2 = new Airplane("KLG", "MSK", "2", "Boeing B767-300", 20201002, "1720", "0020");
        Airplane airplane3 = new Airplane("SPB", "MSK", "3", "Boeing B737-800", 20201002, "1720", "1820");

        Passenger crewMember1 = new Passenger();
        Passenger crewMember2 = new Passenger();
        Passenger crewMember3 = new Passenger();
        Passenger crewMember4 = new Passenger();
        crewMember1.setStaff("Ivanov", "Petr", "Andreevich", 1000);
        crewMember2.setStaff("Sidorov", "Oleg", "Mihailovich", 1001);
        crewMember3.setStaff("Petrov", "Sergey", "Dmitrievich", 1002);
        crewMember4.setStaff("Lipnin", "Evgeniy", "Olegovich", 1003);
        ArrayList<Passenger> workers = new ArrayList<>();
        workers.add(crewMember1);
        workers.add(crewMember2);
        workers.add(crewMember3);
        workers.add(crewMember4);

        airplanes.add(airplane1);
        airplanes.add(airplane2);
        airplanes.add(airplane3);

        Crew crew1 = new Crew(1, "1", workers);
        airplane1.setCrewNumber(crew1, airplanes);

        crew1.getFlightDataByNumber(airplanes);

        //view ship crew
        System.out.println(crew1.toString());





        Passenger passenger1 = new Passenger("Sergeeva", "Julia", "Dmitrievna",
                "SPB", "MSK", 30000);
        Passenger passenger2 = new Passenger("Kolesova", "Alexandra", "Evgenievna",
                "SPB", "MSK", 6000);
        Passenger passenger3 = new Passenger("Ione", "Daria", "Olegovna",
                "SPB", "MSK", 3000);

        System.out.println("passenger1 Destination: " + passenger1.getDestination());

        System.out.println("BusinessCost: " + airplane1.getBusinessCost());
        System.out.println("EconomyCost: " + airplane1.getEconomyCost());

        System.out.println("BusinessCost: " + airplane2.getBusinessCost());
        System.out.println("EconomyCost: " + airplane2.getEconomyCost());

        System.out.println("BusinessCost: " + airplane3.getBusinessCost());
        System.out.println("EconomyCost: " + airplane3.getEconomyCost());

        Ticket ticket = new Ticket();
        airplanes = ticket.search(passenger1, airplanes);
        airplanes = ticket.search(passenger2, airplanes);

        for (Airplane airplane: airplanes) {
            System.out.println("FlightNumber" + airplane.getFlightNumber() + ", Available Business Places: "
                    + airplane.getAvailableBusinessPlaces());
            if (airplane.getPassengers() != null) {
                for (Passenger passenger : airplane.getPassengers()) {
                    System.out.println(passenger.toString());
                }
            }
        }

    }
}

