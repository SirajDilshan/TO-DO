package SpringBoot.TO_DO.service;

import SpringBoot.TO_DO.dto.request.ToDoRequestDTO;
import SpringBoot.TO_DO.dto.response.ToDoResponseDTO;
import SpringBoot.TO_DO.entity.ToDoEntity;
import SpringBoot.TO_DO.mapper.ToDoMapper;
import SpringBoot.TO_DO.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoServiceIMPL implements ToDoService {
    @Autowired
    private ToDoMapper toDoMapper;
    @Autowired
    private ToDoRepository toDoRepository;

    public ToDoResponseDTO createToDo(ToDoRequestDTO toDoRequestDTO){
        ToDoEntity toDoEntity = toDoMapper.toEntity(toDoRequestDTO);
        ToDoEntity savedEntity= toDoRepository.save(toDoEntity);
        return toDoMapper.toResponseDTO(savedEntity);
    }
}
