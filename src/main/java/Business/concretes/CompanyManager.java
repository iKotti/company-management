package Business.concretes;

import java.util.List;

import Business.abstracts.CompanyService;
import DataAccess.CompanyDao;
import Entity.Company;

public class CompanyManager implements CompanyService {
	
	CompanyDao companyDao = new CompanyDao();

	@Override
	public boolean add(Company company) {
		return companyDao.add(company);
	}

	@Override
	public boolean delete(Company company) {
		return companyDao.delete(company);

	}
	
	@Override
	public boolean update(Company company) {
		return companyDao.update(company);
	}

	@Override
	public List<Company> getAll() {
		return companyDao.getAll();
	}

}
