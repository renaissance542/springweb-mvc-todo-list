package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
public class TodoItemController {
    
    // == fields ==
        // TodoData service field
    
    
    // == constructors ==
        // instantiates  the TodoData service
    
    // == handler methods ==
    
    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items (Model model){
        
        log.info("model = {}", model);
        return ViewNames.ITEMS_LIST;
    }
    
    // == model attributes ==
    
    @ModelAttribute("todoList")
    public TodoData todoData (){
        return new TodoData();
    }
        // map model to .jsp files and add attributes to the model
        // call services to manipulate data to be added to the model
        // the .jsp page will simply call the data that has already been modified
}
