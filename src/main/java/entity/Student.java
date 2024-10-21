package entity;

import jakarta.persistence.*;

import java.lang.reflect.Type;


@Entity
public record Student(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        Integer id,
        String firstName,
        String lastName,
        String email,
        String age,

        @OneToOne(
                mappedBy = "student", //reference name
                cascade = CascadeType.ALL //  when we remove the student it will also remove student profile
        )
        StudentProfile studentProfile,

        @ManyToOne
        @JoinColumn(name = "school_id")
        School school

) {
}
