package com.bancofuturo.usecase.model;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 3:45 PM
 *
 * @author David Rodriguez
 */
public enum EvaluationType {
    LOW("GREEN", 25),
    MEDIUM("YELLOW", 50),
    HIGH("ORANGE", 75),
    CRITIC("RED", 100);

    private String color;
    private double upperValue;

    EvaluationType(String color, double upperValue) {
        this.color = color;
        this.upperValue = upperValue;
    }

    public String getColor() {
        return color;
    }

    public double getUpperValue() {
        return upperValue;
    }

    @Override
    public String toString() {
        return "Risk Level: " + this.name() + "; Color Assigned: " + this.color;
    }
}
