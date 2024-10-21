package transformer;

import dto.StudentDto;
import dto.StudentResponseDto;
import entity.School;
import entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentTransformer {
    public Student studentDtoToStudent(StudentDto studentDto){
        var student = new Student();
        student.setFirstName(studentDto.first_Name());
        student.setLastName(studentDto.last_Name());
        student.setAge(Integer.valueOf(studentDto.age()));
        student.setEmail(studentDto.email());

        var school = new School();
        school.setId(studentDto.schoolId());
        student.setSchool(school);

        return student;
    }

    public StudentResponseDto studentToStudentDto(Student student){
      return new StudentResponseDto(
              student.getFirstName(),
              student.getLastName(),
              student.getAge(),
              student.getEmail()
      );

    }
}
