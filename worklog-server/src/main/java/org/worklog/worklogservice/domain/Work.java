package org.worklog.worklogservice.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "WORK")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Work {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WORK_ID")
	private Long workId;

	@Column
	private String workTitle; // WORK-WORKID -> WORK-12

	@Column
	private double timeSpent; // logged work

	@Column
	private double timeLeft; // ETC

	@Column
	private Double loggedTime; // how much logged

	@Column
	private Date logAction; // when the log happens

	@Column
	private String description;
	
	@Column
	private int weekNumber;
	
	@Column
	private int status;

	@ManyToOne
	@JoinColumn(name = "STAFF_ID", nullable = false)
	private Staff staff;
}
