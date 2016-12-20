package com.badun.elsearchdemo.web;

import com.badun.elsearchdemo.data.entity.UserAction;
import com.badun.elsearchdemo.service.UserActionService;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

/**
 * Created by Artsiom Badun.
 */
@RestController
@RequestMapping("/v1")
public class ApiController {

    @Autowired
    private UserActionService userActionService;


    @RequestMapping(value = "user", method = RequestMethod.GET)
    UserAction findUserAction(@RequestParam String actionId) {
        return userActionService.findUserAction(actionId);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    Iterable<UserAction> all() {
        return userActionService.findAll();
    }

    @RequestMapping(value = "user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    UserAction createUserAction(@RequestBody UserAction userAction) {
        return userActionService.createUserAction(userAction);
    }


    @RequestMapping(value = "user/{userId}")
    List<UserAction> createUserAction(@PathVariable String userId) {

        return null;
    }
}
