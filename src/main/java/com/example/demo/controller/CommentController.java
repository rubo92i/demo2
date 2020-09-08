package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.model.exceptions.NotFoundException;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {


    @Autowired
    private CommentService commentService;


    @GetMapping
    public ResponseEntity get(@RequestParam int userId) throws NotFoundException {
        List<Comment> comments = commentService.getByUserId(userId);
        return ResponseEntity.ok(comments);
    }
}
