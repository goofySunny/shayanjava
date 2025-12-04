package ir.najaftech.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    
    private Long id;
    private String name;
    private String imageName;
    private List<ProductResponse> products;

}
