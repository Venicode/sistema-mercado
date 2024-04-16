package models.Product;

public class Grocery extends Product {
    private String expirationDate;

    public Grocery(String description, double costPrice,
                   double sellingPrice, models.People.Supplier supplier,
                   int quantity, String expirationDate, long barcode) {
        super(description, costPrice, sellingPrice,
                supplier, quantity, barcode);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
