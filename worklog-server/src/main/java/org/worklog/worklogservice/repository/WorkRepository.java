package org.worklog.worklogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.worklog.worklogservice.domain.Work;

public interface WorkRepository extends JpaRepository<Work, Long> {

	@Query("select w from Work w where w.staff.staffId = :staffId")
	List<Work> findAllWorksByStaffId(@Param("staffId") Long staffId);

	@Transactional
	@Modifying
	@Query("delete from Work w where w.staff.staffId = :staffId and w.workId = :workId")
	Integer deleteWork(@Param("staffId") Long staffId, @Param("workId") Long workId);
	
}
