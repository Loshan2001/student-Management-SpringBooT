package service;

import dao.StudentDao;
import dto.StudentDto;
import dto.StudentResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import transformer.StudentTransformer;

import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {
    private final StudentDao studentDao;
    private final StudentTransformer studentTransformer;


    public StudentService(StudentDao studentDao, StudentTransformer studentTransformer) {
        this.studentDao = studentDao;
        this.studentTransformer = studentTransformer;
    }

    public StudentResponseDto createStudent(StudentDto studentDto){
        var student = studentTransformer.studentDtoToStudent(studentDto);
        var savedStudent =  studentDao.save(student);
        return studentTransformer.studentToStudentDto(savedStudent);

    }

    public List<StudentResponseDto> getAllStudent(){
        return studentDao.findAll()
                .stream()
                .map(studentTransformer::studentToStudentDto)
                .toList();
    }

    public StudentResponseDto getStudentById(Integer id){
        return studentDao.findById(id)
                .map(studentTransformer::studentToStudentDto)
                .orElse(null);
    }

    public List<StudentResponseDto> getStudentByName(String firstName){
        return studentDao.findByfirstName(firstName)
                .stream()
                .map(studentTransformer::studentToStudentDto)
                .toList();
    }

    public String deleteStudent(Integer id){
        studentDao.deleteById(id);
        return "Student successfully removed";
    }
}
