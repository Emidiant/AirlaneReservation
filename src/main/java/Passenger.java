/**
 * This is Passenger class.
 * Travel information is stored here.
 */
public class Passenger {
    private String secondName;
    private String firstName;
    private String middleName;
    private String currentLocation;
    private String destination;
    private Integer budget;

    /**
     *
     * @param secondName passenger secondName
     * @param firstName passenger name
     * @param middleName passenger middleName
     * @param currentLocation departure location
     * @param destination place of arrival
     * @param budget available money
     */
    public Passenger(String secondName, String firstName, String middleName, String currentLocation, String destination, Integer budget) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.currentLocation = currentLocation;
        this.destination = destination;
        this.budget = budget;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "secondName='" + secondName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}

