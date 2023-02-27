package io.postcode.Postcode.suburb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GetSubPos")
public class  Suburb {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
    private Long id;
	
	
	@Column(unique = true,name="Suburb")
	private String suburbName;

    @Column(unique = true,name="Postcode")
    private String postcode;

	public Suburb(String name, String postcode) {
		super();
		this.suburbName = name;
		this.postcode = postcode;
	}

	
//default constructor
	public Suburb() {
	
			}
//getter and setters
	public String getName() {
		return suburbName;
	}

	public void setName(String name) {
		this.suburbName = name;
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
