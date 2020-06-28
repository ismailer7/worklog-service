package org.worklog.worklogservice.transformer;

import org.springframework.stereotype.Component;
import org.worklog.worklogservice.bean.WorkDTO;
import org.worklog.worklogservice.domain.Work;

@Component
public class WorkTransformer extends Transformer<Work, WorkDTO> {

	@Override
	public Work toEntity(WorkDTO d) {
		Work work = null;
		if(d != null) {
			work = new Work();
			work.setWorkTitle(d.getWorkTitle());
			work.setDescription(d.getDescription());
			work.setLogAction(d.getLogAction());
			work.setLoggedTime(d.getLoggedTime());
			work.setStatus(d.getStatus());
			work.setTimeLeft(d.getTimeLeft());
			work.setTimeSpent(d.getTimeSpent());
		}
		return work;
	}

	@Override
	public WorkDTO toDTO(Work e) {
		WorkDTO workDTO = null;
		if(e != null) {
			workDTO = new WorkDTO();
			workDTO.setWorkId(e.getWorkId());
			workDTO.setWorkTitle(e.getWorkTitle());
			workDTO.setDescription(e.getDescription());
			workDTO.setLogAction(e.getLogAction());
			workDTO.setLoggedTime(e.getLoggedTime());
			workDTO.setStatus(e.getStatus());
			workDTO.setTimeLeft(e.getTimeLeft());
			workDTO.setTimeSpent(e.getTimeSpent());
		}
		return workDTO;
	}

}
