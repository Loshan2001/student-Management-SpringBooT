package controller;


import dao.StudentDao;
import dto.StudentDto;
import dto.StudentResponseDto;
import entity.Student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import transformer.StudentTransformer;

import java.util.List;
import static common.ApiPaths.*;

@RestController
@RequestMapping(STUDENT_BASE_API)
public class StudentController {
    StudentDao studentDao;
    StudentTransformer studentTransformer;
    StudentController(StudentDao studentDao, StudentTransformer studentTransformer){
        this.studentDao = studentDao;
        this.studentTransformer = studentTransformer;
    }

    @PostMapping(CREATE_STUDENT) // This should point to "/create"
    public StudentResponseDto createStudent(@RequestBody StudentDto studentDto) {
        var student = studentTransformer.studentDtoToStudent(studentDto);
        var savedStudent =  studentDao.save(student);
        return studentTransformer.studentToStudentDto(savedStudent);
    }

    @GetMapping(GET_ALL_STUDENT)
    public List<Student> getAllStudent(){
        return studentDao.findAll();
    }

    @GetMapping(GET_STUDENT_BY_ID)
    public Student getStudentById(@PathVariable("id") Integer id){
        return studentDao.findById(id).orElse(null);
    }

    @GetMapping(SEARCH_BY_FIRST_NAME)
    public List<Student> getStudentByName(@PathVariable("firstName")String firstName){
        return studentDao.findByfirstName(firstName);
    }

    @DeleteMapping(DELETE_STUDENT)
    @ResponseStatus(HttpStatus.OK)
    public String deleteStudent(@PathVariable("id") Integer id){
         studentDao.deleteById(id);
         return "Student successfully removed";
    }
}
