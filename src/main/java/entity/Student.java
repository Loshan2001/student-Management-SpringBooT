package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.lang.reflect.Type;


@Entity
@Data
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Integer id;
        private String firstName;
        private String lastName;
        private String email;
        private Integer age;

        @OneToOne(
                mappedBy = "student", //reference name
                cascade = CascadeType.ALL //  when we remove the student it will also remove student profile
        )
        private StudentProfile studentProfile;

        @ManyToOne
        @JoinColumn(name = "school_id")
        @JsonBackReference
        private School school;
}
