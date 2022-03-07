package com.netcracker.edu.review.controller;

import com.netcracker.edu.review.model.Mark;
import com.netcracker.edu.review.model.Review;

import com.netcracker.edu.review.model.ui.UiReview;
import com.netcracker.edu.review.service.MarkService;
import com.netcracker.edu.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    public ReviewService reviewService;

    @Autowired
    public MarkService markService;

    @PostMapping("/add")
    public ResponseEntity<Review> createReview(@RequestBody UiReview uiReview) {
        Mark mark = markService.findMarkByValue(uiReview.getMark());
        return ResponseEntity.ok(reviewService.createReview(uiReview, mark));
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Review>> findReviewByAuthorId(@PathVariable("authorId") int authorId) {
        return ResponseEntity.ok(reviewService.findReviewByAuthorId(authorId));
    }
}
