package org.worklog.worklogservice.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkDTO {
	
	private Long workId;
	
	private String workTitle; // WORK-WORKID -> WORK-12

	private double timeSpent; // logged work

	private double timeLeft; // ETC

	private Double loggedTime; // how much logged

	private Date logAction; // when the log happens

	private String description;
	
//	private int weekNumber;
	
	private int status;

}
