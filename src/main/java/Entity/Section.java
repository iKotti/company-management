package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sections")
public class Section {
	@Id
	@GeneratedValue
	@Column(name="section_id")
	private int sectionId;
	
	@Column(name="section_code")
	private String sectionCode;
	
	@Column(name="section_name")
	private String sectionName;
	
	@Column(name="company_id")
	private int companyId;
	
	

	public Section() {
	}

	public Section(int sectionId, String sectionCode, String sectionName, int companyId) {
		super();
		this.sectionId = sectionId;
		this.sectionCode = sectionCode;
		this.sectionName = sectionName;
		this.companyId = companyId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	
	
	
}
