package models.Product;

import models.Category.Category;
import models.People.Supplier;

public abstract class Product {
    private String description;
    private double costPrice;
    private double sellingPrice;
    private Supplier supplier;
    private String productionDate;
    private int quantity;
    private Category category;
    private long barCode;
    private String brand;

    public Product(String description, double costPrice, double sellingPrice,
                   Supplier supplier, int quantity, long barcode, Category category) {
        this.description = description;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.supplier = supplier;
        this.quantity = quantity;
        this.barCode = barcode;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public models.People.Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(models.People.Supplier supplier) {
        this.supplier = supplier;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getBarCode() {
        return barCode;
    }

    public void setBarCode(long barCode) {
        this.barCode = barCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

