package org.worklog.worklogservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.worklog.worklogservice.domain.Staff;
import org.worklog.worklogservice.domain.UserDetailsImpl;
import org.worklog.worklogservice.repository.StaffRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private StaffRepository staffRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Staff> staff = staffRepository.findByUsername(username);
		return new UserDetailsImpl(staff.get());
	}

}
