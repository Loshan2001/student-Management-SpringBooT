package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public record School(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        Integer id,
        String  schoolName,

        @OneToMany(
                mappedBy = "school"
        )
        List<Student> students
) {
}
