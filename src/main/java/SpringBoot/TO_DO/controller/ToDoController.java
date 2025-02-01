package SpringBoot.TO_DO.controller;

import SpringBoot.TO_DO.dto.request.ToDoRequestDTO;
import SpringBoot.TO_DO.dto.response.ToDoResponseDTO;
import SpringBoot.TO_DO.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

@GetMapping(path = "/get-all-todos")
    public ResponseEntity<List<ToDoResponseDTO>> getAllToDos(){
        List<ToDoResponseDTO> toDos = toDoService.getAllToDos();
        return ResponseEntity.ok(toDos);

}

}
