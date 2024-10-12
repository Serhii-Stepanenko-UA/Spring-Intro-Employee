package org.example.app.repository.employee;

import org.example.app.entity.Employee;
import org.example.app.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
@Qualifier("employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final static Map<Long, Employee> EMPLOYEE_MAP = new HashMap<>();

    @Override
    public Employee create(final Employee employee) {
        Objects.requireNonNull(employee, "Parameter [employee] must not be null!");
        if (employee.hasId()) {
            throw new IllegalArgumentException("A new employee must not have an id assigned!");
        }
        var id = CommonUtils.generateId();
        employee.setId(id);
        EMPLOYEE_MAP.put(id, employee);
        return employee;
    }

    @Override
    public Optional<Map<Long, Employee>> getAll() {
        return Optional.of(EMPLOYEE_MAP);
    }

    @Override
    public Optional<Employee> getById(final Long id) {
        CommonUtils.validateId(id);
        return Optional.ofNullable(EMPLOYEE_MAP.get(id));
    }

    @Override
    public Employee update(final Employee employee) {
        Objects.requireNonNull(employee, "Parameter [employee] must not be null!");
        if (!employee.hasId()) {
            throw new IllegalArgumentException("For update operation it is mandatory for a employee to have an id!");
        }
        Employee _employee = EMPLOYEE_MAP.get(employee.getId());
        _employee.setFirstName(employee.getFirstName());
        _employee.setLastName(employee.getLastName());
        _employee.setPosition(employee.getPosition());
        _employee.setPhone(employee.getPhone());
        EMPLOYEE_MAP.put(_employee.getId(), _employee);
        return _employee;
    }

    @Override
    public boolean deleteById(final Long id) {
        CommonUtils.validateId(id);
        if (EMPLOYEE_MAP.containsKey(id)) {
            EMPLOYEE_MAP.remove(id);
            return true;
        }
        return false;
    }
}
