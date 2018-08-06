package com.inteliment.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Storage {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String data;
    private String type;
    protected Storage(){}
	public Storage( String data, String type) {
		super();
		
		this.data = data;
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
    

}
