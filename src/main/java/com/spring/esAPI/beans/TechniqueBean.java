package com.spring.esAPI.beans;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.spring.esAPI.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@Getter
@Data
@Document(indexName = Constants.MITRE_INDEX)


class RelationshipDetails{
	public String source_data_element;
	public String relationship;
	public String target_data_element;
}

class DataSourceDetails{

	public String name;
	public String description;
	public String type;
	@Field(type = FieldType.Nested)
	public List<RelationshipDetails>relationships;
};

public class TechniqueBean {
	public String tid;
	public String techniquename;

	@Field(name = "tactics")
	public List<String> tactics;
	public List<String> subtechniques;
	public List<String> platforms;
	public String version;
	public String created;
	public String lastmodified;
	public String detection;
	public String description;
	public Object mitigations;
	public String subtechniqueof;
	public String impacttype;
	public String contributors;
	public Object procedureexamples;
	@Field(type= FieldType.Nested)
	public Map<String, List<DataSourceDetails>> datasources;
}