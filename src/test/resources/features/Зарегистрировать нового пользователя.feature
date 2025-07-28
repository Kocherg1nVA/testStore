#language:ru
Функционал: Регистрация
  Сценарий: Зарегистрировать нового пользователя

    Дано Открыть домашнюю страницу
    И HomePage > проверить, что на странице присутствует текст "Welcome to the Automation Test Store!"
    И HomePage > проверить, что на странице присутствует текст "This is not a real store. No orders are actually placed or any payments taken."
    И HomePage > проверить, что на странице присутствует текст "It is recommended you use test data when practicing using this site."
    И HomePage > проверить, что на странице присутствует текст "This site is to be used for educational purposes only. Enjoy!"

    И хранилище > сохранить текущую дату в хранилище с ключом "current_date"

    И инициализировать тестовые данные с подстановкой "current_date"
    |Ключ              |Значение         |
    |First Name        |Ivan             |
    |Last Name         |Ivanov           |
    |email             |test<>@test.ru   |
    |Address 1         |Lenina, 2        |
    |Country           |Russia           |
    |Region / State    |Mari El Republic |
    |City              |Yoshkar-Ola      |
    |ZIP Code          |424000           |
    |Login name        |User<>           |
    |Password          |qwerty!<>        |
    |Password confirm  |qwerty!<>        |

    И HomePage > нажать на элемент "Login or register button (header)"
    И ожидать 2 секунд

    И LoginPage > проверить по полному совпадению, что на странице присутствует текст "I am a new customer."
    И LoginPage > нажать на элемент "Continue registration button"
    И ожидать 2 секунд


    И CreateAccountPage > проверить по полному совпадению, что на странице присутствует текст "Your Personal Details"
    И CreateAccountPage > ввести значение по ключу "First Name" тестовых данных в поле "First Name field"
    И ожидать 2 секунд

    И CreateAccountPage > ввести значение по ключу "Last Name" тестовых данных в поле "Last Name field"
    И ожидать 2 секунд

    И CreateAccountPage > ввести значение по ключу "email" тестовых данных в поле "Email field"
    И ожидать 2 секунд

    И CreateAccountPage > проскроллить страницу до текста "Your Address"
    И CreateAccountPage > ввести значение по ключу "Address 1" тестовых данных в поле "Address1 field"
    И ожидать 2 секунд

    И CreateAccountPage > выбрать элемент из выпадающего списка "Country dropdown" по ключу "Country" тестовых данных
    И ожидать 2 секунд

    И CreateAccountPage > выбрать элемент из выпадающего списка "Region / State dropdown" по ключу "Region / State" тестовых данных
    И ожидать 2 секунд

    И CreateAccountPage > ввести значение по ключу "City" тестовых данных в поле "City field"
    И ожидать 2 секунд

    И CreateAccountPage > ввести значение по ключу "ZIP Code" тестовых данных в поле "ZIP Code field"
    И ожидать 2 секунд

    И CreateAccountPage > проскроллить страницу до текста "Login Details"
    И CreateAccountPage > ввести значение по ключу "Login name" тестовых данных в поле "Login name field"
    И ожидать 2 секунд

    И CreateAccountPage > ввести значение по ключу "Password" тестовых данных в поле "Password field"
    И ожидать 2 секунд

    И CreateAccountPage > ввести значение по ключу "Password confirm" тестовых данных в поле "Password Confirm field"
    И ожидать 2 секунд

    И CreateAccountPage > установить чек-бокс "Subscribe No radio button"
    И CreateAccountPage > проверить, что чек-бокс "Subscribe No radio button" установлен
    И ожидать 2 секунд

    И CreateAccountPage > установить чек-бокс "Privacy Policy checkbox"
    И CreateAccountPage > проверить, что чек-бокс "Privacy Policy checkbox" установлен
    И ожидать 2 секунд

    И CreateAccountPage > нажать на элемент "Continue button"
    И ожидать 5 секунд

    И CreatedAccountPage > проверить, что на странице присутствует текст "Congratulations! Your new account has been successfully created!"
    И CreatedAccountPage > проверить, что на странице присутствует текст "You can now take advantage of member privileges to enhance your online shopping experience with us."
    И CreatedAccountPage > проверить, что на странице присутствует текст "If you have ANY questions about the operation of this online shop, please email the store owner."
    И CreatedAccountPage > проверить, что на странице присутствует текст "A confirmation has been sent to the provided email address. If you have not received it within the hour, please contact us."
#    И ожидать 2 секунд
#    И CreatedAccountPage > нажать на элемент "Continue button"

#    И CreateAccountPage > проверить, что на странице присутствует текст "Error: E-Mail Address is already registered!"
#                                                                         Login name must be alphanumeric only and between 5 and 64 characters!
