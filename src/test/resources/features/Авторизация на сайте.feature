#language:ru
Функционал: Браузер
  Сценарий: Авторизация на сайте
    И Авторизоваться на сайте под логином "kochergin"
    И MyAccountPage > проверить по полному совпадению, что на странице присутствует текст "Vadim"
    И MyAccountPage > проверить, что на странице присутствует текст "Welcome back"
    И MyAccountPage > проверить, что элемент "User name" содержит текст "Vadim"
    И MyAccountPage > нажать на элемент "Makeup button"
    И MakeupPage > проверить, что элемент "Makeup button" окрасился в "blue" цвет