package ir.najaftech.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponse {
    
    private Long id;
    private String title;
    private String description;
    private boolean active;
    private String imageName;

}
