package org.worklog.worklogservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.worklog.worklogservice.bean.StaffDTO;
import org.worklog.worklogservice.domain.Staff;
import org.worklog.worklogservice.service.StaffService;

@RestController
@CrossOrigin
public class TestController {
	
	@Autowired
	private StaffService service;

	@GetMapping("/hello")
	public String hello() {
		return "hello to spring boot security, you're authorized to see this content!";
	}
	
	@GetMapping("/staff")
	public StaffDTO getStaff(@RequestParam Long id) {
		StaffDTO s = service.getById(id);
		return s;
	}
	
	@GetMapping("/userOnly")
	public String test() {
		return "Hello User";
	}
}
