package net.csmsu.covid.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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

	private String status;

	//bi-directional many-to-one association to Register
	@OneToMany(mappedBy="tbVaccine2")
	private List<Register> tbRegisters;

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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Register> getTbRegisters() {
		return this.tbRegisters;
	}

	public void setTbRegisters(List<Register> tbRegisters) {
		this.tbRegisters = tbRegisters;
	}

	public Register addTbRegister(Register tbRegister) {
		getTbRegisters().add(tbRegister);
		tbRegister.setTbVaccine2(this);

		return tbRegister;
	}

	public Register removeTbRegister(Register tbRegister) {
		getTbRegisters().remove(tbRegister);
		tbRegister.setTbVaccine2(null);

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