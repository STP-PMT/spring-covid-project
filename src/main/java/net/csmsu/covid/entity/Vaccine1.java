package net.csmsu.covid.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_vaccine1 database table.
 * 
 */
@Entity
@Table(name="tb_vaccine1")
@NamedQuery(name="Vaccine1.findAll", query="SELECT v FROM Vaccine1 v")
public class Vaccine1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int v1id;

	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-one association to Register
	@ManyToOne
	@JoinColumn(name="rid")
	private Register tbRegister;

	//bi-directional many-to-one association to Vaccine
	@ManyToOne
	@JoinColumn(name="vid")
	private Vaccine tbVaccine;

	public Vaccine1() {
	}

	public int getV1id() {
		return this.v1id;
	}

	public void setV1id(int v1id) {
		this.v1id = v1id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Register getTbRegister() {
		return this.tbRegister;
	}

	public void setTbRegister(Register tbRegister) {
		this.tbRegister = tbRegister;
	}

	public Vaccine getTbVaccine() {
		return this.tbVaccine;
	}

	public void setTbVaccine(Vaccine tbVaccine) {
		this.tbVaccine = tbVaccine;
	}

}