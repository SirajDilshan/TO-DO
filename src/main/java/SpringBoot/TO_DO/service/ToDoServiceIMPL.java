package SpringBoot.TO_DO.service;

import SpringBoot.TO_DO.dto.request.ToDoRequestDTO;
import SpringBoot.TO_DO.dto.response.ToDoResponseDTO;
import SpringBoot.TO_DO.entity.ToDoEntity;
import SpringBoot.TO_DO.exception.ResourceNotFoundException;
import SpringBoot.TO_DO.mapper.ToDoMapper;
import SpringBoot.TO_DO.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ToDoResponseDTO> getAllToDos() {
        List<ToDoEntity> toDoEntities = toDoRepository.findAll();
        return toDoMapper.toResponseDTOList(toDoEntities);
    }

    @Override
    public ToDoResponseDTO getToDoByID(Long id) {
        ToDoEntity toDoEntity = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("To-Do not found with id: " + id) );
        return toDoMapper.toResponseDTO(toDoEntity);
    }

    @Override
    public ToDoResponseDTO updateToDo(Long id, ToDoRequestDTO toDoRequestDTO) {
        ToDoEntity toDoEntity = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("To-Do not found with id: " + id));
        toDoEntity.setTitle(toDoRequestDTO.getTitle());
        toDoEntity.setDescription(toDoRequestDTO.getDescription());
        toDoEntity.setComplete(toDoRequestDTO.isComplete());
        ToDoEntity updatedDTO = toDoRepository.save(toDoEntity);
        return toDoMapper.toResponseDTO(updatedDTO);
    }

    @Override
    public void deleteToDo(Long id) {
        ToDoEntity toDoEntity = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("To-Do not found with id: " + id));
toDoRepository.delete(toDoEntity);

    }
}
