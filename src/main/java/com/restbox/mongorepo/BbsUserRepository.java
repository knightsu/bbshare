package com.restbox.mongorepo;

import com.restbox.model.BbsUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BbsUserRepository extends MongoRepository<BbsUser, String >{
    BbsUser findBbsUserByUsername(String username);
}
