package com.spring.esAPI.beans;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import com.spring.esAPI.Constants;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Data
@Document(indexName = Constants.MITRE_INDEX)
public class TechniqueBean {
	
	//@Id
	@Field(name = "tid")
	public String tid;
	public String techniquename;
	public String tactic;
	@Field(name = "tactics")
	public List<String> tactics; 
	public List<String> subtechniques;
	public List<String> platforms;
	public Object datasources;
	public String version;
	public String created;
	public String lastmodified;
	public String detection;
	public String description;
	public Object mitigations;
	public String impacttype;
 	public String contributors;
	public String subtechniqueof;
	public Object procedureexamples;
	
}
