package SpringBoot.TO_DO.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoRequestDTO {

    private String title;
    private String description;
    private boolean complete;
}
