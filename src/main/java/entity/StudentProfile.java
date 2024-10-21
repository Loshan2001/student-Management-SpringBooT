package entity;

import jakarta.persistence.*;

@Entity
public record StudentProfile(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        Integer id,
        String bio,

        @OneToOne
        @JoinColumn(name = "student_id")
        Student student

) {
}
