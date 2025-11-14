package ir.najaftech.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowcaseResponse {
    
    private long id;

    private String title;

    private String desc;

    private String imageName;

    private boolean active;

}
