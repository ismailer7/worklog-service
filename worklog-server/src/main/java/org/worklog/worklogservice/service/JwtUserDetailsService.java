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
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private StaffRepository staffReposiotry;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Staff> staffOptional = staffReposiotry.findByUsername(username);
		
		if(staffOptional.isPresent()) {
			Staff staff = staffOptional.get();
			return new UserDetailsImpl(staff);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}