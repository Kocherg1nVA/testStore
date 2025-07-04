package com.teststore.pages;

import com.codeborne.selenide.Selenide;
import java.util.HashMap;
import java.util.Map;

public class PageFactory {
    private static final Map<String, Class<? extends AbstractPage>> PAGE_REGISTRY = new HashMap<>();

    static {
        registerPage("home", HomePage.class);
        registerPage("login", LoginPage.class);
        registerPage("apparelandaccessories", ApparelAndAccessories.class);
        registerPage("makeup", Makeup.class);
        registerPage("skincare", Skincare.class);
        registerPage("fragrance", Fragrance.class);
        registerPage("men", Men.class);
        registerPage("haircare", HairCare.class);
        registerPage("books", Books.class);
        registerPage("specials", Specials.class);
        registerPage("cart", Cart.class);

        //TODO добавить остальные страницы
    }

    public static void registerPage(String pageName, Class<? extends AbstractPage> pageClass) {
        PAGE_REGISTRY.put(pageName.toLowerCase(), pageClass);
    }

    public static <T extends AbstractPage> T getPage(Class<T> pageClass) {
        T page = Selenide.page(pageClass);
        page.switchToPage();
        return page;
    }

    public static AbstractPage getPage(String pageName) {
        Class<? extends AbstractPage> pageClass = PAGE_REGISTRY.get(pageName.toLowerCase());
        if (pageClass == null) {
            throw new IllegalArgumentException("Неизвестная страница: " + pageName);
        }
        return getPage(pageClass);
    }
}
