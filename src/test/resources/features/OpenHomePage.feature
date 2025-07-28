#language:ru
  Функционал: Браузер
  Сценарий: Открытие главной страницы
    Дано Открыть домашнюю страницу
    И HomePage > проверить, что на странице присутствует текст "Welcome to the Automation Test Store!"
    И HomePage > проверить, что на странице присутствует текст "This is not a real store. No orders are actually placed or any payments taken."
    И HomePage > проверить, что на странице присутствует текст "It is recommended you use test data when practicing using this site."
    И HomePage > проверить, что на странице присутствует текст "This site is to be used for educational purposes only. Enjoy!"
    И Выбрать валюту "Pound Sterling"
    И Проверить, что выбрана валюта "Pound Sterling"
    И HomePage > нажать на элемент "Books button"
    И BooksPage > добавить товар в корзину по названию "Paper Towns by John Green"
    И BooksPage > добавить товар в корзину по цене "12.75"
    И BooksPage > нажать на элемент "Cart button (header)"
    И ShoppingCartPage > проверить, что на странице присутствует текст "Paper Towns by John Green"
    И ShoppingCartPage > проверить, что на странице присутствует текст "12.85"

#    И HomePage > проскроллить страницу до текста "Brands Scrolling List"
#    И HomePage > проскроллить страницу до элемента "Slider"
#    И ожидать 2 секунд
#    И HomePage > нажать на элемент "Specials button (header)"
#    И HomePage > ввести текст "Makeup" в поле "Search field (header)"
#    И HomePage > нажать на элемент "Search button (header)"
#    И SearchPage > установить чек-бокс "Search in product description checkbox"
#    И SearchPage > проверить, что чек-бокс "Search in product description checkbox" установлен
#    И SearchPage > снять чек-бокс "Search in product description checkbox"
#    И SearchPage > проверить, что чек-бокс "Search in product description checkbox" снят
#
#    И SearchPage > нажать на элемент "Search button"
#    И SearchPage > выбрать элемент из выпадающего меню "Category dropdown" по тексту "Skincare"
#    И SearchPage > выбрать элемент из выпадающего меню "Category dropdown" по индексу 1
    И ожидать 10 секунд
    