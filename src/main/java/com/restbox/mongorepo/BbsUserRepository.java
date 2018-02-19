package com.restbox.mongorepo;

import com.restbox.model.BbsUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BbsUserRepository extends MongoRepository<BbsUser, String >{
}
