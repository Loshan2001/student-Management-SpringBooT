package transformer;

import dto.StudentDto;
import entity.School;
import entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTransformerTest {


    private StudentTransformer studentsTransfomer;

    @BeforeEach
    void setUp() {
        studentsTransfomer = new StudentTransformer();
    }

    @Test
    public void shoudMapStudentDtoToStudent(){
        StudentDto studentDto = new StudentDto("loshan","saravanaperumal","loshansp@gmail.com",23,1);
        Student student = studentsTransfomer.studentDtoToStudent(studentDto);
        assertEquals(studentDto.first_Name(),student.getFirstName());
        assertEquals(studentDto.last_Name(),student.getLastName());
        assertEquals(studentDto.age(),student.getAge());
        assertEquals(studentDto.email(),student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(studentDto.schoolId(),student.getSchool().getId());


    }

//    @Test
//    public void shouldMapStudentToStudentResponseDto(){
//
//        Student  student = new Student();
//
//
//    }

}