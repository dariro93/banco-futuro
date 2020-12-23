package com.bancofuturo.usecase.service;

import com.bancofuturo.usecase.exception.NoSuchCompanyException;
import com.bancofuturo.usecase.model.RiskEvaluation;
import com.bancofuturo.usecase.model.RiskMatrixEvaluation;

import java.util.List;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 3:09 PM
 *
 * @author David Rodriguez
 */
public interface RiskService {

    RiskMatrixEvaluation calculateRisk(String companyName) throws NoSuchCompanyException;

}
