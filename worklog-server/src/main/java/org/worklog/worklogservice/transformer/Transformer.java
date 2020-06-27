package org.worklog.worklogservice.transformer;

import java.util.ArrayList;
import java.util.List;

public abstract class Transformer<E, D> {
	
	public abstract E toEntity(D d);
	
	public abstract D toDTO(E e);
	
	
	public List<E> toEntityList(List<D> dtoList) {
		List<E> entityList = new ArrayList<>();
		for (D d : dtoList) {
			entityList.add(toEntity(d));
		}
		return entityList;
	}
	
	public List<D> toDtoList(List<E> entityList) {
		List<D> dtoList = new ArrayList<>();
		for (E e : entityList) {
			dtoList.add(toDTO(e));
		}
		return dtoList;
	}
	
}
