package com.bancofuturo.usecase.service.impl;

import com.bancofuturo.provider.entities.CompanyProvider;
import com.bancofuturo.usecase.exception.NoSuchCompanyException;
import com.bancofuturo.usecase.model.Company;
import com.bancofuturo.usecase.model.EvaluationType;
import com.bancofuturo.usecase.model.RiskEvaluation;
import com.bancofuturo.usecase.model.RiskMatrixEvaluation;
import com.bancofuturo.usecase.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 3:14 PM
 *
 * @author David Rodriguez
 */
@Service
public class RiskServiceImpl implements RiskService {

    private static final String LESS_VALUE_ERROR = "Matrix value cannot be less than 0";
    private static final String GREATER_VALUE_ERROR = "Matrix value cannot exceed 100";
    private static final String NO_COMPANY_ERROR = "There is no such company named %s";

    private CompanyProvider companyProvider;

    @Autowired
    public RiskServiceImpl(CompanyProvider companyProvider) {
        this.companyProvider = companyProvider;
    }

    @Override
    public RiskMatrixEvaluation calculateRisk(String companyName) throws NoSuchCompanyException {
        Optional<Company> company = companyProvider.retrieveCompanyByName(companyName);
        if (company.isPresent()) {
            return calculateRiskForCompanyMatrix(company.get());
        }
        throw new NoSuchCompanyException(String.format(NO_COMPANY_ERROR, companyName));
    }

    private RiskMatrixEvaluation calculateRiskForCompanyMatrix(Company company) {
        List<List<String>> matrix = new ArrayList<>();
        company.getMatrixData().forEach(row -> {
            List<String> rowEvaluation = new ArrayList<>();
            row.forEach(value -> rowEvaluation.add(evaluateRiskForValue(value).toString()));
            matrix.add(rowEvaluation);
        });
        return new RiskMatrixEvaluation(matrix, company.getName());
    }

    private RiskEvaluation evaluateRiskForValue(double value) {
        if (isInvalidValue(value)) {
            throw new IllegalArgumentException(LESS_VALUE_ERROR);
        }
        for (EvaluationType evaluationType : EvaluationType.values()) {
            if (value < evaluationType.getUpperValue()) {
                return new RiskEvaluation(evaluationType, value);
            }
        }
        throw new IllegalArgumentException(GREATER_VALUE_ERROR);
    }

    private boolean isInvalidValue(double value) {
        return value < 0;
    }


}
