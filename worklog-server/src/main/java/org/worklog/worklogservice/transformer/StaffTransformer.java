package org.worklog.worklogservice.transformer;

import java.util.HashSet;

import org.springframework.stereotype.Component;
import org.worklog.worklogservice.bean.StaffDTO;
import org.worklog.worklogservice.domain.Staff;
import org.worklog.worklogservice.domain.Work;

@Component
public class StaffTransformer extends Transformer<Staff, StaffDTO> {

	@Override
	public Staff toEntity(StaffDTO d) {
		Staff staff = null;
		if(d != null) {
			staff = new Staff();
			staff.setUsername(d.getUsername());
			staff.setPassword(d.getPassword());
			staff.setEmail(d.getEmail());
			staff.setActive(true);
			staff.setRole(d.getRole());
			staff.setPhoneNumber(d.getPhoneNumber());
			staff.setWorks(new HashSet<Work>());
		}
		return staff;
	}

	@Override
	public StaffDTO toDTO(Staff e) {
		StaffDTO staffDTO = null;
		if(e != null) {
			staffDTO = new StaffDTO();
			staffDTO.setUsername(e.getUsername());
			staffDTO.setPassword(e.getPassword());
			staffDTO.setEmail(e.getEmail());
			staffDTO.setActive(e.isActive());
			staffDTO.setPhoneNumber(e.getPhoneNumber());
		}
		return staffDTO;
	}

}
