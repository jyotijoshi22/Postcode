package io.postcode.Postcode.suburb;

public class SuburbDTO {
    private Long id;
    private String name;
    private String postcode;

    public SuburbDTO() {
    }

    public SuburbDTO(String name, String postcode) {
    	  
        this.name = name;
        this.postcode = postcode;
    }

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
   

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}