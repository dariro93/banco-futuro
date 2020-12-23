package com.bancofuturo.controller.impl;

import com.bancofuturo.controller.RiskController;
import com.bancofuturo.usecase.exception.NoSuchCompanyException;
import com.bancofuturo.usecase.model.RiskMatrixEvaluation;
import com.bancofuturo.usecase.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 2:59 PM
 *
 * @author David Rodriguez
 */
@RestController
@RequestMapping("/risk")
public class RiskControllerImpl implements RiskController {

    private RiskService riskService;

    @Autowired
    public RiskControllerImpl(RiskService riskService) {
        this.riskService = riskService;
    }

    @GetMapping
    @Override
    public RiskMatrixEvaluation evaluateRisk(String company) throws NoSuchCompanyException {
        return riskService.calculateRisk(company);
    }

}
