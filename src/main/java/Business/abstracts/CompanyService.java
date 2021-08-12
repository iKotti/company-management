package Business.abstracts;

import java.util.List;

import Entity.Company;

public interface CompanyService {
	List<Company> getAll();
	boolean add(Company company);
	boolean delete(Company company);
	boolean update(Company company);
}
