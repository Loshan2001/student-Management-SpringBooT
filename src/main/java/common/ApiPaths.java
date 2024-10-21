package common;

public interface ApiPaths {
    String STUDENT_BASE_API = "/api/student";
    String CREATE_STUDENT= "/create";
    String GET_ALL_STUDENT = "/getAll";
    String GET_STUDENT_BY_ID="/{id}";
    String SEARCH_BY_FIRST_NAME="/name/{firstName}";
    String DELETE_STUDENT = "/delete/{id}";

    String SCHOOL_BASE_API = "/api/school";
    String CREATE_SCHOOL = "/create";
    String GET_ALL_SCHOOL = "/getAll";
    String GET_SCHOOL_BY_ID = "/{id}";
}

