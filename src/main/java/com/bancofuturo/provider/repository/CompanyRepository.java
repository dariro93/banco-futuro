package com.bancofuturo.provider.repository;

import com.bancofuturo.provider.model.CompanyDB;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by drodriguez
 * Date: 12/22/2020.
 * Time: 4:40 PM
 *
 * @author David Rodriguez
 */
public interface CompanyRepository extends CrudRepository<CompanyDB, String> {
}
