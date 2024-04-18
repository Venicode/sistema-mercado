package controller;

import models.Category.Category;

import java.util.ArrayList;

public class CategoryController {
    private final ArrayList<Category> listCategoryRegistered = new ArrayList<>();

    public CategoryController(){
        registerCategory();
    }
    public void addCategoryToList(Category newCategory){
        listCategoryRegistered.add(newCategory);
    }
    private void registerCategory(){
        Category grocery = new Category(0 , "Alimentos");
        addCategoryToList(grocery);
        Category drinks = new Category(1, "Bebidas");
        addCategoryToList(drinks);
    }
    public boolean checkCategory(int codCategory){
        for (Category category: listCategoryRegistered) {
            return category.getCod_Category() == codCategory;
        } return  false;
    }

    public ArrayList<Category> getListCategoryRegistered() {
        return listCategoryRegistered;
    }
    public Category insertCategoryToProduct(int cod_Category) {
        return listCategoryRegistered.get(cod_Category);
    }
}
