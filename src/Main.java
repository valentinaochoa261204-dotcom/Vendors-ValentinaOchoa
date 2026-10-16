public class Main {
    public static void main(String[] args) {
        
        System.out.println("Welcome to Ultra Shop!");
        Vending[] vendors = new Vending[5];
        for (int i = 0; i < vendors.length; i++) {
            vendors[i] = new Vending(5 + i, 3 + i);
            vendors[i].addOrRestockItem("Apple", 3.00, i + 1,
                    "Healthy Snack", "Food");
        }

        vendors[0].markBestseller("Candy", true);
        vendors[1].applyCategoryDiscount("Snacks", 10);

        for (int i = 0; i < vendors.length; i++) {
            System.out.println("\nVendor " + (i + 1) + " inventory:");
            vendors[i].printInventory();
        }
        System.out.println("\nMaintained by Valentina");

    }
}