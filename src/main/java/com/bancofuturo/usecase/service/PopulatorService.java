package com.bancofuturo.usecase.service;

import com.bancofuturo.provider.exception.InvalidMatrixDataException;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 4:05 PM
 *
 * @author David Rodriguez
 */
public interface PopulatorService {

    void populateDataForCompany(String company) throws InvalidMatrixDataException;

}
