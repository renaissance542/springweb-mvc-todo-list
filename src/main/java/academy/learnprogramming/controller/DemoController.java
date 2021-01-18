package academy.learnprogramming.controller;

import academy.learnprogramming.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller  // acts as a special type of @Component annotation
public class DemoController {
    
    // == fields ==
    private final DemoService demoService;
    
    // == constructor ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }
    
    // == request methods ==
    
    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    

    @GetMapping("goodbye")
    public String goodbye(Model model){
        log.info("model = {}", model);
        return "goodbye";
    }
    
    // http://localhost:8080/todo-list/welcome   <-- this is before the @RequestParam was used
    // http://localhost:8080/todo-list/welcome?user=Phil&age=35  <-- this provides @RequestParam String user
    @GetMapping("welcome")  // viewResolver builds prefix(/WEB-INF/view/) + view(welcome) + suffix (.jsp)
    public String welcome(@RequestParam String user, @RequestParam int age, Model model){
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        log.info("model = {}", model);
        return "welcome";
    }
    
    // == model attributes ==
    
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }
    
//    @ModelAttribute("helloMessage")
//    public String helloMessage(){
//        log.info("helloMessage() called.");
//        return demoService.getHelloMessage("Phil");
//    }
    

}















