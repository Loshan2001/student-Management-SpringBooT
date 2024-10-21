package dto;



public record StudentDto(
        String first_Name,
        String last_Name,
        String email,
        String age,
        Integer schoolId
) {
}
