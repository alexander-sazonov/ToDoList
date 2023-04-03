import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoRepositoryFileImpl extends ToDoRepositoryImpl {

        private String fileName;

    public ToDoRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
        File file = new File(fileName);
        if(file.exists()){
            readFromFile();
        }

    }

    private void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tmp = line.split(",");
                int id = Integer.parseInt(tmp[0]);
                String name = tmp[1];
                String description = tmp[2];
                ToDo toDo = new ToDo(name, description);
                toDo.setId(id);
                todoList.add(toDo);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveToFile(){
        try(FileWriter fw = new FileWriter(fileName);){
           for(ToDo toDo: todoList){
               String line = String.format("%d,%s,%s\n",toDo.getId(),toDo.getName(), toDo.getDescription());
               fw.write(line);
           }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addToDo(ToDo toDo) {
        super.addToDo(toDo);
        saveToFile();
    }

    @Override
    public void deleteToDo(ToDo toDo) {
        super.deleteToDo(toDo);
        saveToFile();

    }

    @Override
    public void updateToDo(ToDo toDo) {
        super.updateToDo(toDo);
        saveToFile();
    }

    @Override
    public ToDo getToDo(int id) {
        return super.getToDo(id);
    }

    @Override
    public List<ToDo> getTodoList() {
        return super.getTodoList();
    }
}
