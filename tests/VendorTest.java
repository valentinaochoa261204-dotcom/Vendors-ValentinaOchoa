import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendorTest {

    Vending vendor = new Vending(2,3);

    @Test
    void addMoneyTest() {
        vendor.addMoney(10.0);
        assertEquals(10.0, vendor.getBalance());
        vendor.resetBalance();
        assertEquals(0.0, vendor.getBalance());
    }
    @Test
    void getItemTest() {
        vendor.addMoney(2.00);
        assertTrue(vendor.select("Candy"));
        assertEquals(1, vendor.getStock("Candy"));
        assertEquals(0.75, vendor.getBalance());
    }
    @Test
    void emptyVendorTest() {
        vendor.emptyInventory();
        assertEquals(0, vendor.getInventorySize());
    }
    @Test
    void restockingItemTest(){
        vendor.restockItems("Candy", 2);
        assertEquals(4, vendor.getStock("Candy"));
    }
    @Test
    void addNewItemAndRestockTest() {
        vendor.addOrRestockItem("Apple", 4.00, 7, "Healthy snack option", "Food");
        assertEquals(7, vendor.getStock("Apple"));
        assertEquals(3, vendor.getInventorySize());
    }
}