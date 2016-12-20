package com.badun.elsearchdemo.data.repo;

import com.badun.elsearchdemo.data.entity.UserAction;

import org.springframework.data.elasticsearch.annotations.Query;

import java.util.List;

/**
 * Created by Artsiom Badun.
 */
public interface UserActionRepo extends BaseRepo<UserAction, String> {
    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"username\" : \"?0\"}}}}")
    List<UserAction> findByUserId(String userId);
}
