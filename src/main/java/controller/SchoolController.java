package controller;


import common.ApiPaths;
import dao.SchoolDao;
import dto.SchoolDto;
import dto.SchoolResponseDto;
import entity.School;
import org.springframework.web.bind.annotation.*;
import transformer.SchoolTransformer;

import java.util.List;

import static common.ApiPaths.*;

@RestController
@RequestMapping(SCHOOL_BASE_API)
public class SchoolController {

    SchoolDao schoolDao;
    SchoolTransformer schoolTransformer;
    SchoolController(SchoolDao schoolDao, SchoolTransformer schoolTransformer){
        this.schoolDao = schoolDao;
        this.schoolTransformer = schoolTransformer;
    }
    @PostMapping(CREATE_SCHOOL)
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto){
        var school = schoolTransformer.schoolDtoToSchool(schoolDto);
        schoolDao.save(school);
        return schoolDto ;
    }

    @GetMapping(GET_SCHOOL_BY_ID)
    public School getSchoolById(@RequestBody Integer id){
        return schoolDao.findById(id).orElse(null);
    }

    @GetMapping(GET_ALL_SCHOOL)
    public List<SchoolDto> getAllSchool(){

        return schoolDao.findAll()
                .stream() //Think of it as turning the list of schools into a series of items that you can work with one by one.
                .map(schoolTransformer::schoolToSchoolDto)//For every school in the list, it converts that School object into a SchoolDto object using the schoolTransformer
                .toList();//After converting each school to a SchoolDto, this line gathers them all together into a new list that you can return
    }

}
