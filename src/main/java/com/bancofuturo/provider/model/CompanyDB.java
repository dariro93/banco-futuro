package com.bancofuturo.provider.model;

import javax.persistence.*;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 4:40 PM
 *
 * @author David Rodriguez
 */
@Entity
@Table(name = "companies")
public class CompanyDB {

    @Id
    @Column(name = "c_name")
    @Basic(optional = false)
    private String name;

    @Column(name = "c_matrix")
    @Basic(optional = false)
    private String matrixData;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatrixData() {
        return matrixData;
    }

    public void setMatrixData(String matrixData) {
        this.matrixData = matrixData;
    }
}
