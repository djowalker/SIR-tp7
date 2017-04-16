package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Heater {

	private Long id;
	private String reference;
	private int consommationAvg;
	private Home home;
	
	public Heater() {
	}

	public Heater(String reference, int consommationAvg) {
		this.reference = reference;
		this.consommationAvg = consommationAvg;
	}
	
	public Heater(String reference) {
		this.reference = reference;
	}

	public Heater(Long id, String reference, int consommationAvg) {
		this.id = id;
		this.reference = reference;
		this.consommationAvg = consommationAvg;
	}
	
//	public Heater(Heater heater){
//		this.id=heater.getId();
//		this.reference=heater.getReference();
//		this.consommationAvg=heater.getConsommationAvg();
//		this.home=heater.home;
//	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getConsommationAvg() {
		return consommationAvg;
	}

	public void setConsommationAvg(int consommationAvg) {
		this.consommationAvg = consommationAvg;
	}
	
	@ManyToOne
	//@JoinColumn(name="HOME_ID_FK", referencedColumnName="HOME_REF_ID")
	public Home getHome(){
		return this.home;
	}
	
	public void setHome(Home home){
		this.home = home;
	}

	@Override
	public String toString() {
		return "Heater [id=" + id + ", reference=" + reference + ", consommationAvg=" + consommationAvg + "]";
	}



	
	
	
}
