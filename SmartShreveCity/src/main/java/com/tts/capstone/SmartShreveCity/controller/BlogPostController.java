package com.tts.capstone.SmartShreveCity.controller;
import com.tts.capstone.SmartShreveCity.model.BlogPost;
import com.tts.capstone.SmartShreveCity.repo.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogPostController {


    @Autowired
    private BlogPostRepository blogPostRepository;
    private static List<BlogPost> posts = new ArrayList<>();
    @GetMapping(value = "/")
    public String index(BlogPost blogPost, Model model){
        //because we are utilizing thymeleaf
        //our output will be generated in a template
        //returning a reference to that template
        //will allow us to show the data that we want
        model.addAttribute("posts", posts);
        return "blogpost/index";
    }

    private BlogPost blogPost;

    @PostMapping(value = "/blogpost")
    public String addNewBlogPost(BlogPost blogPost, Model model) {
        blogPostRepository.save(blogPost);
        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        return "blogpost/result";
    }
    @GetMapping(value="/blogpost/new")
    public String newBlog(BlogPost blogpost){
        return "blogpost/CreatePost";
    }


    @RequestMapping(value = "/blogposts/{id}", method = RequestMethod.DELETE)
    public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {

        blogPostRepository.deleteById(id);
        return "blogpost/index";

    }


    @RequestMapping(value = "/blogposts/{id}", method = RequestMethod.GET)
    public String editPostWithId(@PathVariable Long id, BlogPost blogPost, Model model) {
        Optional<BlogPost> post = blogPostRepository.findById(id);
        if (post.isPresent()) {
            BlogPost actualPost = post.get();
            model.addAttribute("blogPost", actualPost);
        }
        return "blogpost/edit";




    }

}
