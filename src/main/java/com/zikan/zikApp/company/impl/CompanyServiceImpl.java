package com.zikan.zikApp.company.impl;

import com.zikan.zikApp.company.Company;
import com.zikan.zikApp.company.CompanyRepository;
import com.zikan.zikApp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompanies(Long id, Company company) {
        Optional <Company> optionalCompany = companyRepository.findById(id);

        if(optionalCompany.isPresent()){
           Company regCompany =  optionalCompany.get();
           regCompany.setDescription(company.getDescription());
           regCompany.setName(company.getName());
           regCompany.setJobs(company.getJobs());
           companyRepository.save(regCompany);
           return true;
        }
        return false;
    }

    @Override
    public void createCompanies(Company company) {
         companyRepository.save(company);

    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

//    @Override
//    public Optional<Company> getCompanyById(Long id) {
//          return companyRepository.findById(id);
//    }
    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

//    @Override
//    public void deleteCompanyById(@PathVariable Long id) {
//        companyRepository.deleteById(id);
////
//    }


}