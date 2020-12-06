package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="CandidateJoborderStatus.findAll",query="SELECT cjs FROM CandidateJoborderStatus cjs")
public class CandidateJoborderStatus implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String short_description;
	@OneToMany(mappedBy = "candidatejoborderstatus")
	private List<JobPipeline> jobpipeline;
	
	@OneToMany(mappedBy = "fromStatus")
	private List<Pipelinehistory> fromstatus;
	
	@OneToMany(mappedBy = "toStatus")
	private List<Pipelinehistory> tostatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	
	
}
