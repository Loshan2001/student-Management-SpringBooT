package controller;


import common.ApiPaths;
import dao.SchoolDao;
import entity.School;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static common.ApiPaths.*;

@RestController
@RequestMapping(SCHOOL_BASE_API)
public class SchoolController {

    SchoolDao schoolDao;
    SchoolController(SchoolDao schoolDao){
        this.schoolDao = schoolDao;
    }
    @PostMapping(CREATE_SCHOOL)
    public School createSchool(@RequestBody School school){
        return schoolDao.save(school);
    }

    @GetMapping(GET_SCHOOL_BY_ID)
    public School getSchoolById(@RequestBody Integer id){
        return schoolDao.findById(id).orElse(null);
    }

    @GetMapping(GET_ALL_SCHOOL)
    public List<School> getAllSchool(){
        return schoolDao.findAll();
    }

}
