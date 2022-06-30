# Проект - Tracker

## О проекте  

Учебный проект - Консольное приложение "Tracker", система для работы с заявками.
Позволяет добавлять, редактировать, удалять, искать и сортировать заявки.
Имеет несколько вариантов хранения данных: в памяти и в базах данных.
Цель проекта: демонстрация основных принципов ООП (особенности архитектуры, 
взаимодействие объектов, модели данных, хранилища и т.д.)

![Tracker](images/tracker_menu.png)

#### Технологии
>JDK14, Maven, PostgreSQL, Hibernate, Liquibase, Java SE, JDBC, Mockito, JUnit4

## Сборка

Для сборки проекта необходимо:
- Установить JDK 14, Maven.
- Установить PostgreSQL, задать логин - postgres, пароль - password.
- Скачать исходный код проекта с GitHub.
- Перейти в папку, где лежит файл pom.xml.
- Создайте базу данных в соответствии с настройками, указанными в файле *src/main/resources/app.properties*. 
- Осуществите сборку приложения: `mvn clean install`
- Запустите из консоли командой: `java -jar target/tracker.jar`

## Использование
Работа приложения начинается с главного меню. Для навигации по меню используются цифры


<img height="500" src="images\tracker_use.gif" width="600"/>

### Контакты:
[<img align="left" alt="telegram" width="18px" src="https://cdn.jsdelivr.net/npm/simple-icons@3.3.0/icons/telegram.svg" />][telegram]
[<img align="left" alt="gmail" width="18px" src="https://cdn.jsdelivr.net/npm/simple-icons@3.3.0/icons/gmail.svg" />][gmail]
[<img align="left" alt="LinkedIn" width="18px" src="https://cdn.jsdelivr.net/npm/simple-icons@v3/icons/linkedin.svg" />][linkedin]


[telegram]: https://t.me/GrokDen
[gmail]: mailto:den.voiten@gmail.com
[linkedin]: https://www.linkedin.com/in/denis-voytenko-585488117/
