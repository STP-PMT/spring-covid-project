package net.csmsu.covid.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_vaccine3 database table.
 * 
 */
@Entity
@Table(name="tb_vaccine3")
@NamedQuery(name="Vaccine3.findAll", query="SELECT v FROM Vaccine3 v")
public class Vaccine3 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int v3id;

	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-one association to Register
	@OneToMany(mappedBy="tbVaccine3")
	private List<Register> tbRegisters;

	//bi-directional many-to-one association to Register
	@ManyToOne
	@JoinColumn(name="rid")
	private Register tbRegister;

	//bi-directional many-to-one association to Vaccine
	@ManyToOne
	@JoinColumn(name="vid")
	private Vaccine tbVaccine;

	public Vaccine3() {
	}

	public int getV3id() {
		return this.v3id;
	}

	public void setV3id(int v3id) {
		this.v3id = v3id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Register> getTbRegisters() {
		return this.tbRegisters;
	}

	public void setTbRegisters(List<Register> tbRegisters) {
		this.tbRegisters = tbRegisters;
	}

	public Register addTbRegister(Register tbRegister) {
		getTbRegisters().add(tbRegister);
		tbRegister.setTbVaccine3(this);

		return tbRegister;
	}

	public Register removeTbRegister(Register tbRegister) {
		getTbRegisters().remove(tbRegister);
		tbRegister.setTbVaccine3(null);

		return tbRegister;
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