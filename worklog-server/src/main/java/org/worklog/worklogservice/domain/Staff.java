package org.worklog.worklogservice.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "STAFF")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STAFF_ID")
	private Long staffId;
	
	@Column(nullable = false, unique = true, name = "STAFF_USERNAME")
	private String username;
	
	@Column(nullable = false, name = "STAFF_PASSWORD")
	private String password;
	
	@Column(nullable = true, name = "STAFF_ACTIVE")
	private boolean active;
	
	@Column(nullable = false, unique = true, name = "STAFF_EMAIL")
	private String email;
	
	@Column(name = "STAFF_PHONE")
	private String phoneNumber;
	
//	mappedBy always create bidirectional relation
	
	@OneToMany(mappedBy = "staff")
	private Set<Work> works;
	
	@Column(name = "ROLES")
	private String role;
	
	@PrePersist
	public void prePersist() {
	    active = true;
	}
}
