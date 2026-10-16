import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {

    Vending vendor = new Vending(5,6);

    @Test
    void addMoneyTest() {
        vendor.addMoney(10.0);
        assertEquals(10.0, vendor.getBalance() + 10.0);
    }
    @Test
    void getItem() {

    }
    @Test
    void emptyVendor() {

    }
}