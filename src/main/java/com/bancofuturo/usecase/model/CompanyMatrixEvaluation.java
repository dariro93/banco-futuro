package com.bancofuturo.usecase.model;

import java.util.List;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 5:51 PM
 *
 * @author David Rodriguez
 */
public class CompanyMatrixEvaluation {

    private String name;
    private List<List<RiskEvaluation>> evaluationMatrix;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<RiskEvaluation>> getEvaluationMatrix() {
        return evaluationMatrix;
    }

    public void setEvaluationMatrix(List<List<RiskEvaluation>> evaluationMatrix) {
        this.evaluationMatrix = evaluationMatrix;
    }
}
