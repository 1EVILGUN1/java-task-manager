package task.manager.schedule.service;

import task.manager.schedule.model.Epic;
import task.manager.schedule.model.Subtask;
import task.manager.schedule.model.Task;

import java.util.List;

public interface TaskManager {
    Task createTask(Task task);

    Task createEpic(Epic epic);

    Subtask createSubtask(Subtask subtask);

    void updateTask(Task task);

    void updateEpic(Epic epic);

    void updateSubtask(Subtask subtask);

    void cleanTasks();

    void cleanSubtasks();

    void cleanEpics();

    void deleteTask(int id);

    void deleteSubtask(int id);

    void deleteEpic(int id);

    List<Task> getTasks();

    List<Epic> getEpics();

    List<Subtask> getEpicSubtasks(int epicId);

    Task getTask(int id);

    Epic getEpic(int id);

    Subtask getSubtask(int id);

    List<Task> getHistory();

    List<Task> getPrioritizedTasks();
}
