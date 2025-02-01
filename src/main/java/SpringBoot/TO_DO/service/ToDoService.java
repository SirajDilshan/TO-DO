package SpringBoot.TO_DO.service;

import SpringBoot.TO_DO.dto.request.ToDoRequestDTO;
import SpringBoot.TO_DO.dto.response.ToDoResponseDTO;

import java.util.List;

public interface ToDoService {
    ToDoResponseDTO createToDo(ToDoRequestDTO toDoRequestDTO);

    List<ToDoResponseDTO> getAllToDos();

    ToDoResponseDTO getToDoByID(Long id);

    ToDoResponseDTO updateToDo(Long id, ToDoRequestDTO toDoRequestDTO);

    void deleteToDo(Long id);
}
