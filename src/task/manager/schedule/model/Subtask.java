package task.manager.schedule.model;

import java.time.LocalDateTime;

public class Subtask extends Task {

    private Integer epicId;

    public Subtask(String name, Status status, String description, LocalDateTime startTime, long duration, int epicId) {

        super(name, status, description, startTime, duration);
        setEpicId(epicId);
    }

    public Subtask(int id, String name, String description, Status status, LocalDateTime startTime, long duration, Integer epicId) {
        super(name, status, description, startTime, duration);
        setId(id);
        setEpicId(epicId);
    }

    @Override
    public Integer getEpicId() {
        return epicId;
    }

    @Override
    public TaskType getType() {
        return TaskType.SUBTASK;
    }

    public void setEpicId(Integer epicId) {
        this.epicId = epicId;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "epicId=" + epicId +
                '}';
    }
}
