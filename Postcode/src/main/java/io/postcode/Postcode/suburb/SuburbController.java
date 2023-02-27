package io.postcode.Postcode.suburb;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suburbs")
public class SuburbController {

    @Autowired
    private SuburbService suburbService;
    

    @GetMapping("/{postcode}")
    
       public ResponseEntity<SuburbDTO> getSuburbByPostcode(@PathVariable String postcode) {
        Suburb suburb = suburbService.getSuburbByPostcode(postcode);
        if (suburb == null) {
            return ResponseEntity.notFound().build();
        }
        SuburbDTO suburbDTO = new SuburbDTO(suburb.getId(), suburb.getName(), suburb.getPostcode());
        return ResponseEntity.ok(suburbDTO);
    }
    
    
    @GetMapping(params = "name")
    public ResponseEntity<SuburbDTO> getSuburbByName(@RequestParam String name) {
        Suburb suburb = suburbService.getSuburbByName(name);
        if (suburb == null) {
            return ResponseEntity.notFound().build();
        }
        SuburbDTO suburbDTO = new SuburbDTO(suburb.getId(), suburb.getName(), suburb.getPostcode());
        return ResponseEntity.ok(suburbDTO);
    }
    
    @PostMapping("/createSuburbs")
    public ResponseEntity<SuburbDTO> addSuburb(@RequestBody SuburbDTO suburbDTO) {
    	
    	Suburb suburb = new Suburb();
        suburb.setName(suburbDTO.getSuburbName());
        suburb.setPostcode(suburbDTO.getPostcode());
    	
        // Check if the suburb already exists
        if (suburbService.getSuburbByPostcode(suburbDTO.getPostcode()) != null ||
                suburbService.getSuburbByName(suburbDTO.getSuburbName()) != null) {
            return ResponseEntity.badRequest().build();
        }

        
        // Add the new suburb
        Suburb addedSuburb = suburbService.addSuburb(new Suburb(suburbDTO.getId(),suburbDTO.getSuburbName(), suburbDTO.getPostcode()));
        return ResponseEntity.created(URI.create("/createSuburbs/" + addedSuburb.getId())).build();
    }
    

}