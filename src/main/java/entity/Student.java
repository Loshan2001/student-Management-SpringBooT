package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public record Student(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        Integer id,
        String firstName,
        String lastName,
        String email,
        String age

) {
}
