package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Pipelinehistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "pipelineId_id", referencedColumnName = "id")
	private JobPipeline pipelineId;
	@ManyToOne
	@JoinColumn(name = "actionUserId_id", referencedColumnName = "id")
	private Recruiter actionUserId;
	@ManyToOne
	@JoinColumn(name = "fromStatus_id", referencedColumnName = "id")
	private CandidateJoborderStatus fromStatus;
	@ManyToOne
	@JoinColumn(name = "toStatus_id", referencedColumnName = "id")
	private CandidateJoborderStatus toStatus;

	private LocalDate actionDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobPipeline getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(JobPipeline pipelineId) {
		this.pipelineId = pipelineId;
	}

	public Recruiter getActionUserId() {
		return actionUserId;
	}

	public void setActionUserId(Recruiter actionUserId) {
		this.actionUserId = actionUserId;
	}

	public CandidateJoborderStatus getFromStatus() {
		return fromStatus;
	}

	public void setFromStatus(CandidateJoborderStatus fromStatus) {
		this.fromStatus = fromStatus;
	}

	public CandidateJoborderStatus getToStatus() {
		return toStatus;
	}

	public void setToStatus(CandidateJoborderStatus toStatus) {
		this.toStatus = toStatus;
	}

	public LocalDate getActionDate() {
		return actionDate;
	}

	public void setActionDate(LocalDate actionDate) {
		this.actionDate = actionDate;
	}

	
	
}
