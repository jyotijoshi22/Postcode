package io.postcode.Postcode.suburb;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface SuburbRepository extends JpaRepository<Suburb, Long> {

List<Suburb> findByPostcode(String postcode);

List<Suburb> findByName(String name);
	
  
}