package ir.najaftech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_seq")
    @SequenceGenerator(name = "categories_seq", sequenceName = "categories_seq", allocationSize = 1)
    private Long id;

    @Column(name = "cat_name")
    private String name;

    @Column(name = "image_name")
    private String imageName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

}