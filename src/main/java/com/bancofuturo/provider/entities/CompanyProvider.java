package com.bancofuturo.provider.entities;

import com.bancofuturo.provider.exception.InvalidMatrixDataException;
import com.bancofuturo.usecase.model.Company;

import java.util.Optional;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 4:59 PM
 *
 * @author David Rodriguez
 */
public interface CompanyProvider {

    void saveCompanyData(Company company) throws InvalidMatrixDataException;

    Optional<Company> retrieveCompanyByName(String name);

}
