package app.infy.employee.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.infy.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {
    Optional<Employee> findByEmail(String email);
}
