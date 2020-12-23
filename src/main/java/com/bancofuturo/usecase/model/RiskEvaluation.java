package com.bancofuturo.usecase.model;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 2:58 PM
 *
 * @author David Rodriguez
 */
public class RiskEvaluation {

    private EvaluationType evaluationType;
    private double value;

    public RiskEvaluation(EvaluationType evaluationType, double value) {
        this.evaluationType = evaluationType;
        this.value = value;
    }

    public EvaluationType getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(EvaluationType evaluationType) {
        this.evaluationType = evaluationType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return evaluationType.toString() + "; Risk value: " + value;
    }
}
