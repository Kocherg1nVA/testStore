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
#    И HomePage > нажать на элемент "Specials button (header)"
    И HomePage > ввести текст "Makeup" в поле "Search field (header)"
    И HomePage > нажать на элемент "Search button (header)"
    