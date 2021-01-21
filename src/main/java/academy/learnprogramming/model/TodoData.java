package academy.learnprogramming.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@Slf4j
public class TodoData {
    
    // == fields ==
    private static int idValue = 1;  // will be auto-incremented
    private final List<TodoItem> todoItems = new ArrayList<>();
    
    // == constructors ==
    public TodoData() {
        
        // add dummy data using the addTodoItem method to set the id field
        todoItems.add(new TodoItem("first", "first details",
                LocalDate.now()));
        todoItems.add(new TodoItem("second", "second details",
                LocalDate.now()));
        todoItems.add(new TodoItem("third", "third details",
                LocalDate.now()));
        todoItems.add(new TodoItem("See doctor", "Dr Smith Limerick",
                LocalDate.of(2021, 2,3)));
        todoItems.add(new TodoItem("Punch faces", "all the faces that need it",
                LocalDate.of(2021, 03, 14)));
        log.info("Dummy Data added");
        
    }
    
    // == public methods ==
    public List<TodoItem> getTodoItems(){
        return Collections.unmodifiableList(todoItems);
    }
    
    public TodoItem getTodoItem(int id){
        for(TodoItem item: todoItems){
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    
    public void addTodoItem(@NonNull TodoItem toAdd) {
        // below replaced by Lombok @NonNull annotation
//        if (toAdd == null) {
//            throw new NullPointerException("toAdd is a required parameter.");
//        }
        toAdd.setId(idValue++);
        todoItems.add(toAdd);

    }
    
    public void removeItem(int id){
        // must use ListIterator for modification; foreach doesn't work to remove or update
        ListIterator<TodoItem> itemListIterator = todoItems.listIterator();
        
        while(itemListIterator.hasNext()){
            TodoItem item = itemListIterator.next();
            
            if (item.getId() == id) {
                todoItems.remove(item);
                break;
            }
        }
    }
    
    public void updateItem(@NonNull TodoItem toUpdate){
        ListIterator<TodoItem> itemListIterator = todoItems.listIterator();
    
        while(itemListIterator.hasNext()){
            TodoItem item = itemListIterator.next();
        
            if (item.equals(toUpdate)) {
                itemListIterator.set(toUpdate);
                break;
            }
        }
    }
    
}
