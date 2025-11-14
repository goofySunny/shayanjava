package ir.najaftech.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceItemResponse {
    
    private long id;

    private String title;

    private boolean active;

    private String imageName;

}
