package com.bancofuturo.usecase.service.impl;

import com.bancofuturo.provider.entities.CompanyProvider;
import com.bancofuturo.provider.exception.InvalidMatrixDataException;
import com.bancofuturo.usecase.model.Company;
import com.bancofuturo.usecase.service.PopulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 3:43 PM
 *
 * @author David Rodriguez
 */
@Service
public class PopulatorServiceImpl implements PopulatorService {

    private CompanyProvider companyProvider;

    @Autowired
    public PopulatorServiceImpl(CompanyProvider companyProvider) {
        this.companyProvider = companyProvider;
    }

    @Override
    public void populateDataForCompany(String companyName) throws InvalidMatrixDataException {
        if (!companyProvider.retrieveCompanyByName(companyName).isPresent()) {
            Company company = new Company(companyName, generateMatrixData(generateRandomNumber(), generateRandomNumber()));
            companyProvider.saveCompanyData(company);
        }
    }

    private List<List<Double>> generateMatrixData(int rows, int columns) {
        List<List<Double>> evaluationMatrix = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            List<Double> rowValues = new ArrayList<>();
            for (int c = 0; c < columns; c++) {
                rowValues.add(generateRandomValueForMatrix());
            }
            evaluationMatrix.add(rowValues);
        }
        return evaluationMatrix;
    }

    private double generateRandomValueForMatrix() {
        return Math.random() * 100;
    }

    private static int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

}
