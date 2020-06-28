package org.worklog.worklogservice.service;

import java.util.List;

import org.worklog.worklogservice.bean.StaffDTO;
import org.worklog.worklogservice.bean.WorkDTO;

public interface StaffService {

	StaffDTO getById(Long id);

	StaffDTO getByUsername(String username);
	
	StaffDTO register(StaffDTO staffDTO);
	
	WorkDTO addWork(Long staffId, WorkDTO workDTO);

	List<WorkDTO> getAllWorks(Long staffID);
	
	Integer removeWork(Long staffID, Long workID);
}
