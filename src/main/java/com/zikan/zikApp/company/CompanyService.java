package com.zikan.zikApp.company;

import java.util.List;
import java.util.Optional;

public interface  CompanyService {

    List<Company> getAllCompanies();

    boolean updateCompanies(Long id, Company company);

    void createCompanies(Company company);

//    void deleteCompanyById(Long id);

    boolean deleteCompanyById(Long id);

//    Optional<Company> getCompanyById(Long id);
    Company getCompanyById(Long id);


}


