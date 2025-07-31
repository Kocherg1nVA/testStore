package com.teststore.steps;

import io.cucumber.java.ru.И;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddProductsToCartSteps extends AbstractSteps {

    @И(value = "^(.+) > добавить товар в корзину по (названию|цене) \"(.+)\"$")
    public void addToCart(String pageName, String parameterType, String product) {
        LOGGER.info("Добавление товара '{}' по '{}' в корзину", product, parameterType);
        try {
            String productXpath;
            if (parameterType.equals("названию")) {
                productXpath = String.format("//a[@class='prdocutname' and contains(text(), '%s')]/ancestor::div[@class='col-md-3 col-sm-6 col-xs-12']//a[@class='productcart']", product);
            } else {
                productXpath = String.format("//div[@class='oneprice' and contains (text(), '%s')]/ancestor::div[@class='pricetag jumbotron']//a", product);
            }
            String productId = $(By.xpath(productXpath)).getAttribute("data-id");
            LOGGER.debug("Id товара: " + productId);
            String addToCartXpath = String.format("//a[@data-id='%s'][@title='Add to Cart']/parent::div[@class='pricetag jumbotron']//i", productId);
            $(By.xpath(addToCartXpath)).click();
            LOGGER.info("Успешно: на странице '{}' найден товар по '{}' '{}' и добавлен в корзину", pageName, parameterType, product);
        } catch (Exception e) {
            LOGGER.error("Ошибка: на странице '{}' не найден товар по '{}' '{}'", pageName, parameterType, product);
            throw new AssertionError(e);
        }
    }
}

