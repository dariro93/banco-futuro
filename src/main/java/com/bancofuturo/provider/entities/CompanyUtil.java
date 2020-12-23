package com.bancofuturo.provider.entities;

import com.bancofuturo.provider.model.CompanyDB;
import com.bancofuturo.usecase.model.Company;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 5:54 PM
 *
 * @author David Rodriguez
 */
public class CompanyUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private CompanyUtil() {

    }

    public static String castMatrixToString(List<List<Double>> matrixData) throws JsonProcessingException {
        return objectMapper.writeValueAsString(matrixData);
    }

    public static Company castCompanyDBToCompanyModel(CompanyDB companyDB) {
        try {
            return new Company(companyDB.getName(), objectMapper.readValue(companyDB.getMatrixData(), new TypeReference<List<List<Double>>>() {}));
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }

}
