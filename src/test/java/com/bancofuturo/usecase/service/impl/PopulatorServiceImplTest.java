package com.bancofuturo.usecase.service.impl;

import com.bancofuturo.provider.entities.CompanyProvider;
import com.bancofuturo.provider.exception.InvalidMatrixDataException;
import com.bancofuturo.usecase.model.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 7:24 PM
 *
 * @author David Rodriguez
 */
@RunWith(MockitoJUnitRunner.class)
public class PopulatorServiceImplTest {

    private static final String COMPANY_NAME = "testCompany";

    @Mock
    private CompanyProvider companyProvider;

    @InjectMocks
    private PopulatorServiceImpl populatorService;

    @Test
    public void shouldSaveCompanyInDBIfCompanyNotExists() throws InvalidMatrixDataException {
        populatorService.populateDataForCompany(COMPANY_NAME);
        Mockito.verify(companyProvider).saveCompanyData(Mockito.any(Company.class));
    }

    @Test
    public void shouldNotSaveCompanyInDBIfCompanyExists() throws InvalidMatrixDataException {
        Company company = new Company(COMPANY_NAME, new ArrayList<>());
        Mockito.when(companyProvider.retrieveCompanyByName(COMPANY_NAME)).thenReturn(Optional.of(company));
        populatorService.populateDataForCompany(COMPANY_NAME);
        Mockito.verify(companyProvider, Mockito.times(0)).saveCompanyData(Mockito.any(Company.class));
    }

}
