package io.postcode.Postcode.suburb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SuburbService {

    @Autowired   
    private SuburbRepository suburbRepository;

  public List<Suburb> getAll() {
	  return this.suburbRepository.findAll();
  }
    
	public Optional<Suburb> getById(Long id) {
		return this.suburbRepository.findById(id);
	}
	
	 
    public List<Suburb> getSuburbByPostcode(String postcode) {
    	return suburbRepository.findByPostcode(postcode);
    }

    
    public List<Suburb> getPostcodeByName(String suburbName) {
    	return suburbRepository.findByName(suburbName);
    }


    public Suburb addSuburb(SuburbDTO suburb2) {
        
        // Create new suburb entity
        Suburb suburb = new Suburb();
        suburb.setName(suburb2.getName());
        suburb.setPostcode(suburb2.getPostcode());

        // Save the new suburb
        return this.suburbRepository.save(suburb);
    }
    
    
    
    
}