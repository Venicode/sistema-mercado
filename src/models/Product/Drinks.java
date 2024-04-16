package models.Product;

public class Drinks extends Product {
    private double liters;
    private boolean alcoholic;
    private String expirationDate;

    public Drinks(String description, double costPrice,
                  double sellingPrice, models.People.Supplier supplier,
                  int quantity, double liters, boolean alcoholic,
                  String expirationDate, long barcode) {
        super(description, costPrice, sellingPrice, supplier, quantity, barcode);
        this.liters = liters;
        this.alcoholic = alcoholic;
        this.expirationDate = expirationDate;
    }
    public boolean isLegalAge(int age){
        if(age>=18){
            return true;
        } if(age<0){
            System.out.println("Idade inválida");
        }return false;
    }
    public double getLiters() {
        return liters;
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(boolean alcoholic) {
        this.alcoholic = alcoholic;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
