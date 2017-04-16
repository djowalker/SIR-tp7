package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="device")
public class ElectronicDevice {
	
	private Long id;
	private String name;
	private String reference;
	private int consommationAvg;
	private Home home;

	public ElectronicDevice(){
		
	}
	
	public ElectronicDevice(String name, String reference) {
		this.name = name;
		this.reference = reference;
	}
	
	public ElectronicDevice(String name, String reference, int consommationAvg) {
		this.name = name;
		this.reference = reference;
		this.consommationAvg = consommationAvg;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Home getHome(){
		return this.home;
	}
	
	public void setHome(Home home){
		this.home = home;
	}

	@Override
	public String toString() {
		return "ElectronicDevice [id=" + id + ", name=" + name + ", reference=" + reference + ", consommationAvg="
				+ consommationAvg + "]";
	}

	
	
	
	
}
