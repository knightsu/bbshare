package com.restbox.jparepository;

import com.restbox.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    @Query("select c from Comment c where c.bbsBlog.id = ?1 ")
    Collection<Comment> findByBbsBlogIdAndPagenum(long blogId, int start);
}
