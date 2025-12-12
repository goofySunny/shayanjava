package ir.najaftech.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest {
    
    private String title;
    private String description;
    private String imageName;
    private boolean active;

}
