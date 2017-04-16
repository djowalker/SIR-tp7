package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	private Long id;
	private String name;
	private String surname;
	private String mail;
	private List<Person> friend = new ArrayList<Person>();
	private List<Home> homes = new ArrayList<Home>();
	private List<ElectronicDevice> devices = new ArrayList<ElectronicDevice>();
	
	public Person(){
	}
	
	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public Person(String name, String surname, String mail, List<Person> friend, List<Home> homes,
			List<ElectronicDevice> devices) {
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.friend = friend;
		this.homes = homes;
		this.devices = devices;
	}

	

	public Person(String name, String surname, String mail) {
		super();
		this.name = name;
		this.surname = surname;
		this.mail = mail;
	}

	@ManyToMany
	public List<Person> getFriend() {
		return friend;
	}

	public void setFriend(List<Person> friend) {
		this.friend = friend;
	}

	public void addFriend(Person friend){
		this.friend.add(friend);
	}
	
	@OneToMany
	public List<Home> getHomes() {
		return homes;
	}

	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}

	@OneToMany
	public List<ElectronicDevice> getDevices() {
		return devices;
	}

	public void setDevices(List<ElectronicDevice> devices) {
		this.devices = devices;
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
    
    public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	
	
}
