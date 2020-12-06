package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c")
@NamedQuery(name = "Candidate.getUnworkedCandidates", query = "SELECT c FROM Candidate c WHERE c.id NOT IN ( select candidate.id from JobPipeline p where p.joborder.id = :joborderid)")
public class Candidate implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;

	@ManyToOne
	@JoinColumn(name = "township", referencedColumnName = "id")
	private Township township;
	private int expectedSalary;
	private String key_skills;
	private String email;

	@ManyToOne
	@JoinColumn(name = "entryBy", referencedColumnName = "id")
	private Recruiter entryBy;
	private LocalDate entry_date;
	private String cv_form;
	private String is_active;

	@ManyToOne
	@JoinColumn(name = "ava", referencedColumnName = "id")
	private Ava ava;

	@ManyToOne
	@JoinColumn(name = "modifyBy", referencedColumnName = "id")
	private Recruiter modifyBy;
	private LocalDate modifyDate;

	@OneToMany(mappedBy = "candidate")
	private List<JobPipeline> jobpipeline;
	
	public Candidate() {
		super();
	}

	public int getId() {
		return id;
	}

	public List<JobPipeline> getJobpipeline() {
		return jobpipeline;
	}

	public void setJobpipeline(List<JobPipeline> jobpipeline) {
		this.jobpipeline = jobpipeline;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}
	

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Township getTownship() {
		return township;
	}

	public void setTownship(Township township) {
		this.township = township;
	}

	public int getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(int expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public String getKey_skills() {
		return key_skills;
	}

	public void setKey_skills(String key_skills) {
		this.key_skills = key_skills;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Recruiter getEntryBy() {
		return entryBy;
	}

	public void setEntryBy(Recruiter entryBy) {
		this.entryBy = entryBy;
	}

	public LocalDate getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(LocalDate entry_date) {
		this.entry_date = entry_date;
	}

	public String getCv_form() {
		return cv_form;
	}

	public void setCv_form(String cv_form) {
		this.cv_form = cv_form;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public Ava getAva() {
		return ava;
	}

	public void setAva(Ava ava) {
		this.ava = ava;
	}

	public Recruiter getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Recruiter modifyBy) {
		this.modifyBy = modifyBy;
	}

	public LocalDate getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDate modifyDate) {
		this.modifyDate = modifyDate;
	}

}
