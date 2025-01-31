package SpringBoot.TO_DO.controller;

import SpringBoot.TO_DO.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;
}
