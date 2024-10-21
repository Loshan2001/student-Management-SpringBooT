package controller;
import dao.StudentDao;
import entity.Student;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static common.ApiPaths.*;

@RestController
@RequestMapping(STUDENT_BASE_API)
public class StudentController {
    StudentDao studentDao;

    StudentController(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    @PostMapping(CREATE_STUDENT) // This should point to "/create"
    public Student createStudent(@RequestBody Student student) {
        return studentDao.save(student);
    }

    @GetMapping(GET_ALL_STUDENT)
    public List<Student> getAllStudent(){
        return studentDao.findAll();
    }

    @GetMapping(GET_STUDENT_BY_ID)
    public Optional<Student> getStudentById(@PathVariable("id") Integer id){
        return studentDao.findById(id);
    }
}
