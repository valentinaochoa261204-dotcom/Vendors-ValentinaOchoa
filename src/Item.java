class Item {
    double price;
    int stock;
    private String description;
    private String category;
    private int purchases;
    private double discountPercent;
    private boolean bestseller;

    Item(double price, int numPieces) {
        this(price, numPieces, "No description available", "Snacks");
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
        if(amount <= 0 || amount > stock) throw new IllegalArgumentException("Insufficient stock or invalid quantity");
        this.stock -= amount;
        this.purchases += amount;
    }

    double getPrice() {
        return this.price * (1 - discountPercent/ 100.0);
    }
    String getDescription() {
        return this.description;
    }
    String getCategory() {
        return this.category;
    }
    int getPurchases() {
        return this.purchases;
    }
    double getDiscountPercent() {
        return this.discountPercent;
    }
    boolean isBestseller() {
        return this.bestseller;
    }
    void setDiscountPercent(double percent) {
        if(percent < 0 || percent > 100) throw new IllegalArgumentException("Discount percent must be between 0 and 100");
        this.discountPercent = percent;
    }
    void setBestseller(boolean bestseller) {
        this.bestseller = bestseller;
    }
}