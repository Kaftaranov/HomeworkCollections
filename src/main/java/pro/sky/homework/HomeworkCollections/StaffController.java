package pro.sky.homework.HomeworkCollections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(path = "/employee")

public class StaffController {
    private final EmployeeService employeeService;

    public StaffController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping (path="/add")
    public String add (@RequestParam("name") String name, @RequestParam("surname") String surname){
        if (checkParameters(name, surname)){
            return EmployeeService.addEmployee(name, surname);
        }
        else {
            return ("Both name and surname required!");
        }
    }
    @GetMapping (path="/remove")
     public String remove (@RequestParam("name") String name, @RequestParam("surname") String surname) {
        if (checkParameters(name, surname)){
            return EmployeeService.removeEmployee(name, surname);
        }
        else {
            return ("Both name and surname required!");
        }
     }
    @GetMapping (path="/find")
    public String find (@RequestParam("name") String name, @RequestParam("surname") String surname) {
        if (checkParameters(name, surname)) {
            return EmployeeService.findEmployee(name, surname);}
        else{
            return ("Both name and surname required!");
        }
    }
    public boolean checkParameters(String a, String b){
        return (!a.isEmpty()&&!b.isEmpty());
    }
}
