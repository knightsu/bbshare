package com.restbox.mongorepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Map;

public class BbsUserRepositoryImpl implements UserChange{
    @Autowired
    MongoOperations mongoOperations;

    @Override
    public void updateUserProfile(Map<String, String> map, String username) {

        Criteria where = Criteria.where("username").is(username);
        Query query = Query.query(where);
        Update update = new Update();
        map.keySet().forEach((p) -> update.set(p, map.get(p)));
        mongoOperations.updateMulti(query, update, "blog");
    }

    @Override
    public void updateUserCoins(String username, long coin) {
        Criteria where = Criteria.where("username").is(username);
        Query query = Query.query(where);
        Update update = new Update();
        mongoOperations.updateMulti(query, update.set("coins", coin), "blog");
    }
}
