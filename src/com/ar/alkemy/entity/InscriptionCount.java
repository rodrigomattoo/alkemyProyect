package com.ar.alkemy.entity;

import javax.persistence.Entity;

public class InscriptionCount {
	
	private Integer subjectId;
	
	private Integer incriptions;

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getIncriptions() {
		return incriptions;
	}

	public void setIncriptions(Integer incriptions) {
		this.incriptions = incriptions;
	}
	
	

}
