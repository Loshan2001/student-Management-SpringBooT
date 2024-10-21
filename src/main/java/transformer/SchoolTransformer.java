package transformer;

import dto.SchoolDto;
import entity.School;

public class SchoolTransformer {
    public School schoolDtoToSchool(SchoolDto schoolDto){
        var school = new School();
        school.setSchoolName(schoolDto.schoolName());
        return school;
    }

    public SchoolDto schoolToSchoolDto(School school){
        return new SchoolDto(
                school.getSchoolName()
        );
    }

}
