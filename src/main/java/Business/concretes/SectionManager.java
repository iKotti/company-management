package Business.concretes;

import java.util.List;

import Business.abstracts.SectionService;
import DataAccess.SectionDao;
import Entity.Section;

public class SectionManager implements SectionService {
	
	SectionDao sectionDao = new SectionDao();

	@Override
	public boolean add(Section section) {
		return sectionDao.add(section);
	}
	
	@Override
	public boolean delete(Section section) {
		return sectionDao.delete(section);
	}
	
	@Override
	public boolean update(Section section) {
		return sectionDao.update(section);
	}

	@Override
	public List<Section> getAll(int companyId){
		return sectionDao.getAll(companyId);
	}

}
