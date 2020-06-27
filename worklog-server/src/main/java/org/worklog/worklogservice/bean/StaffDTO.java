package org.worklog.worklogservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO {

	private String username;
	
	private String password;
	
	private String email;
	
	private boolean active;
	
	private String role;
	
	private String phoneNumber;
}
