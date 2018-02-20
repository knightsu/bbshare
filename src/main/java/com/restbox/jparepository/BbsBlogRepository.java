package com.restbox.jparepository;

import com.restbox.model.BbsBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BbsBlogRepository extends JpaRepository<BbsBlog, Long>{
    BbsBlog findBbsBlogById(long blogId);
}
