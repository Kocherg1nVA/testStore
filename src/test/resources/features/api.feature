#language:ru
Функционал: api яд
  Сценарий: !!!

    И json запрос > создать запрос по шаблону "templates/json/test_template.json"
    И json запрос > добавить токен авторизации "OAuth y0__xCTv8ZMGM6IPCDZ9abCFTCj1NeZCNQhNjEY0y-Ypt69VTCGLfauj-wE"
#    И json запрос > добавить тело запроса:
#      """
#        {
#          "text": "test"
#        }
#      """
    И json запрос > отправить GET запрос по пути "/v1/disk/"
    И json запрос > получить ответ
    И json запрос > проверить, что в ответе пришел код 200
    И json запрос > сохранить заголовки ответа в Хранилище как "заголовки"