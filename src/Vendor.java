import java.util.HashMap;


/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vending {
    private static HashMap<String, Item> Stock = new HashMap<String, Item>();
    private double balance;

    Vending(int numCandy, int numGum) {
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(.5, numGum));
        this.balance = 0;
    }

    /**
     * resets the Balance to 0
     */
    void resetBalance() {
        this.balance = 0;
    }

    /**
     * returns the current balance
     */
    double getBalance() {
        return this.balance;
    }

    /**
     * adds money to the machine's balance
     *
     * @param amt how much money to add
     */
    void addMoney(double amt) {
        if (!Double.isFinite(amt) || amt <= 0) {
            throw new IllegalArgumentException("Amount must be positive and greater than 0");
        }
        this.balance += amt;
    }

    /**
     * attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    boolean select(String name) {
        Item item = Stock.get(name);
        if (item == null) {
            System.out.println("Sorry, item not found");
            return false;
        }
        if (item.stock == 0) {
            System.out.println("Sorry, item out of stock");
        }
        if (balance < item.getPrice()) {
            System.out.println("Sorry, you don't have enough money");
            return false;
        }
        item.purchase(1);
        this.balance -= item.getPrice();
        return true;
    }

    int getStock(String name) {
        if (Stock.containsKey(name)) {
            return Stock.get(name).stock;
        } else {
            return 0;
        }
    }
    Item getItem(String name) {
        if (Stock.containsKey(name)) {
            return Stock.get(name);
        }
        return null;
    }

    int getInventorySize() {
        return Stock.size();
    }
    void emptyInventory() {
        Stock.clear();
    }
    //First UserStory: Add stock to an existing product
    void restockItems(String name, int amount) {
        Item item = Stock.get(name);
        if (item == null) throw new IllegalArgumentException("Item not found");
        item.restock(amount);
    }
    //Second UserStory: Add a product that is not yet available, or restock an existing product
    void addOrRestockItem(String name, double price, int amount, String description, String category){
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (Stock.containsKey(name)) {
            Stock.get(name).restock(amount);
        } else {
            Stock.put(name, new Item(price, amount, description, category));
        }
    }
    boolean renameItem(String oldName, String newName) {
        if(newName == null || newName.isBlank() || !Stock.containsKey(oldName) || Stock.containsKey(newName))
                return false;
        Stock.put(newName, Stock.remove(oldName));
        return true;
    }
    boolean deleteItem(String name) {
        return Stock.remove(name) != null;
    }
}
