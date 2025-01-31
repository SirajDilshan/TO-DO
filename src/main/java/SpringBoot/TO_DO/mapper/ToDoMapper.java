package SpringBoot.TO_DO.mapper;

import SpringBoot.TO_DO.dto.request.ToDoRequestDTO;
import SpringBoot.TO_DO.dto.response.ToDoResponseDTO;
import SpringBoot.TO_DO.entity.ToDoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ToDoMapper {
    // Convert ToDoRequestDTO to ToDoEntity
    public ToDoEntity toEntity(ToDoRequestDTO toDoRequestDTO) {
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setTitle(toDoRequestDTO.getTitle());
        toDoEntity.setDescription(toDoRequestDTO.getDescription());
        toDoEntity.setComplete(toDoRequestDTO.isComplete());
        return toDoEntity;
    }

    // Convert ToDoEntity to ToDoResponseDTO
    public ToDoResponseDTO toResponseDTO(ToDoEntity toDoEntity){
        ToDoResponseDTO toDoResponseDTO = new ToDoResponseDTO();
        toDoResponseDTO.setId(toDoEntity.getId());
        toDoResponseDTO.setTitle(toDoEntity.getTitle());
        toDoResponseDTO.setDescription(toDoEntity.getDescription());
        toDoResponseDTO.setComplete(toDoEntity.isComplete());
        return toDoResponseDTO;
    }

    // Convert a list of ToDoEntities to a list of ToDoResponseDTOs
    public List<ToDoResponseDTO> toResponseDTOList(List<ToDoEntity> toDoEntities) {
        return toDoEntities.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public void updateEntityFromDTO(ToDoRequestDTO toDoRequestDTO, ToDoEntity toDoEntity) {
        toDoEntity.setTitle(toDoRequestDTO.getTitle());
        toDoEntity.setDescription(toDoRequestDTO.getDescription());
        toDoEntity.setComplete(toDoRequestDTO.isComplete());
    }

}
