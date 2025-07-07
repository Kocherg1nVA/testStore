package com.teststore.model;

public enum SearchCategories {
    ALL_CATEGORIES("All Categories"),
    APPAREL_ACCESSORIES("Apparel & accessories"),
    MAKEUP("Makeup"),
    SKINCARE("Skincare"),
    FRAGRANCE("Fragrance"),
    MEN("Men"),
    HAIR_CARE("Hair Care"),
    BOOKS("Books");

    private final String categoryName;

    SearchCategories(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

}
