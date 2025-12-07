package ir.najaftech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "projects")
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    
    @Id
    @GeneratedValue(generator="projects_seq" ,strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="projects_seq", sequenceName="projects_seq", allocationSize=2,initialValue=99)
    private Long id;

    private String title;

    @Column(name= "project_description")
    private String description;

    @Column(name= "image_name")
    private String imageName;

}
