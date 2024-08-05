package com.atilio.pruebalinktic.repository;

import com.atilio.pruebalinktic.entity.Premiums;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PremiumRepository extends CrudRepository<Premiums, Integer> {
    List<Premiums> findByMinAgeLessThanEqualAndMaxAgeGreaterThanEqual(int customerAge, int customerAge2);
}