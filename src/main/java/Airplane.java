import java.util.ArrayList;

/**
 * This is Airplane class.
 * Here we store all the information about the plane
 */
public class Airplane {
    private String currentLocation;
    private String destination;
    private String flightNumber;
    private Integer crewNumber;
    private String model; //определяет количество мест на борту
    private Integer flightStartDate;
    private String flightFinishTime;
    private String flightStartTime; //время по Лондону
    private Integer availableEconomyPlaces;
    private Integer availableBusinessPlaces;
    private ArrayList<Passenger> passengers;
    private Integer fuel;


    public Airplane() {
    }

    /**
     * This is constructor of plane
     * @param currentLocation departure location
     * @param destination place of arrival
     * @param flightNumber number of flight which transfer to the passenger
     * @param model model of plane defines available places on the board
     * @param flightStartDate day of flight
     * @param flightStartTime departure time
     * @param flightFinishTime arrival time
     */
    public Airplane(String currentLocation, String destination, String flightNumber, String model,
                    Integer flightStartDate,  String flightStartTime, String flightFinishTime) {
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        this.currentLocation = currentLocation;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.model = model;
        this.flightStartDate = flightStartDate;
        this.flightStartTime = flightStartTime;
        this.flightFinishTime = flightFinishTime;
        this.availableBusinessPlaces = getPlacesByName(model, "business");
        this.availableEconomyPlaces = getPlacesByName(model, "economy");
        this.fuel = getFuelByName(model);
        this.passengers = passengers;
    }

    /**
     * This function define count of available places by plane model
     * @param model model of plane
     * @param type type of class: economy or business
     * @return number of places
     */
    public Integer getPlacesByName(String model, String type){
        if (type.equals("economy")) {
            switch (model) {
                case "Airbus A320-200":
                    return 120;
                case "Airbus A330-200":
                    return 207;
                case "Airbus A330-300":
                    return 265;
                case "Сухой Суперджет-100":
                    return 75;
                case "Boeing B737-800":
                    return 138;
                case "Boeing B777-300":
                    return 324;
                case "Airbus A319-100":
                    return 96;
                case "Ил-96":
                    return 270;
                case "Boeing B767-300":
                    return 188;
                default:
                    return 0;
            }
        } else {
            switch (model) {
                case "Airbus A320-200":
                    return 28;
                case "Airbus A330-200":
                    return 34;
                case "Airbus A330-300":
                    return 36;
                case "Сухой Суперджет-100":
                    return 12;
                case "Boeing B737-800":
                    return 20;
                case "Boeing B777-300":
                    return 70;
                case "Airbus A319-100":
                    return 20;
                case "Ил-96":
                    return 12;
                case "Boeing B767-300":
                    return 30;
                default:
                    return 0;
            }
        }
    }

    /**
     * This method define fuel consumption per hour of flight
     * @param model airplane model name
     * @return number of liters of fuel
     */
    public Integer getFuelByName(String model) {
        switch (model) {
            case "Airbus A320-200":
                return 2500;
            case "Airbus A330-200":
                return 5600;
            case "Airbus A330-300":
                return 5900;
            case "Сухой Суперджет-100":
                return 1700;
            case "Boeing B737-800":
                return 2480;
            case "Boeing B777-300":
                return 7800;
            case "Airbus A319-100":
                return 2350;
            case "Ил-96":
                return 7800;
            case "Boeing B767-300":
                return 4800;
            default:
                return 0;
        }
    }

    /**
     * This method translate start time and finish time by string to number
     * @param flightStartTime departure time
     * @param flightFinishTime arrival time
     * @return number of hours in flight
     */
    public Double getTimeByWay(String flightStartTime, String flightFinishTime){
        int mins;
        int hours;
        int startHour = Integer.parseInt(flightStartTime.substring(0, 2));
        int finishHour = Integer.parseInt(flightFinishTime.substring(0, 2));
        int startMin = Integer.parseInt(flightStartTime.substring(2, 4));
        int finishMin = Integer.parseInt(flightFinishTime.substring(2, 4));
        hours = finishHour - startHour;
        if (hours < 0) {
            hours += 24;
        }
        mins = finishMin - startMin;
        if (mins < 0) {
            mins += 60;
            hours -= 1;
        }
        return Math.round(((double) hours + (double) mins / 60) * 100.0) / 100.0;
    }

    /**
     * @param crew current crew for new flight
     */
    public void setCrewNumber(Crew crew){
        if (crew.getStaffSize() < 5){
            System.out.println("insufficient crew");
        } else {
            this.crewNumber = crew.getCrewNumber();
        }
    }

    /**
     * Pricing business class
     * @return cost ticket in business class
     */
    public Integer getBusinessCost(){
        return (int) (47 * getFuelByName(model) * getTimeByWay(this.flightStartTime, this.flightFinishTime) * 300 /
                30 / ((availableEconomyPlaces + availableBusinessPlaces)));

    }

    /**
     * Pricing economy class
     * @return cost ticket in economy class
     */
    public Integer getEconomyCost(){
        return (int) ((47 * getFuelByName(model) * getTimeByWay(this.flightStartTime, this.flightFinishTime) * 100 / 30 - getBusinessCost()
                * availableBusinessPlaces) / availableEconomyPlaces);
    }


    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getModel() {
        return model;
    }

    public Integer getFlightStartDate() {
        return flightStartDate;
    }

    public String getFlightStartTime() {
        return flightStartTime;
    }

    public void setFlightStartTime(String flightStartTime) {
        this.flightStartTime = flightStartTime;
    }

    public Integer getAvailableEconomyPlaces() {
        return availableEconomyPlaces;
    }

    public Integer getAvailableBusinessPlaces() {
        return availableBusinessPlaces;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setAvailableEconomyPlaces(Integer availableEconomyPlaces) {
        this.availableEconomyPlaces = availableEconomyPlaces;
    }

    public void setAvailableBusinessPlaces(Integer availableBusinessPlaces) {
        this.availableBusinessPlaces = availableBusinessPlaces;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "currentLocation='" + currentLocation + '\'' +
                ", destination='" + destination + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", flightStartDate=" + flightStartDate.toString().substring(0, 4) + "." +
                flightStartDate.toString().substring(4, 6) + "." + flightStartDate.toString().substring(6, 8) + '\'' +
                ", flightFinishTime='" + flightFinishTime.substring(0, 2) + ":" + flightFinishTime.substring(2, 4) +'\'' +
                ", flightStartTime='" + flightStartTime.substring(0, 2) + ":" + flightStartTime.substring(2, 4) +'\'' +
                '}';
    }
}
