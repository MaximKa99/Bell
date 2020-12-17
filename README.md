## 🧐 Что за проект? <a name = "about"></a>

Учебный проект для Bell Integrator

### Что необходимо для запуска?

-Java 1.8
-Maven

### Установка

```
git clone https://github.com/MaximKa99/Bell.git
```

### Запуск

Запуск должен производиться из папки проекта

```
mvn spring-boot:run
```

## 🔧 Запуск тестов <a name = "tests"></a>

Запуск должен производиться из папки проекта

```
mvn verify
```

## 🎈 Как это использовать?

Данное приложение поддерживает четыре взаимодействия над тремя сущностями(Organization, Office, User)
- Получения сущности по его id ((GET)http://localhost:8888/api/{сущность}/{id})
- Получения списка сущностей по заданому фильтру ((POST)http://localhost:8888/api/{сущность}/list)
- Обновление существующей сущности ((POST)http://localhost:8888/api/{сущность}/update)
- Сохранение существующей сущности ((POST)http://localhost:8888/api/{сущность}/save)

## ✍️ Кто автор? <a name = "authors"></a>

- [@MaximKa99](https://github.com/MaximKa99)
