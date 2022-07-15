package pro.sky.homework.HomeworkCollections;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class EmployeeAlreadyAdded extends RuntimeException{
    public EmployeeAlreadyAdded(){
        super();
    }
}
