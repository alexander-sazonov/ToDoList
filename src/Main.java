import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ToDoRepository toDoRepository = new ToDoRepositoryFileImpl("data.csv");
        // ToDo toDo1 = new ToDo("Задание 1","Полить цветы во всех комнатах");
        // toDoRepository.addToDo(toDo1);
        ToDo newToDo = toDoRepository.getToDo(0);
        newToDo.setDescription("Выгулять собаку");
        toDoRepository.updateToDo(newToDo);

    }


}