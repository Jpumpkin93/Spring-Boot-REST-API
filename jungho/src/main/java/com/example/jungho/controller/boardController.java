package com.example.jungho.controller;


import com.example.jungho.domain.Comment;
import com.example.jungho.domain.Post;
import com.example.jungho.repo.PostJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class boardController {

    @Autowired
    PostJpaRepo postJpaRepo;

    @GetMapping("/board")
    public String board(Model model) {
        List<Post> posts = postJpaRepo.findAll();
        Collections.reverse(posts);
        model.addAttribute("post", posts);
        return "board";
    }

    @GetMapping("/postDetail")
    public String postDetail(@RequestParam String number, Model model) {

//        int pno = Integer.parseInt(number);
//        Post post = postJpaRepo.findByNumber(pno);
//        model.addAttribute("pno", pno);
//        model.addAttribute("post", post);
//        List<Comment> comments = post.getComments();
//        model.addAttribute("comments", comments);

        return "redirect:/postDetail/" + number;
    }

    @GetMapping("/postDetail/{number}")
    public ModelAndView postDetail(@PathVariable("number") String number) {
        ModelAndView mav = new ModelAndView("postDetail");

        int pno = Integer.parseInt(number);
        Post post = postJpaRepo.findByNumber(pno);

        mav.addObject("post", post);
        return mav;
    }


}
