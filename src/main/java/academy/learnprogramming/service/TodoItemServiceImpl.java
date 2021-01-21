package academy.learnprogramming.service;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {
    
    // == fields ==
    @Getter
    private final TodoData data = new TodoData();
    
    
    // == public methods ==
    @Override
    public void addItem(TodoItem toAdd) {
        data.addTodoItem(toAdd);
    }
    
    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }
    
    @Override
    public TodoItem getItem(int id) {
        return data.getTodoItem(id);
    }
    
    @Override
    public void updateItem(TodoItem toUpdate) {
        data.updateItem(toUpdate);
    }

}
