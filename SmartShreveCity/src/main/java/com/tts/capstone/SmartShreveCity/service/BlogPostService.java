package com.tts.capstone.SmartShreveCity.service;
import com.tts.capstone.SmartShreveCity.model.BlogPost;
import com.tts.capstone.SmartShreveCity.repo.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlogPostService {
    @Autowired
    private BlogPostRepository repo;

    public void addBlogPost(BlogPost blogPost){
        repo.save(blogPost);
    }

    public List<BlogPost> listAll(){
        return (List<BlogPost>)
                repo.findAll();
    }

    public List<BlogPost> searchByKeyword(String keyword){
        return repo.search(keyword);
    }

    public Optional<BlogPost> findById(Long id){
        return repo.findById(id);
    }

    public BlogPost getBlogPost(Long id){
        return repo.findById(id).get();
    }

    public void deleteBlogPost(Long id){
        repo.deleteById(id);
    }


}
