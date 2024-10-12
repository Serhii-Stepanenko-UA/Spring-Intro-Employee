package org.example.app.repository.employee;

import org.example.app.entity.Employee;
import org.example.app.repository.BaseRepository;

import java.util.Map;
import java.util.Optional;

public interface EmployeeRepository extends BaseRepository<Long, Employee> {
    Employee create(Employee employee);
    Optional<Map<Long, Employee>> getAll();
    Optional<Employee> getById(Long id);
    Employee update(Employee employee);
    boolean deleteById(Long id);
}
