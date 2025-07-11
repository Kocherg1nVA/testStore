#language:ru
Функционал: Регистрация
  Сценарий: Зарегистрировать нового пользователя

    Дано инициализация тестовых данных
    |Ключ              |Тип     |Значение         |
    |First Name        |String  |Ivan             |
    |Last Name         |String  |Ivanov           |
    |email             |String  |test@test.com    |
    |Address 1         |String  |Lenina, 2        |
    |City              |String  |Yoshkar-Ola      |
    |Region / State    |String  |Mari El Republic |
    |ZIP Code          |int     |424000           |
    |Country           |String  |Russia           |
    |Login name        |String  |Ivan             |
    |Password          |String  |qwerty123        |
    |Password confirm  |String  |qwerty123        |

    Дано Открыть домашнюю страницу
    И HomePage > проверить, что на странице присутствует текст "Welcome to the Automation Test Store!"
    И ожидать 2 секунд
    И HomePage > нажать на элемент "Login or register button (header)"
    И ожидать 2 секунд
    И LoginPage > проверить по полному совпадению, что на странице присутствует текст "I am a new customer."
    И LoginPage > нажать на элемент "Continue registration button"
    И ожидать 2 секунд
    И CreateAccountPage > проверить по полному совпадению, что на странице присутствует текст "Your Personal Details"
    И CreateAccountPage > ввести текст по ключу "First Name" хранилища в поле "First Name field"
    И ожидать 20 секунд
    

