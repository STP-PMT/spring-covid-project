package net.csmsu.covid.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_vaccine2 database table.
 * 
 */
@Entity
@Table(name="tb_vaccine2")
@NamedQuery(name="Vaccine2.findAll", query="SELECT v FROM Vaccine2 v")
public class Vaccine2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int v2id;

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

	public Vaccine2() {
	}

	public int getV2id() {
		return this.v2id;
	}

	public void setV2id(int v2id) {
		this.v2id = v2id;
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