package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.service.TodoItemService;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
public class TodoItemController {
    
    // == fields ==
    private final TodoItemService todoItemService;
    
    
    // == constructors ==
    
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }
    
    
    // == handler methods ==
    
    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items (Model model){
        
        log.info("model = {}", model);
        return ViewNames.ITEMS_LIST;
    }
    
    // == model attributes ==
    
    @ModelAttribute("todoData")
    public TodoData todoData (){
        TodoData list = todoItemService.getData();
        log.info("TodoData size = {}", list.getTodoItems().size());
        return list;
    }
        // map model to .jsp files and add attributes to the model
        // call services to manipulate data to be added to the model
        // the .jsp page will simply call the data that has already been modified
}
