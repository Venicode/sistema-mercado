package models.Category;

public class Category {
    private int cod_Category;
    private String descriptionCategory;

    public Category(int cod_Category, String descriptionCategory){
        this.cod_Category = cod_Category;
        this.descriptionCategory = descriptionCategory;
    }
    public String getDescriptionCategory() {
        return descriptionCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        this.descriptionCategory = descriptionCategory;
    }

    public int getCod_Category() {
        return cod_Category;
    }

    public void setCod_Category(int cod_Category) {
        this.cod_Category = cod_Category;
    }
}
