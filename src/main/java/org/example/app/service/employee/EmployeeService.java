package org.example.app.service.employee;

import org.example.app.entity.Employee;
import org.example.app.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface EmployeeService extends BaseService<Long, Employee> {
    Employee create(Employee employee);
    Map<Long, Employee> getAll();
    Employee getById(Long id);
    Employee update(Employee employee);
    boolean deleteById(Long id);
}
