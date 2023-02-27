package io.postcode.Postcode.suburb;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SuburbRepository extends JpaRepository<Suburb, Long> {

List<Suburb> findByPostcode(String postcode);

List<Suburb> findByName(String suburbName);
	
  
}