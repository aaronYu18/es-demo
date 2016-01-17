package com.badun.elsearchdemo.data.repo;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Created by Artsiom Badun.
 */
@NoRepositoryBean
public interface BaseRepo<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {
}
