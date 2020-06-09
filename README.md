# Игровой веб-сервер

Игровой сервер для подсчёта и отображения рейтинга игроков

## Rest API

### Records

**GET** Получение всех записей

`http://localhost:8080/rest/api/records`

**GET** Получение всех записей по пользователю

`http://localhost:8080/rest/api/record/username/{username}`

**GET** Получение всех записей по игре

`http://localhost:8080/rest/api/record/game/{game}`

**POST** Добавление записи 

`http://localhost:8080/rest/api/records?username={username}&game={game}&score={score}`

**DELETE** Удаление записи по игре

`http://localhost:8080/rest/api/records/game`

## Веб-интерфейс 

http://localhost:8080, http://localhost:8080/main - главная страница  
http://localhost:8080/signin - вход  
http://localhost:8080/signup - регистрация  
http://localhost:8080/homepage - домашняя страница  
http://localhost:8080/records - просмотор записей   
http://localhost:8080/games - добавление записей  
http://localhost:8080/admin - админ-страница  
http://localhost:8080/error - страница ошибки  

## Используемые технологии

1. JetBrains IntelliJ IDEA, WebStrom, DataGrip, Postman
2. Java 11, Gradle
3. Spring Framework, Security, Boot
4. PostgreSQL
5. Hibernate, Lombok
6. Thymeleaf
