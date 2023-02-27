package io.postcode.Postcode.suburb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SuburbRepository extends JpaRepository<Suburb, Long> {
	@Query("SELECT s FROM Suburb s WHERE s.suburbName = :suburbName")
    Suburb findByName(@Param("suburbName") String suburbName);

    Suburb findByPostcode(String postcode);

   

}