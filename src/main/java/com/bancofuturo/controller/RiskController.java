package com.bancofuturo.controller;

import com.bancofuturo.usecase.exception.NoSuchCompanyException;
import com.bancofuturo.usecase.model.RiskMatrixEvaluation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 2:56 PM
 *
 * @author David Rodriguez
 */
@Api(value = "Risk Controller")
public interface RiskController {

    @ApiOperation(
            value = "Retrieve risk evaluation for company"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK", response = RiskMatrixEvaluation.class),
            }
    )
    RiskMatrixEvaluation evaluateRisk(@RequestParam String company) throws NoSuchCompanyException;

}
