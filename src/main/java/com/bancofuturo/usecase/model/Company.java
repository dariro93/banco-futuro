package com.bancofuturo.usecase.model;

import java.util.List;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 4:37 PM
 *
 * @author David Rodriguez
 */
public class Company {

    private String name;
    private List<List<Double>> matrixData;

    public Company(String name, List<List<Double>> matrixData) {
        this.name = name;
        this.matrixData = matrixData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<Double>> getMatrixData() {
        return matrixData;
    }

    public void setMatrixData(List<List<Double>> matrixData) {
        this.matrixData = matrixData;
    }
}
