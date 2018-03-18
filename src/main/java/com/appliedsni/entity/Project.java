package com.appliedsni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="XPROJECT")
public class Project extends PersistenceObject implements Serializable {
	@Id
	@Column(name = "XOID", columnDefinition = "NUMBER(38)", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Long id;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Column(name = "XNAME", nullable = false)
	String name;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "XPROJETC_XOID", referencedColumnName = "XOID")
    private transient List<Office> office;

	public Project()
	{}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Office> getOffice() {
		return office;
	}

	public void setOffice(List<Office> office) {
		this.office = office;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
