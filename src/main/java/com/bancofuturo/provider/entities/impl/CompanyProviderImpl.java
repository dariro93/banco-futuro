package com.bancofuturo.provider.entities.impl;

import com.bancofuturo.provider.entities.CompanyProvider;
import com.bancofuturo.provider.entities.CompanyUtil;
import com.bancofuturo.provider.exception.InvalidMatrixDataException;
import com.bancofuturo.provider.model.CompanyDB;
import com.bancofuturo.provider.repository.CompanyRepository;
import com.bancofuturo.usecase.model.Company;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.bancofuturo.provider.entities.CompanyUtil.castMatrixToString;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 5:00 PM
 *
 * @author David Rodriguez
 */
@Repository
public class CompanyProviderImpl implements CompanyProvider {

    private static final String INVALID_MATRIX_DATA_ERROR = "Invalid generated data matrix for company";
    private CompanyRepository companyRepository;

    @Autowired
    public CompanyProviderImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void saveCompanyData(Company company) throws InvalidMatrixDataException {
        companyRepository.save(castCompanyToDB(company));
    }

    @Override
    public Optional<Company> retrieveCompanyByName(String name) {
        return companyRepository.findById(name).map(
                CompanyUtil::castCompanyDBToCompanyModel
        );
    }

    private CompanyDB castCompanyToDB(Company company) throws InvalidMatrixDataException {
        CompanyDB companyDB = new CompanyDB();
        try {
            companyDB.setMatrixData(castMatrixToString(company.getMatrixData()));
            companyDB.setName(company.getName());
        } catch (JsonProcessingException e) {
            throw new InvalidMatrixDataException(INVALID_MATRIX_DATA_ERROR);
        }
        return companyDB;
    }

}
