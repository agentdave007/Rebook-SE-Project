package com.example.rebook.launch;

public class CategoryModel {
    private String Categoryiconlink;
    private String CategoryName;

    public CategoryModel(String categoryiconlink, String categoryName) {
        Categoryiconlink = categoryiconlink;
        CategoryName = categoryName;
    }

    public String getCategoryiconlink() {
        return Categoryiconlink;
    }

    public void setCategoryiconlink(String categoryiconlink) {
        Categoryiconlink = categoryiconlink;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
