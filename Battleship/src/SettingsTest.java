import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettingsTest {

    @Test
    void amountOfShips() {
        Settings settings = new Settings();
        settings.amountOfShips(5);
        Assert.assertEquals(settings.SHIP_LENGTHS.size(), 5);
    }

    @Test
    void shipLengths() {
    }

    @Test
    void bombSize() {
    }

    @Test
    void getShipList() {
    }
}