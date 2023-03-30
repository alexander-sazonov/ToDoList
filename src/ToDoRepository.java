import java.util.List;

public interface ToDoRepository {
    void addToDo(ToDo toDo);
    void deleteToDo(ToDo toDo);
    void updateToDo(ToDo toDo);
    ToDo getToDo(int id);

    List<ToDo> getToDoList();
}
