package ir.najaftech.model;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "showcase_item")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShowcaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "description")
    private String desc;

    private String title;

    @Lob
    private byte[] image;

    private boolean active;

    @Transient
    private MultipartFile file;

}
