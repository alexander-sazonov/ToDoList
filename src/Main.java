import java.util.List;

public class Main {
    public static void main(String[] args) {
        ToDoRepository repository = new ToDoRepositoryImpl();
        repository.addToDo(new ToDo("Прогулка","Сходить на часик погулять"));
        repository.addToDo(new ToDo("Поесть","Приготовить вкусный обед и съесть его"));
        repository.addToDo(new ToDo("ДЗ", "Сделать ДЗ по алгебре"));
        List<ToDo> list = repository.getToDoList();
        for(ToDo toDo: list){
            System.out.println(toDo);
        }

        ToDo newToDo = new ToDo("Отдохнуть","Посмотредь видосики на Youtube");
        newToDo.setId(2);
        repository.updateToDo(newToDo);

        for(ToDo toDo: list){
            System.out.println(toDo);
        }
    }
}