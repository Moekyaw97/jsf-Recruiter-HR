package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

@Entity
public class Joborder implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String job_position;
	/* @ColumnTransformer(name="job_description", columnDefinition="TEXT") */
	
	@Column(columnDefinition = "TEXT")
	private String job_description;
	private int basic_salary;
	private int total_employee;
	
	@ManyToOne
	@JoinColumn(name = "companyId", referencedColumnName = "id")
	private Company companyId;
	
	@ManyToOne
	@JoinColumn(name = "job_location", referencedColumnName = "id")
	private Township job_location;
	
	@ManyToOne
	@JoinColumn(name = "entryBy", referencedColumnName = "id")
	private Recruiter entryBy;
	private LocalDate entry_date;

	@ManyToOne
	@JoinColumn(name = "modifyBy", referencedColumnName = "id")
	private Recruiter modifyBy;
	private LocalDate modifyDate;
	
	private String is_active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJob_position() {
		return job_position;
	}

	public void setJob_position(String job_position) {
		this.job_position = job_position;
	}

	public String getJob_description() {
		return job_description;
	}

	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}

	public int getBasic_salary() {
		return basic_salary;
	}

	public void setBasic_salary(int basic_salary) {
		this.basic_salary = basic_salary;
	}

	public int getTotal_employee() {
		return total_employee;
	}

	public void setTotal_employee(int total_employee) {
		this.total_employee = total_employee;
	}

	public Company getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Company companyId) {
		this.companyId = companyId;
	}

	public Township getJob_location() {
		return job_location;
	}

	public void setJob_location(Township job_location) {
		this.job_location = job_location;
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

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	
	
	

}
