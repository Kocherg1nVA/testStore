package com.teststore.pages;

import com.codeborne.selenide.Selenide;
import java.util.HashMap;
import java.util.Map;

public class PageFactory {
    private static final Map<String, Class<? extends AbstractPage>> PAGE_REGISTRY = new HashMap<>();

    static {
        registerPage("HomePage", HomePage.class);
        registerPage("LoginPage", LoginPage.class);
        registerPage("ApparelAndAccessoriesPage", ApparelAndAccessories.class);
        registerPage("MakeupPage", Makeup.class);
        registerPage("SkincarePage", Skincare.class);
        registerPage("FragrancePage", Fragrance.class);
        registerPage("MenPage", Men.class);
        registerPage("HaircarePage", HairCare.class);
        registerPage("BooksPage", Books.class);
        registerPage("SpecialsPage", Specials.class);
        registerPage("CartPage", Cart.class);
        registerPage("CreateAccountPage", CreateAccountPage.class);
        registerPage("CreatedAccountPage", CreatedAccountPage.class);
        registerPage("MyAccountPage", MyAccountPage.class);
        registerPage("AccountLogoutPage", AccountLogoutPage.class);

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
