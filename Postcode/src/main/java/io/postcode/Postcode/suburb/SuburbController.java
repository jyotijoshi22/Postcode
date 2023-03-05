package io.postcode.Postcode.suburb;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  
    @PostMapping("/createSuburbs")
	public ResponseEntity<Suburb> createSuburbRecord(@RequestBody SuburbDTO suburbDto) {
		Suburb newSub = this.suburbService.addSuburb(suburbDto);

		return new ResponseEntity<>(newSub, HttpStatus.CREATED);
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