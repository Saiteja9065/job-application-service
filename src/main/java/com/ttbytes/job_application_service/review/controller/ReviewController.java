package com.ttbytes.job_application_service.review.controller;

import com.ttbytes.job_application_service.review.model.Review;
import com.ttbytes.job_application_service.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/getReviews")
    public ResponseEntity<List<Review>> getAllReviewsByCompanyId(@PathVariable Long companyId){
        List<Review> companyReviews = reviewService.getAllReviews(companyId);
        return new ResponseEntity<>(companyReviews, HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> postReviewOnCompany(@PathVariable Long companyId, @RequestBody Review review){
        boolean reviewSaved = reviewService.addReview(companyId, review);
        if(reviewSaved) {
            return new ResponseEntity<>("Review added succesfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review not saved successfully", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId,reviewId),HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,
                                               @RequestBody Review updateReview){
        boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId, updateReview);
        if(isReviewUpdated){
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review not updated successfully", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReview(companyId, reviewId);
        if(isReviewDeleted){
            return new ResponseEntity<>("Review deleted successfuly", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review not found for company", HttpStatus.NOT_FOUND);
        }
    }
}
