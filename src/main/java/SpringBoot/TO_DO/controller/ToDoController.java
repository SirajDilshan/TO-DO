package SpringBoot.TO_DO.controller;

import SpringBoot.TO_DO.dto.request.ToDoRequestDTO;
import SpringBoot.TO_DO.dto.response.ToDoResponseDTO;
import SpringBoot.TO_DO.service.ToDoService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ToDoResponseDTO> createToDo(@Valid @RequestBody ToDoRequestDTO toDoRequestDTO) {
        ToDoResponseDTO createdToDo = toDoService.createToDo(toDoRequestDTO);

        return ResponseEntity.status(201).body(createdToDo);
    }

    @GetMapping(path = "/get-all-todos")
    public ResponseEntity<List<ToDoResponseDTO>> getAllToDos() {
        List<ToDoResponseDTO> toDos = toDoService.getAllToDos();
        return ResponseEntity.ok(toDos);

    }

    @GetMapping(path = "/get-by-id/{id}")
    public ResponseEntity<ToDoResponseDTO> getToDoByID(@PathVariable(value = "id") Long id){
        ToDoResponseDTO toDoResponse = toDoService.getToDoByID(id);
        return ResponseEntity.ok(toDoResponse);
    }

    @PutMapping(
          path = "/update/{id}"
    )
    public ResponseEntity<ToDoResponseDTO> updateToDo( @PathVariable(value = "id") Long id, @Valid @RequestBody ToDoRequestDTO toDoRequestDTO){
        ToDoResponseDTO updateToDo = toDoService.updateToDo(id,toDoRequestDTO);
        return ResponseEntity.ok(updateToDo);
    }

    @DeleteMapping(path = "/delete-todo/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable(value = "id") Long id){
        toDoService.deleteToDo(id);
        return ResponseEntity.ok("To-Do Deleted Successfull");
    }


}
