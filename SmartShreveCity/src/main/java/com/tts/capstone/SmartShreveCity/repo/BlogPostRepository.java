package com.tts.capstone.SmartShreveCity.repo;
import com.tts.capstone.SmartShreveCity.model.BlogPost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository  extends CrudRepository<BlogPost, Long> {


    @Query(value = "SELECT * from BLOG_POST where TITLE LIKE ?1 OR AUTHOR LIKE ?1 OR BLOG_ENTRY LIKE ?1", nativeQuery = true)
    public List<BlogPost> search(String keyword);
}
