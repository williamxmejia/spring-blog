package com.codeup.springblog.controller;

import com.codeup.springblog.model.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String allPosts(Model model){
        List<Post> allPosts = postDao.findAll();
        model.addAttribute("allPosts", allPosts);
        return "posts/index";
    }


    @GetMapping("/posts/index")
    public String indexPage(){
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model){
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String create(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreate(@ModelAttribute Post post){

                // save the ad...
        post.setUser(userDao.getById(1L)); //Go into the DB - get my one user hardcoded style :D
        emailService.prepareAndSend(post, "New Post was created", "Your new Post has been created on the Spring AdLister!");

        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String postPost(@ModelAttribute Post post){
        postDao.save(post);

        return "redirect:/posts";
    }

}
