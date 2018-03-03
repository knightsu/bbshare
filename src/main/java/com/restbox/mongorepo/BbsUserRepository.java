package com.restbox.mongorepo;

import com.restbox.model.BbsUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BbsUserRepository extends MongoRepository<BbsUser, String>, UserChange{
    List<BbsUser> findBbsUserByUsername(String username);
}
