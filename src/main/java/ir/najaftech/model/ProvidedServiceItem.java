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
@Table(name = "provided_service_items")
public class ProvidedServiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provided_service_items_seq")
    @SequenceGenerator(name = "provided_service_items_seq", sequenceName = "provided_service_items_seq", initialValue = 12, allocationSize = 1)
    private Long id;

    private String title;

    @Column(name = "image_byte")
    private byte[] image;

    private boolean active;

    @Transient
    private MultipartFile file;
}
