package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import academy.learnprogramming.service.TodoItemService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

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
    
    // == handler methods ==
    
//    This mapping was unnecessary because there is no need for model
//    attributes on this page.
    //    @GetMapping(Mappings.HOME)
    //    public String home(){
    //        return ViewNames.HOME;
    //    }
    
    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items (Model model){
        
        log.info("model = {}", model);
        return ViewNames.ITEMS_LIST;
    }
    
    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem (@RequestParam int id, Model model){
        model.addAttribute(AttributeNames.TODO_ITEM, todoItemService.getItem(id));
        return ViewNames.VIEW_ITEM;
    }
    
    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id, Model model){
        model.addAttribute(AttributeNames.TODO_ITEM, todoData().getTodoItem(id));
        return ViewNames.DELETE_ITEM;
    }
    
    @PostMapping(Mappings.DELETE_ITEM)
    public String processDeleteItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("Deleting item with id = {}", todoItem.getId());
        todoItemService.removeItem(todoItem.getId());
        return "redirect:/" + Mappings.ITEMS;
    }
    
    
    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(
            @RequestParam(required = false, defaultValue = "-1") int id,
            Model model){
        log.info("Add/Edit url id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        if (todoItem == null) {
            todoItem = new TodoItem("","", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }
    
    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("todoItem from form = {}", todoItem);
        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }
    

    
}















