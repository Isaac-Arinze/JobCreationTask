package com.zikan.zikApp.company;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/v1/api/companies")
public class
CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(Long id){
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);

    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
//        return new ResponseEntity<>(companyService.getCompanyById(id), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if(company!=null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<String> addCompanies (@RequestBody Company company){
        companyService.createCompanies(company);
        return new ResponseEntity<>("Comapny created successfully", HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCompanies(@PathVariable Long id, @RequestBody Company company){
        companyService.updateCompanies(id, company);

        return new ResponseEntity<>("companies updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> deleteCompany(@PathVariable Long id){
        boolean isDeleted =  companyService.deleteCompanyById(id);
        if(isDeleted) {
            return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
        }

    }
}
