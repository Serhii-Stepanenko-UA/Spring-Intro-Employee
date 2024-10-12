package org.example.app.controller;

import org.example.app.entity.Employee;
import org.example.app.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Controller("EmployeeController")
public class EmployeeController {

//    // Field injection
//    @Autowired
//    @Qualifier("employeeService")
//    private EmployeeService employeeService;

//    // Setter injection
//    private EmployeeService employeeService;
//
//    @Autowired
//    public void setUserService(@Qualifier("employeeService") EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }

    // Constructor injection
    private final EmployeeService employeeService;

    public EmployeeController(@Qualifier("employeeService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String create(final Employee employee) {
        return employeeService.create(employee).toString();
    }

    public String getAll() {
        Map<Long, Employee> map = employeeService.getAll();
        if (!map.isEmpty()) {
            AtomicInteger count = new AtomicInteger(0);
            StringBuilder sb = new StringBuilder();
            map.forEach((id, employee) ->
                    sb.append("%d) id=%d %s%n"
                            .formatted(
                                    count.incrementAndGet(),
                                    id, employee.toString()))
            );
            return sb.toString();
        } else return "No data!";
    }

    public String getById(final Long id) {
        Employee employee = employeeService.getById(id);
        return (employee != null)
                ? employee.toString()
                : "Employee with id %d has been not found!".formatted(id);
    }

    public String update(final Employee employee) {
        Employee _employee = employeeService.update(employee);
        return (_employee != null) ? _employee.toString() : "No data!";
    }

    public String deleteById(final Long id) {
        return (employeeService.deleteById(id))
                ? "Employee with id %d has been deleted.".formatted(id)
                : "Employee with id %d has been not found!".formatted(id);
    }
}
