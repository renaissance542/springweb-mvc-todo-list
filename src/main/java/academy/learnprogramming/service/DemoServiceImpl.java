package academy.learnprogramming.service;

import org.springframework.stereotype.Service;

@Service  // acts as a special type of @Component annotation
class DemoServiceImpl implements DemoService {
    
    @Override
    public String getHelloMessage(String user) {
        return "Hello " + user;
    }
    
    @Override
    public String getWelcomeMessage() {
        return "Welcome to this demo application.";
    }
}
