package io.postcode.Postcode.suburb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class SuburbService {

    @Autowired   
    private SuburbRepository suburbRepository;

  
    public Suburb getSuburbByPostcode(String postcode) {
    	return suburbRepository.findByPostcode(postcode);
    }

    
    public Suburb getSuburbByName(String suburbName) {
    	return suburbRepository.findByName(suburbName);
    }


    public Suburb addSuburb(Suburb suburb) {
        return suburbRepository.save(suburb);
    }
}