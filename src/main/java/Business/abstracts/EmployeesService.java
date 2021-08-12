package Business.abstracts;

import java.util.List;

import Entity.Employee;

public interface EmployeesService {
	List<Employee> getAll(int sectionId);
	Boolean add(Employee employee);
	Boolean delete(Employee employee);
	Boolean update(Employee employee);
}
