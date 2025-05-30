# README.md для папки `exception`

## Описание

Папка `exception` содержит классы исключений и обработчик ошибок для приложения `service.task.manager`. Эти компоненты обеспечивают централизованную обработку ошибок, возникающих при выполнении запросов к REST API, и возвращают клиенту понятные сообщения об ошибках с соответствующими HTTP-статусами. Исключения используются для обработки специфичных ошибок, таких как отсутствие ресурса, конфликты или некорректные данные, а обработчик (`ErrorHandler`) преобразует их в стандартизированные ответы.

## Структура папки

### 1. Исключения

- **`ConflictException.java`**  
  **Описание**: Исключение, выбрасываемое при конфликте данных, например, при попытке создать ресурс с уже существующим именем.  
  **Использование**: Возвращает HTTP-статус `409 Conflict`.  
  **Пример**: Попытка создать эпик с названием, которое уже используется.

- **`InvalidTaskDataException.java`**  
  **Описание**: Исключение для случаев, когда данные задачи, эпика или подзадачи некорректны (например, логические ошибки в данных).  
  **Использование**: Возвращает HTTP-статус `400 Bad Request`.  
  **Пример**: Указана некорректная длительность задачи.

- **`NotFoundException.java`**  
  **Описание**: Исключение, выбрасываемое, когда запрашиваемый ресурс (задача, эпик, подзадача) не найден.  
  **Использование**: Возвращает HTTP-статус `404 Not Found`.  
  **Пример**: Запрос эпика по несуществующему ID.

- **`TaskConstraintViolationException.java`**  
  **Описание**: Исключение для случаев, когда нарушены ограничения целостности данных задачи (например, бизнес-правила).  
  **Использование**: Возвращает HTTP-статус `400 Bad Request`.  
  **Пример**: Попытка создать подзадачу без указания связанного эпика.

### 2. Обработчик ошибок

- **`ErrorHandler.java`**  
  **Описание**: Централизованный обработчик исключений, реализованный с использованием `@RestControllerAdvice`. Преобразует исключения в HTTP-ответы с соответствующими статусами и сообщениями об ошибках.  
  **Обработанные исключения**:
    - `NotFoundException` → `404 Not Found`, возвращает `ErrorResponse` с сообщением.
    - `InvalidTaskDataException` → `400 Bad Request`, возвращает `ErrorResponse` с сообщением.
    - `TaskConstraintViolationException` → `400 Bad Request`, возвращает `ErrorResponse` с сообщением.
    - `ConflictException` → `409 Conflict`, возвращает `ErrorResponse` с сообщением.
    - `MethodArgumentNotValidException` → `400 Bad Request`, возвращает `Map<String, String>` с ошибками валидации полей DTO.
    - `ConstraintViolationException` → `400 Bad Request`, возвращает `Map<String, String>` с ошибками валидации (например, для `@PathVariable`).
    - `HandlerMethodValidationException` → `400 Bad Request`, возвращает `Map<String, String>` с ошибками валидации параметров метода.  
      **Внутренний рекорд**:
    - `ErrorResponse` — Простая структура для возврата сообщения об ошибке в формате JSON: `{ "message": "Ошибка" }`.

## Основные особенности

- **Централизованная обработка**: `ErrorHandler` обрабатывает все исключения в одном месте, обеспечивая единообразие ответов.
- **Документация ошибок**: HTTP-статусы и сообщения об ошибках соответствуют стандартам REST API и документируются в Swagger (см. `/swagger-ui.html`).
- **Валидация**:
    - Ошибки валидации DTO (`MethodArgumentNotValidException`) возвращают словарь с названиями полей и сообщениями об ошибках.
    - Ошибки валидации параметров (`ConstraintViolationException`, `HandlerMethodValidationException`) также возвращают словарь с указанием проблемных параметров.
- **Гибкость**: Исключения покрывают различные сценарии (конфликты, отсутствие данных, некорректные запросы), что упрощает расширение системы.

## Использование

Исключения выбрасываются в сервисах или контроллерах, когда возникают ошибки. `ErrorHandler` автоматически перехватывает их и формирует ответ для клиента.

**Пример ответа для `NotFoundException`**:
```json
{
  "message": "Эпик с ID 1 не найден"
}
```

**Пример ответа для `MethodArgumentNotValidException`**:
```json
{
  "name": "blank name",
  "description": "blank description"
}
```

## Документация API

Ошибки документируются в Swagger UI, доступном по пути:
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

Каждый эндпоинт в контроллерах (`controller`) включает описание возможных ошибок и соответствующих HTTP-статусов (например, `404`, `409`).

## Примечания

- **Расширяемость**: Новые исключения можно добавить, создав класс, унаследованный от `RuntimeException`, и добавив его обработку в `ErrorHandler`.
- **Логирование**: Рекомендуется добавить логирование ошибок в `ErrorHandler` для отладки (например, с использованием SLF4J).
- **Консистентность**: Все ответы об ошибках возвращаются в формате JSON, что упрощает их обработку на клиентской стороне.

## Дополнительно

Для информации о контроллерах, DTO или сервисах см. соответствующие папки (`controller`, `dto`, `service`). По вопросам настройки или расширения системы обработки ошибок обратитесь к документации проекта или разработчикам.