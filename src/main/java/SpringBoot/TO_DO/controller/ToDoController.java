package SpringBoot.TO_DO.controller;

import SpringBoot.TO_DO.dto.request.ToDoRequestDTO;
import SpringBoot.TO_DO.dto.response.ToDoResponseDTO;
import SpringBoot.TO_DO.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @PostMapping("/save")
    public ResponseEntity<ToDoResponseDTO> createToDo(@RequestBody ToDoRequestDTO toDoRequestDTO) {
        ToDoResponseDTO createdToDo = toDoService.createToDo(toDoRequestDTO);

        return ResponseEntity.status(201).body(createdToDo);
    }

}
