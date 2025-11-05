package ir.najaftech.model;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "gallery_items")
public class GalleryItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gallery_items_seq")
    @SequenceGenerator(name = "gallery_items_seq", sequenceName = "gallery_items_seq", initialValue = 109, allocationSize = 1)
    private Long id;

    private String title;

    @Column(name = "item_description")
    private String desc;

    @Column(name = "image_name")
    private String imageName;

    private boolean active;

}
