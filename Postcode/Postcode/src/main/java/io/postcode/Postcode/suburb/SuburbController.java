package io.postcode.Postcode.suburb;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suburbs")
public class SuburbController {
	
	@Autowired
	private  SuburbService suburbService;

    public SuburbController(SuburbService suburbService) {
        this.suburbService = suburbService;
    }

    @GetMapping
    public ResponseEntity<List<Suburb>> getAll() {
        List<Suburb> allInfo = this.suburbService.getAll();
        return new ResponseEntity<>(allInfo, HttpStatus.OK);
    }

    
    
    @GetMapping("/{id}")
    public ResponseEntity<Suburb> getById(@PathVariable Long id) {
        Optional<Suburb> idInfo = this.suburbService.getById(id);

        if (idInfo.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(idInfo.get(), HttpStatus.NOT_FOUND);
    }

        
    @PreAuthorize("hasRole('Editor')")
    @PostMapping("/createSuburbs")
    public ResponseEntity<SuburbDTO> addSuburb(@RequestBody SuburbDTO suburbDTO) {

        Suburb suburb = new Suburb();
        suburb.setName(suburbDTO.getName());
        suburb.setPostcode(suburbDTO.getPostcode());

        // Check if the suburb already exists
        if (suburbService.getSuburbByPostcode(suburbDTO.getPostcode()) != null ||
                suburbService.getSuburbByPostcode(suburbDTO.getName()) != null) {
            return ResponseEntity.badRequest().build();
        }

        // Add the new suburb
        Suburb addedSuburb = this.suburbService.addSuburb(new Suburb(suburbDTO.getName(), suburbDTO.getPostcode()));
        return ResponseEntity.created(URI.create("/createSuburbs/" + addedSuburb.getId())).build();
    }

    
    
    
    @RequestMapping(params="postcode")
    @ResponseBody
    public ResponseEntity<List<Suburb>> getSuburbByPostcode(@RequestParam String postcode) {
        List<Suburb> suburbList = this.suburbService.getSuburbByPostcode(postcode);
        if (suburbList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(suburbList);
    }
    
    
    

    @RequestMapping(params = "suburbName")
    @ResponseBody
    public ResponseEntity<List<Suburb>> getPostcodeByName(@RequestParam String name) {
        List<Suburb> postList = this.suburbService.getSuburbByPostcode(name);
        if (postList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postList);
    }
}