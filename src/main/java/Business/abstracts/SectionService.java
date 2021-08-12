package Business.abstracts;

import java.util.List;

import Entity.Section;

public interface SectionService {
	List<Section> getAll(int companyId);
	boolean add(Section section);
	boolean delete(Section section);
	boolean update(Section section);
	
}
