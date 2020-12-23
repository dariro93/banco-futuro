package com.bancofuturo.controller.impl;

import com.bancofuturo.controller.CompanyController;
import com.bancofuturo.provider.exception.InvalidMatrixDataException;
import com.bancofuturo.usecase.service.PopulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 6:20 PM
 *
 * @author David Rodriguez
 */
@RestController
@RequestMapping("/company")
public class CompanyControllerImpl implements CompanyController {

    private PopulatorService populatorService;

    @Autowired
    public CompanyControllerImpl(PopulatorService populatorService) {
        this.populatorService = populatorService;
    }

    @PostMapping(consumes = "text/plain")
    @Override
    public void createCompany(String companyName) throws InvalidMatrixDataException {
        populatorService.populateDataForCompany(companyName);
    }

}
