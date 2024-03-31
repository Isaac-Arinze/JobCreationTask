package com.zikan.zikApp.review;

import java.util.List;

public interface ReviewService {

   boolean addReview(Long companyId, Review review);

   List<Review> getAllReviews(Long companyId);

   Review getReview(Long companyId, Long reviewId);

   boolean updateReview(Long companyId, Long reviewId, Review review);
}
