import java.util.ArrayList;
import java.util.List;

public class ToDoRepositoryImpl implements ToDoRepository {
    protected List<ToDo> toDoList = new ArrayList<>();

    private int autoincrementId = 0;
    @Override
    public void addToDo(ToDo toDo) {
        if (toDo.getId() == -1){
            toDo.setId(autoincrementId++);
        }

        toDoList.add(toDo);
    }

    @Override
    public void deleteToDo(ToDo toDo) {
        toDoList.remove(toDo);
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
        for(ToDo todo: toDoList){
            if (todo.getId() == id){
                result = todo;
            }
        }
        return result;
    }

    @Override
    public List<ToDo> getToDoList() {
        return toDoList;
    }
}
