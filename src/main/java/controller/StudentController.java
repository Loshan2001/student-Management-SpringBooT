package controller;



import dto.StudentDto;
import dto.StudentResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.List;
import static common.ApiPaths.*;

@RestController
@RequestMapping(STUDENT_BASE_API)
public class StudentController {

   private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping(CREATE_STUDENT) // This should point to "/create"
    public StudentResponseDto createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @GetMapping(GET_ALL_STUDENT)
    public List<StudentResponseDto> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping(GET_STUDENT_BY_ID)
    public StudentResponseDto getStudentById(@PathVariable("id") Integer id){
        return studentService.getStudentById(id);
    }

    @GetMapping(SEARCH_BY_FIRST_NAME)
    public List<StudentResponseDto> getStudentByName(@PathVariable("firstName")String firstName){
        return studentService.getStudentByName(firstName);
    }

    @DeleteMapping(DELETE_STUDENT)
    @ResponseStatus(HttpStatus.OK)
    public String deleteStudent(@PathVariable("id") Integer id){
         return studentService.deleteStudent(id);
    }
}
