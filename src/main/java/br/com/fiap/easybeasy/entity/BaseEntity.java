package br.com.fiap.easybeasy.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@JsonIgnore
	@Transient
	protected Map<String, String> errors = new HashMap<String, String>();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	@JsonIgnore
	public Boolean isValid() {
		return errors.isEmpty();
	}
	
	public Object valueOrDefault(Object value, Object defaultValue) {
		return value != null ? value : defaultValue;
	}
	
	public void addError(String key, String message) {
		this.getErrors().put(key, message);
	}

}

