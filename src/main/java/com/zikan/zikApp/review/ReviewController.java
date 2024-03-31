package com.zikan.zikApp.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;
import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {

    private  final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping("/review")
    public ResponseEntity <String> addReviews (@PathVariable Long companyId, @RequestBody Review review){

        boolean isReviewSaved = reviewService.addReview(companyId, review);

        if(isReviewSaved) {

            return new ResponseEntity<>("Review has been successfully added", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Review has been successfully added", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/reviws")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public  ResponseEntity <Review> getReview (@PathVariable Long companyId,
                                               @PathVariable Long reviewId){

        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);

    }

    @PutMapping("reviews/{reviewsId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                         @PathVariable Long reviewId,
                                         @RequestBody Review review){

        boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId, review);

        if(isReviewUpdated) {
            return new ResponseEntity<>("Review successfully updated", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Review not found and updated", HttpStatus.NOT_FOUND);
        }

    }
}