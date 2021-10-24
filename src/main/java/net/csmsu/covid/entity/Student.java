package net.csmsu.covid.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_student database table.
 * 
 */
@Entity
@Table(name="tb_student")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String sid;

	private String email;

	private String firstname;

	private String lastname;

	private String mobile;

	//bi-directional many-to-one association to Register
	@OneToMany(mappedBy="tbStudent")
	private List<Register> tbRegisters;

	public Student() {
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Register> getTbRegisters() {
		return this.tbRegisters;
	}

	public void setTbRegisters(List<Register> tbRegisters) {
		this.tbRegisters = tbRegisters;
	}

	public Register addTbRegister(Register tbRegister) {
		getTbRegisters().add(tbRegister);
		tbRegister.setTbStudent(this);

		return tbRegister;
	}

	public Register removeTbRegister(Register tbRegister) {
		getTbRegisters().remove(tbRegister);
		tbRegister.setTbStudent(null);

		return tbRegister;
	}

}