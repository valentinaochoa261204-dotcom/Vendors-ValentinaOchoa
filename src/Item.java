class Item {
    double price;
    int stock;
    private String description;
    private String category;

    Item(double price, int numPieces) {
        this(price, numPieces, "No description available", "General");
    }

    Item(double price, int numPieces, String description, String category) {
        if(price < 0 || numPieces < 0) throw new IllegalArgumentException("Price and stock cannot be negative");
        this.price = price;
        this.stock = numPieces;
        this.description = description;
        this.category = category;
    }
    void restock(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Restock amount must be positive");
        this.stock += amount;
    }

    void purchase(int amount) {
        this.stock = this.stock - amount;
    }

    double getPrice() {
        return this.price;
    }
    String getDescription() {
        return this.description;
    }
    String getCategory() {
        return this.category;
    }
}