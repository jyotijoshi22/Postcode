package io.postcode.Postcode.suburb;

public class SuburbDTO {
    private Long id;
    private String suburbName;
    private String postcode;

    public SuburbDTO() {
    }

    public SuburbDTO(Long id,String suburbName, String postcode) {
    	this.id=id;   
        this.suburbName = suburbName;
        this.postcode = postcode;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getSuburbName() {
		return suburbName;
	}

	public void setSuburbName(String suburbName) {
		this.suburbName = suburbName;
	}
   

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}