package org.worklog.worklogservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.worklog.worklogservice.domain.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

	Optional<Staff> findByUsername(String username);
	
}
