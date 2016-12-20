package com.badun.elsearchdemo.service;

import com.badun.elsearchdemo.data.entity.UserAction;
import com.badun.elsearchdemo.data.repo.UserActionRepo;

import org.elasticsearch.action.search.SearchAction;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.elasticsearch.index.query.QueryBuilders.termQuery;

/**
 * Created by Artsiom Badun.
 */
@Service
public class UserActionService {

    @Autowired
    private UserActionRepo userActionRepo;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public Iterable<UserAction> findAll() {
        return userActionRepo.findAll();
    }
    public UserAction findUserAction(String actionId) {
        return userActionRepo.findOne(actionId);
    }

    public UserAction createUserAction(UserAction userAction) {
        userAction.setActionId(userAction.getActionId());
        userAction.setTimestamp("");
        userActionRepo.save(userAction);
        return userAction;
    }

    public List<UserAction> findByUserId(String userId) {
        return userActionRepo.findByUserId(userId);
    }
    public List<UserAction> findByUsername(String username) {
       /* Client client = elasticsearchTemplate.getClient();
        SearchRequestBuilder builder = new SearchRequestBuilder(client, new SearchAction().)SearchRequest.QueryBuilders.nestedQuery("username", QueryBuilders.boolQuery().must(termQuery("username", username)));
        QueryBuilder builder1=QueryBuilders.boolQuery().must(builder);
        return client.search(new SearchRequest());*/
       return null;
    }
}
