package service;

import dao.SchoolDao;
import dto.SchoolDto;
import entity.School;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import transformer.SchoolTransformer;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolTransformer schoolTransformer;
    private final SchoolDao schoolDao;

    public SchoolService(SchoolTransformer schoolTransformer, SchoolDao schoolDao) {
        this.schoolTransformer = schoolTransformer;
        this.schoolDao = schoolDao;
    }


    public SchoolDto createSchool(SchoolDto schoolDto){
        var school = schoolTransformer.schoolDtoToSchool(schoolDto);
        schoolDao.save(school);
        return schoolDto ;
    }

    public School getSchoolById(Integer id){
        return schoolDao.findById(id).orElse(null);
    }

    public List<SchoolDto> getAllSchool(){

        return schoolDao.findAll()
                .stream() //Think of it as turning the list of schools into a series of items that you can work with one by one.
                .map(schoolTransformer::schoolToSchoolDto)//For every school in the list, it converts that School object into a SchoolDto object using the schoolTransformer
                .toList();//After converting each school to a SchoolDto, this line gathers them all together into a new list that you can return
    }
}
