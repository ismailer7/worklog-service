package org.worklog.worklogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.worklog.worklogservice.bean.StaffDTO;
import org.worklog.worklogservice.bean.WorkDTO;
import org.worklog.worklogservice.domain.Staff;
import org.worklog.worklogservice.domain.Work;
import org.worklog.worklogservice.repository.StaffRepository;
import org.worklog.worklogservice.repository.WorkRepository;
import org.worklog.worklogservice.transformer.Transformer;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository repo;

	@Autowired
	private WorkRepository workRepo;
	
	@Autowired
	private Transformer<Staff, StaffDTO> StaffTransformer;

	@Autowired
	private Transformer<Work, WorkDTO> workTransformer;
	
	@Override
	public StaffDTO getById(Long id) {
		Staff staff = repo.getOne(id);
		return StaffTransformer.toDTO(staff);
	}
	
	public StaffDTO getByUsername(String username) {
		Staff staff = repo.findByUsername(username).get();
		return StaffTransformer.toDTO(staff);
	}
	
	@Override
	public StaffDTO register(StaffDTO staffDto) {
		// to Entity
		Staff staff = StaffTransformer.toEntity(staffDto);
		// save to DB
		Staff result = repo.saveAndFlush(staff);
		StaffDTO dto = null;
		if (result != null) {
			dto = StaffTransformer.toDTO(result);
		}
		return dto;
	}
	
	@Override
	public WorkDTO addWork(Long staffId, WorkDTO workDTO) {
		Work work = workTransformer.toEntity(workDTO);
		Staff staff = repo.getOne(staffId);
		work.setStaff(staff);
		Work result = workRepo.saveAndFlush(work);
		return workTransformer.toDTO(result);
	}
	
	@Override
	public List<WorkDTO> getAllWorks(Long staffID) {
		List<Work> workList = workRepo.findAllWorksByStaffId(staffID);
		return workTransformer.toDtoList(workList);
	}
	
	@Override
	public Integer removeWork(Long staffID, Long workID) {
		return workRepo.deleteWork(staffID, workID);
	}
	
}
