package org.worklog.worklogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.worklog.worklogservice.bean.StaffDTO;
import org.worklog.worklogservice.domain.Staff;
import org.worklog.worklogservice.repository.StaffRepository;
import org.worklog.worklogservice.transformer.Transformer;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository repo;

	@Autowired
	private Transformer<Staff, StaffDTO> transformer;

	@Override
	public StaffDTO getById(Long id) {
		Staff staff = repo.getOne(id);
		return transformer.toDTO(staff);
	}

	@Override
	public StaffDTO register(StaffDTO staffDto) {
		// to Entity
		Staff staff = transformer.toEntity(staffDto);
		// save to DB
		Staff result = repo.saveAndFlush(staff);
		StaffDTO dto = null;
		if (result != null) {
			dto = transformer.toDTO(result);
		}
		return dto;
	}
}
