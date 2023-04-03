import java.util.ArrayList;
import java.util.List;

public class ToDoRepositoryImpl implements ToDoRepository {
    protected List<ToDo> todoList = new ArrayList<>();

    private int autoincrementId = 0;
    @Override
    public void addToDo(ToDo toDo) {
        if (toDo.getId() == -1){
            toDo.setId(autoincrementId++);
        }

        todoList.add(toDo);
    }

    @Override
    public void deleteToDo(ToDo toDo) {
        todoList.remove(toDo);
    }

    @Override
    public void updateToDo(ToDo toDo) {
        ToDo old = getToDo(toDo.getId());
        deleteToDo(old);
        addToDo(toDo);
    }

    @Override
    public ToDo getToDo(int id) {
        ToDo result = null;
        for(ToDo todo: todoList){
            if (todo.getId() == id){
                result = todo;
            }
        }
        return result;
    }

    @Override
    public List<ToDo> getTodoList() {
        return todoList;
    }
}
