package com.appliedsni.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="XOFFICE")
public class Office extends PersistenceObject implements Serializable{
	 @Id
	    @Column(name = "XOID", columnDefinition = "NUMBER(38)", nullable = false)
	    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
		@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	    private Long id;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	@Column(name="XNAME",nullable = false)
	String name;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "XPROJETC_XOID", referencedColumnName = "XOID", nullable = false)
    private Project project;
	public Office(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
