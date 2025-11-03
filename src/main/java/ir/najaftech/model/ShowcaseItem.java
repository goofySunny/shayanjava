package ir.najaftech.model;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "showcase_items")
public class ShowcaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "showcase_items_seq")
    @SequenceGenerator(name = "showcase_items_seq", sequenceName = "showcase_items_seq", initialValue = 4, allocationSize = 1)
    private long id;

    @Column(name = "item_description")
    private String desc;

    private String title;

    @Column(name = "image_byte")
    private byte[] image;

    private boolean active;

    @Transient
    private MultipartFile file;

}
