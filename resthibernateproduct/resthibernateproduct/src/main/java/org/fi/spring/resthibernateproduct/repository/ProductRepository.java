package org.fi.spring.resthibernateproduct.repository;

import org.fi.spring.resthibernateproduct.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
