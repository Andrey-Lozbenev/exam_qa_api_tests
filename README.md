# Дипломный проект по тестированию API для [reqres.in](https://reqres.in/)

## :open_book: Содержание:
- [Технологии и инструменты](#gear-в-проекте-используются-следующие-технологии-и-инструменты)
- [Что проверяем](#heavy_check_mark-что-проверяем)
- [Запуск тестов из Jenkins](#-запуск-тестов-из-jenkins)
- [Запуск тестов из терминала](#computer-запуск-тестов-из-терминала)
- [Отчеты](#bar_chart-отчеты-о-прохождении-тестов-доступны-в-allure)
- - [Allure](#-allure)


## :gear: В проекте используются следующие технологии и инструменты:

<p align="center">
<img src="media/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/>
<img src="media/logo/Java.svg" width="50" height="50"  alt="Java"/>
<img src="media/logo/GitHub.svg" width="50" height="50"  alt="Github"/>
<img src="media/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/>
<img src="media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/>
<img src="media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/>
<img src="media/logo/Allure_Report.svg" width="50" height="50"  alt="Allure"/>
</p>

## :heavy_check_mark: Что проверяем

> - Проверка корректного количества отображениения пользователей на одной странице
> - Проверка отказа в авторизации пользователя без пароля
> - Проверка отказа в регитсрации у пользовтеля со сторонними регистрационными данными
> - Проверка успешного удаления чего-то :)
> - Проверка успешной авторизации пользователя
## <img width="4%" title="Jenkins" src="media/logo/Jenkins.svg"> Запуск тестов из [Jenkins](https://jenkins.autotests.cloud/job/exam_qa_api_tests/)

Для запуска тестов из Jenkins:
1. Необходимо нажать кнопку "Собрать".
   <img src="media/img/JApiStart.png" alt="Jenkins"/>
2. Нажать кнопку "Собрать".

### :earth_asia: Удаленный запуск тестов

```bash
gradle clean test
```

## :computer: Запуск тестов из терминала

Для локального запуска необходимо выполнить команду:
```
gradle clean test
```

## :bar_chart: Отчеты о прохождении тестов доступны в Allure

### <img width="3%" title="Allure" src="media/logo/Allure_Report.svg"> Allure

#### Главная страница

<img src="media/img/JApiMain.png" alt="Allure"/>

#### Тесты

<img src="media/img/JApiSuites.png" alt="Allure"/>