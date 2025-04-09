# ✅ java-task-manager — Ваш персональный менеджер задач

![Task-manager Banner](image_task-manager.jpeg)

![Java](https://img.shields.io/badge/Java-21-orange)  
![JUnit](https://img.shields.io/badge/JUnit-5-orange)

---

## 📝 Описание проекта

**java-task-manager** — это консольное приложение для управления задачами, созданное мной с нуля для упрощения планирования и отслеживания рабочего процесса. Это учебный проект, который помог мне отточить навыки работы с **Java Core** и разобраться в принципах управления задачами в памяти приложения. Это не просто программа — это инструмент, который помогает организовать хаос и привести дела в порядок.

**Почему я создал этот проект?**
- Чтобы научиться управлять задачами без внешних баз данных.
- Отработать работу с приоритетами и временными метками.
- Реализовать функционал истории просмотров задач.

**Какую проблему решает?**  
Если вы хотите навести порядок в своих задачах или попрактиковаться в управлении временем, java-task-manager станет вашим помощником. Всё управление происходит в одном месте — просто и удобно.

**Технологии:**
- **Java 21** — ядро проекта.
- **HttpServer** и **HttpExchange** — для локального сервера.
- **JUnit 5** — для тестирования кода.

---

## 🚀 Возможности

Вот что умеет **java-task-manager**:
- **Управление задачами:**
  - Создание, обновление и удаление задач (всё хранится в памяти).
- **Время и приоритеты:** Привязка задач ко времени и установка уровней приоритета.
- **Типы задач:**
  - **Эпики** — крупные задачи.
  - **Задачи** — основные единицы работы.
  - **Подзадачи** — детализация эпиков.
- **История просмотров:** Отслеживание задач, которые вы просматривали.
- **Локальный сервер:** Работает на порту 8080.
- **Эндпоинты API:**
  - `/tasks` — список всех задач.
  - `/epics` — работа с эпиками.
  - `/subtasks` — управление подзадачами.
  - `/history` — история просмотров.
  - `/prioritized` — задачи по приоритету.

---

## 🛠️ Как запустить проект

### Требования
- **Java 21** или выше.
- Любая операционная система: Windows, macOS, Linux.

### Инструкция
1. **Склонируйте репозиторий:**  
   git clone https://github.com/your-username/java-task-manager.git
2. **Перейдите в папку проекта:**  
   cd java-task-manager
3. **Запустите приложение:**
  - В среде разработки (IntelliJ IDEA, Eclipse, VSCode): найдите файл `Main.java` и нажмите "Run".
  - Или через терминал:  
    javac Main.java  
    java Main
4. **Проверьте работу:**  
   Откройте браузер и перейдите на `http://localhost:8080`.

Если всё сделано верно, сервер запустится, и вы сможете взаимодействовать с задачами!

---

## 📋 Планы на будущее

Я планирую развивать проект дальше:
- Добавить больше тестов с использованием **JUnit**.
- Улучшить производительность работы с задачами в памяти.
- Расширить API, например, добавить эндпоинт `/tasks/completed` для завершенных задач.

---

## 🌟 Почему стоит попробовать?

- **Простота:** Минимум зависимостей, всё в одном месте.
- **Практичность:** Удобное управление задачами и приоритетами.
- **Обучение:** Отличный пример для изучения Java Core.

---

## 📬 Контакты

- **Email:** [yasha.golotin@mail.ru](mailto:yasha.golotin.mail.ru)

---

## 🤝 Как помочь проекту

Если хотите внести свой вклад, я буду рад! Форкните репозиторий, предложите свои идеи через pull request и присоединяйтесь к развитию java-task-manager.