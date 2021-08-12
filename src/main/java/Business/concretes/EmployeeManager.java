package Business.concretes;

import java.util.List;

import Business.abstracts.EmployeesService;
import DataAccess.EmployeeDao;
import Entity.Employee;

public class EmployeeManager implements EmployeesService{
	
	EmployeeDao employeeDao = new EmployeeDao();

	@Override
	public List<Employee> getAll(int sectionId) {
		return employeeDao.getAll(sectionId);
	}

	@Override
	public Boolean add(Employee employee) {
		return employeeDao.add(employee);
	}
	
	@Override
	public Boolean update(Employee employee) {
		return employeeDao.update(employee);
	}

	@Override
	public Boolean delete(Employee employee) {
		return employeeDao.delete(employee);
	}
}
