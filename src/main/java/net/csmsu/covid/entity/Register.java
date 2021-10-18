package net.csmsu.covid.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_register database table.
 * 
 */
@Entity
@Table(name="tb_register")
@NamedQuery(name="Register.findAll", query="SELECT r FROM Register r")
public class Register implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rid;
	
	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="sid")
	private Student tbStudent;

	//bi-directional many-to-one association to Vaccine1
	@OneToMany(mappedBy="tbRegister")
	private List<Vaccine1> tbVaccine1s;

	//bi-directional many-to-one association to Vaccine2
	@OneToMany(mappedBy="tbRegister")
	private List<Vaccine2> tbVaccine2s;

	//bi-directional many-to-one association to Vaccine3
	@OneToMany(mappedBy="tbRegister")
	private List<Vaccine3> tbVaccine3s;

	public Register() {
	}

	public int getRid() {
		return this.rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Student getTbStudent() {
		return this.tbStudent;
	}

	public void setTbStudent(Student tbStudent) {
		this.tbStudent = tbStudent;
	}

	public List<Vaccine1> getTbVaccine1s() {
		return this.tbVaccine1s;
	}

	public void setTbVaccine1s(List<Vaccine1> tbVaccine1s) {
		this.tbVaccine1s = tbVaccine1s;
	}

	public Vaccine1 addTbVaccine1(Vaccine1 tbVaccine1) {
		getTbVaccine1s().add(tbVaccine1);
		tbVaccine1.setTbRegister(this);

		return tbVaccine1;
	}

	public Vaccine1 removeTbVaccine1(Vaccine1 tbVaccine1) {
		getTbVaccine1s().remove(tbVaccine1);
		tbVaccine1.setTbRegister(null);

		return tbVaccine1;
	}

	public List<Vaccine2> getTbVaccine2s() {
		return this.tbVaccine2s;
	}

	public void setTbVaccine2s(List<Vaccine2> tbVaccine2s) {
		this.tbVaccine2s = tbVaccine2s;
	}

	public Vaccine2 addTbVaccine2(Vaccine2 tbVaccine2) {
		getTbVaccine2s().add(tbVaccine2);
		tbVaccine2.setTbRegister(this);

		return tbVaccine2;
	}

	public Vaccine2 removeTbVaccine2(Vaccine2 tbVaccine2) {
		getTbVaccine2s().remove(tbVaccine2);
		tbVaccine2.setTbRegister(null);

		return tbVaccine2;
	}

	public List<Vaccine3> getTbVaccine3s() {
		return this.tbVaccine3s;
	}

	public void setTbVaccine3s(List<Vaccine3> tbVaccine3s) {
		this.tbVaccine3s = tbVaccine3s;
	}

	public Vaccine3 addTbVaccine3(Vaccine3 tbVaccine3) {
		getTbVaccine3s().add(tbVaccine3);
		tbVaccine3.setTbRegister(this);

		return tbVaccine3;
	}

	public Vaccine3 removeTbVaccine3(Vaccine3 tbVaccine3) {
		getTbVaccine3s().remove(tbVaccine3);
		tbVaccine3.setTbRegister(null);

		return tbVaccine3;
	}

}