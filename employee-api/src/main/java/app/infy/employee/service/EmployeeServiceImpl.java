package app.infy.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.infy.employee.entity.Employee;
import app.infy.employee.exception.BadRequestException;
import app.infy.employee.exception.ResourceNotFoundException;
import app.infy.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee findOne(String id) {
    	   return repository.findById(id)
    			   				.orElseThrow(
                                 () -> new ResourceNotFoundException("Employee with id " + id + " doesn't exist."));
    }

    @Transactional
    public Employee create(Employee emp) {
        Optional<Employee> existing = repository.findByEmail(emp.getEmail());
        if (existing.isPresent()) {
            throw new BadRequestException("Employee with email " + emp.getEmail() + " already exists.");
        }
        return repository.save(emp);
    }

    @Transactional
    public Employee update(String id, Employee emp) {
        Optional<Employee> existing = repository.findById(id);
        if (!existing.isPresent()) {
            throw new ResourceNotFoundException("Employee with id " + id + " doesn't exist.");
        }
        return repository.save(emp);
    }

    @Transactional
    public void delete(String id) {
        Optional<Employee> existing = repository.findById(id);
        if (!existing.isPresent()) {
            throw new ResourceNotFoundException("Employee with id " + id + " doesn't exist.");
        }
        repository.delete(existing.get());
    }

	
}
