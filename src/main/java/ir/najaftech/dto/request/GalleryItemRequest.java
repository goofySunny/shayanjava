package ir.najaftech.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GalleryItemRequest {

    private String title;

    private String desc;

    private boolean active;

}