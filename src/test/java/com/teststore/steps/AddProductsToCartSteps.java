package com.teststore.steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import org.openqa.selenium.By;
import java.util.regex.*;

import static com.codeborne.selenide.Selenide.$;

public class AddProductsToCartSteps extends AbstractSteps {

    @И(value = "^(.+) > добавить товар в корзину по цене \"(.+)\"$")
    public void addToCartByPrice(String pageName, String productPrice) {
        try {
            String productXpath = String.format("//div[@class='oneprice' and contains (text(), '%s')]/ancestor::div[@class='pricetag jumbotron']//a", productPrice);
            String productId = $(By.xpath(productXpath)).getAttribute("data-id");
            String addToCartXpath = String.format("//a[@data-id='%s'][@title='Add to Cart']/parent::div[@class='pricetag jumbotron']//i", productId);
            $(By.xpath(addToCartXpath)).click();
            LOGGER.info("Успешно: на странице '{}' найден товар '{}' и добавлен в корзину", pageName, productPrice);
        } catch (Exception e) {
            throw new AssertionError(String.format("Ошибка: на странице '%s' не найден товар '%s'", pageName, productPrice));
        }
    }

    @И(value = "^(.+) > добавить товар в корзину по названию \"(.+)\"$")
    public void addToCartByName(String pageName, String productName) {
        String productXpath = String.format("//a[@title='%s']", productName);
        SelenideElement product = $(By.xpath(productXpath));
        String href = product.getAttribute("href");

        if (href != null) {
            Pattern pattern = Pattern.compile("product_id=(\\d+)");
            Matcher matcher = pattern.matcher(href);
            try {
                if (matcher.find()) {
                    String productId = matcher.group(1);
                    String addToCartXpath = String.format("//a[@data-id='%s'][@title='Add to Cart']/parent::div[@class='pricetag jumbotron']//i", productId);
                    $(By.xpath(addToCartXpath)).click();
                    LOGGER.info("Успешно: на странице '{}' найден товар '{}' и добавлен в корзину", pageName, productName);
                } else {
                    LOGGER.error("Ошибка: на странице '{}' не найден товар '{}'", pageName, productName);
                }
            } catch (Exception e) {
                throw new AssertionError(e);
            }
        } else {
            throw new IllegalStateException(String.format("У товара '%s' на странице '%s' отсутствует атрибут href", productName, pageName));
        }
    }
    //TODO объединить методы в один для устранения дублирования кода
    //TODO улучшить логирование при негативном сценарии

}
