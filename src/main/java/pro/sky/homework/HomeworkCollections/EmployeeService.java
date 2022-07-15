package pro.sky.homework.HomeworkCollections;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    static List<Employee> staff = new ArrayList<>();

public static String addEmployee(String name, String surname) {
    if (staffNumber(name, surname) == -1) {
        Employee employee = new Employee(name, surname);
        staff.add(employee);
        return ("New employee " + name + " " + surname + " was added.");
    } else {
        throw new EmployeeAlreadyAdded();
    }
}
public static String removeEmployee(String name, String surname) {
    if (staffNumber(name, surname) == -1) {
        throw new EmployeeNotFound();
    }else{
        staff.remove(staffNumber(name, surname));
        return ("Employee " + name + " " + surname + " was removed.");
    }
}
public static String findEmployee(String name, String surname){
    if (staffNumber(name, surname) == -1) {
        throw new EmployeeNotFound();
    }
    return ("Employee " + name + " " + surname + " has staff number " + staffNumber(name, surname));
}
private static int staffNumber(String name, String surname) {
    for (Employee employee : staff) {
        if (employee.getName().equals(name) && employee.getSurname().equals(surname)){
            return staff.indexOf(employee);
        }
    }
    return (-1);
}

}
