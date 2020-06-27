package org.worklog.worklogservice.transformer;

import java.util.HashSet;

import org.springframework.stereotype.Component;
import org.worklog.worklogservice.bean.StaffDto;
import org.worklog.worklogservice.domain.Staff;
import org.worklog.worklogservice.domain.Work;

@Component
public class StaffTransformer extends Transformer<Staff, StaffDto> {

	@Override
	public Staff toEntity(StaffDto d) {
		Staff staff = new Staff();
		staff.setUsername(d.getUsername());
		staff.setPassword(d.getPassword());
		staff.setEmail(d.getEmail());
		staff.setActive(true);
		staff.setRole(d.getRole());
		staff.setPhoneNumber(d.getPhoneNumber());
		staff.setWorks(new HashSet<Work>());
		return staff;
	}

	@Override
	public StaffDto toDTO(Staff e) {
		StaffDto staffDTO = new StaffDto();
		staffDTO.setUsername(e.getUsername());
		staffDTO.setPassword(e.getPassword());
		staffDTO.setEmail(e.getEmail());
		staffDTO.setActive(e.isActive());
		staffDTO.setPhoneNumber(e.getPhoneNumber());
		return staffDTO;
	}

}
