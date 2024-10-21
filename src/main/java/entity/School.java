package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class School{
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Integer id;
        private String  schoolName;

        @OneToMany(
                mappedBy = "school"
        )

        @JsonBackReference
        List<Student> students;
}
