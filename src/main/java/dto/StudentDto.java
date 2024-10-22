package dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotBlank
        @NotEmpty(message = "FirstName should not be empty")
        String first_Name,
        @NotBlank
        @NotEmpty(message = "LastName should not be empty")
        String last_Name,
        String email,
        String age,
        Integer schoolId
) {
}
