package org.fi.spring.resthibernate.repository;

import org.fi.spring.resthibernate.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
