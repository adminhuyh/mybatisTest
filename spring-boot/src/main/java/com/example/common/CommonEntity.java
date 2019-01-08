package com.example.common;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
public abstract class CommonEntity implements Serializable {
	
	private static final long serialVersionUID = 7086152182345549297L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private String id;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = "".equals(id)?null:id;
	}

	private Long version;
	
	@Version
    @JsonIgnore	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
}
