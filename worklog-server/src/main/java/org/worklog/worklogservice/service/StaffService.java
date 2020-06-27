package org.worklog.worklogservice.service;

import org.worklog.worklogservice.bean.StaffDTO;

public interface StaffService {

	StaffDTO getById(Long id);

	StaffDTO register(StaffDTO staffDTO);

}
