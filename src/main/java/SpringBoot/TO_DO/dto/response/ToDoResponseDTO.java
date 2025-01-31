package SpringBoot.TO_DO.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoResponseDTO {
    private Long id;
    private String title;
    private String description;
    private boolean complete;
}
