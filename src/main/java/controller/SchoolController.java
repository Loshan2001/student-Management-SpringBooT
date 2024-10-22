package controller;


import common.ApiPaths;
import dao.SchoolDao;
import dto.SchoolDto;
import dto.SchoolResponseDto;
import entity.School;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import service.SchoolService;
import transformer.SchoolTransformer;

import java.util.List;

import static common.ApiPaths.*;

@RestController
@RequestMapping(SCHOOL_BASE_API)
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @PostMapping(CREATE_SCHOOL)
    public SchoolDto createSchool(@Valid  @RequestBody SchoolDto schoolDto){ // @Valid - used to ensure this action must be validated
        return schoolService.createSchool(schoolDto);
    }

    @GetMapping(GET_SCHOOL_BY_ID)
    public School getSchoolById(@RequestBody Integer id){
        return schoolService.getSchoolById(id);
    }

    @GetMapping(GET_ALL_SCHOOL)
    public List<SchoolDto> getAllSchool(){
        return schoolService.getAllSchool();
    }

}
