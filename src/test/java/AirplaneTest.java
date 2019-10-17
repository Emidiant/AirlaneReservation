import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AirplaneTest {

    @Test
    public void getTimeByWay() {
        Airplane airplane = new Airplane();
        Double actual = airplane.getTimeByWay("1840", "0010");
        assertThat(actual,   is(5.5));
    }

    @Test
    public void getPlacesByName(){
        Airplane airplane = new Airplane();
        Integer actual = airplane.getPlacesByName("Airbus A320-200", "economy");
        assertThat(actual,   is(120));
    }

    @Test
    public void getFuelByName() {
        Airplane airplane = new Airplane();
        Integer actual = airplane.getFuelByName("Airbus A320-200");
        assertThat(actual,   is(2500));
    }
}