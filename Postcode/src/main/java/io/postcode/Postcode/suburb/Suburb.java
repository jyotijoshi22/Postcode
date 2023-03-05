package io.postcode.Postcode.suburb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Get_Sub_Pos")
public class  Suburb {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
    private Long id;
	
	
	@Column(name="name")
	private String name;

    @Column(name="Postcode")
    private String postcode;

	public Suburb(String name, String postcode) {
		super();
		this.name = name;
		this.postcode = postcode;
	}

	
//default constructor
	public Suburb() {
	
			}
//getter and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	
}
