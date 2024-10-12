package org.example.app.service.employee;

import org.example.app.entity.Employee;
import org.example.app.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

//    // Field injection
//    @Autowired
//    @Qualifier("employeeRepository")
//    private EmployeeRepository employeeRepository;

//    // Setter injection
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    public void setUserRepository(@Qualifier("employeeRepository") EmployeeRepository employeeRepository) {
//        this employeeRepository = employeeRepository;
//    }

    // Constructor injection
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(@Qualifier("employeeRepository") EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(final Employee employee) {
        return employeeRepository.create(employee);
    }

    @Override
    public Map<Long, Employee> getAll() {
        Optional<Map<Long, Employee>> optional =
                employeeRepository.getAll();
        return optional.orElse(Collections.emptyMap());
    }

    @Override
    public Employee getById(final Long id) {
        Optional<Employee> optional =
                employeeRepository.getById(id);
        return optional.orElse(null);
    }

    @Override
    public Employee update(final Employee employee) {
        if (employeeRepository.getById(employee.getId()).isEmpty()) {
            return null;
        } else {
            return employeeRepository.update(employee);
        }
    }

    @Override
    public boolean deleteById(final Long id) {
        if (employeeRepository.getById(id).isEmpty()) {
            return false;
        } else {
            employeeRepository.deleteById(id);
            return true;
        }
    }

}
