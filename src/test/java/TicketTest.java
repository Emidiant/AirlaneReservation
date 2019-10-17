import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TicketTest {


    @Test
    public void getAirplaneByWay() {
        ArrayList<Airplane> airplanes = new ArrayList<>();
        Airplane airplane1 = new Airplane("SPB", "MSK", "1",
                "Airbus A320-200",20201002, "1720", "1920");
        airplanes.add(airplane1);
        Airplane airplane2 = new Airplane("KLG", "MSK", "2",
                "Boeing B767-300", 20201002, "1720", "0020");
        airplanes.add(airplane2);
        Airplane airplane3 = new Airplane("SPB", "MSK", "3",
                "Boeing B737-800", 20201002, "1720", "1820");
        airplanes.add(airplane3);
        Ticket ticket = new Ticket();
        assertNotNull(ticket.getAirplaneByWay("KLG", "MSK", airplanes));
    }
}