package org.worklog.worklogservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.worklog.worklogservice.bean.StaffDTO;
import org.worklog.worklogservice.bean.WorkDTO;
import org.worklog.worklogservice.service.StaffService;

@RestController
@CrossOrigin
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	private StaffService service;

	@GetMapping("/hello")
	public String hello() {
		return "hello to spring boot security, you're authorized to see this content!";
	}
	
	@GetMapping("/get")
	public StaffDTO getStaff(@RequestParam Long id) {
		StaffDTO s = service.getById(id);
		return s;
	}
	
	@GetMapping("/userOnly")
	public String test() {
		return "Hello User";
	}
	
	@RequestMapping(value = "/{staffId}/addWork", method = RequestMethod.POST)
	public WorkDTO addWork(@PathVariable(value="staffId") final long staffId, @RequestBody WorkDTO workDTO) {
		WorkDTO workDTOResult = service.addWork(staffId, workDTO);
		return workDTOResult;
	}
	
	@RequestMapping(value = "/{staffId}/getAllWorks", method = RequestMethod.GET)
	public List<WorkDTO> getAllWorks(@PathVariable(value="staffId") final long staffId) {
		List<WorkDTO> workDTOList = service.getAllWorks(staffId);
		return workDTOList;
	}
	
	@RequestMapping(value = "/{staffID}/work/{workID}/remove", method = RequestMethod.GET)
	public Integer remove(@PathVariable(value="staffID") final long staffID, @PathVariable(value="workID") final long workID) {
		return service.removeWork(staffID, workID);
	}
	
}
