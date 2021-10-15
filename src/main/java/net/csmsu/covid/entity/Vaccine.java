package net.csmsu.covid.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_vaccine database table.
 * 
 */
@Entity
@Table(name="tb_vaccine")
@NamedQuery(name="Vaccine.findAll", query="SELECT v FROM Vaccine v")
public class Vaccine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int vid;

	private int efficacy;

	private String name;

	//bi-directional many-to-one association to Vaccine1
	@OneToMany(mappedBy="tbVaccine")
	private List<Vaccine1> tbVaccine1s;

	//bi-directional many-to-one association to Vaccine2
	@OneToMany(mappedBy="tbVaccine")
	private List<Vaccine2> tbVaccine2s;

	//bi-directional many-to-one association to Vaccine3
	@OneToMany(mappedBy="tbVaccine")
	private List<Vaccine3> tbVaccine3s;

	public Vaccine() {
	}

	public int getVid() {
		return this.vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public int getEfficacy() {
		return this.efficacy;
	}

	public void setEfficacy(int efficacy) {
		this.efficacy = efficacy;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Vaccine1> getTbVaccine1s() {
		return this.tbVaccine1s;
	}

	public void setTbVaccine1s(List<Vaccine1> tbVaccine1s) {
		this.tbVaccine1s = tbVaccine1s;
	}

	public Vaccine1 addTbVaccine1(Vaccine1 tbVaccine1) {
		getTbVaccine1s().add(tbVaccine1);
		tbVaccine1.setTbVaccine(this);

		return tbVaccine1;
	}

	public Vaccine1 removeTbVaccine1(Vaccine1 tbVaccine1) {
		getTbVaccine1s().remove(tbVaccine1);
		tbVaccine1.setTbVaccine(null);

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
		tbVaccine2.setTbVaccine(this);

		return tbVaccine2;
	}

	public Vaccine2 removeTbVaccine2(Vaccine2 tbVaccine2) {
		getTbVaccine2s().remove(tbVaccine2);
		tbVaccine2.setTbVaccine(null);

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
		tbVaccine3.setTbVaccine(this);

		return tbVaccine3;
	}

	public Vaccine3 removeTbVaccine3(Vaccine3 tbVaccine3) {
		getTbVaccine3s().remove(tbVaccine3);
		tbVaccine3.setTbVaccine(null);

		return tbVaccine3;
	}

}