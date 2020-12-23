package com.bancofuturo.usecase.model;

import java.util.List;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 3:45 PM
 *
 * @author David Rodriguez
 */
public class RiskMatrixEvaluation {

    private String company;
    private List<List<String>> matrix;

    public RiskMatrixEvaluation(List<List<String>> matrix, String company) {
        this.matrix = matrix;
        this.company = company;
    }

    public List<List<String>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<String>> matrix) {
        this.matrix = matrix;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
