package com.bancofuturo.controller;

import com.bancofuturo.provider.exception.InvalidMatrixDataException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 6:17 PM
 *
 * @author David Rodriguez
 */
@Api(value = "Company controller")
public interface CompanyController {

    @ApiOperation(
            value = "Create a company with random generated data"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK")
            }
    )
    void createCompany(@RequestBody String companyName) throws InvalidMatrixDataException;

}
