import java.util.ArrayList;

public class Crew {
    private Integer crewNumber;
    private String flightNumber;
    private ArrayList<Passenger> staff;

    public Crew(Integer crewNumber, String flightNumber, ArrayList<Passenger> workers){
        this.crewNumber = crewNumber;
        this.flightNumber = flightNumber;
        this.staff = workers;
    }

    public Integer getCrewNumber() {
        return crewNumber;
    }

    public void setCrewNumber(Integer crewNumber) {
        this.crewNumber = crewNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Integer getStaffSize() {
        return this.staff.size();
    }

    public void getStaffString(ArrayList<Passenger> staff){
        for (Passenger p : staff){
            System.out.println(p.getSecondName() + ", " + p.getFirstName() + ", " +
                    p.getMiddleName() + ", " + p.getPersonalNumber());
        }
    }



    @Override
    public String toString() {
        System.out.println("Staff{");
        getStaffString(this.staff);
        System.out.println("}");
        return "Crew{" +
                "crewNumber=" + crewNumber +
                ", flightNumber='" + flightNumber + '\'' +
                '}';
    }
}
