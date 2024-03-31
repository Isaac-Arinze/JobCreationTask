package com.zikan.zikApp.review.impi;

import com.zikan.zikApp.company.Company;
import com.zikan.zikApp.company.CompanyService;
import com.zikan.zikApp.review.Review;
import com.zikan.zikApp.review.ReviewRepository;
import com.zikan.zikApp.review.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    private final CompanyService companyService;



    public reviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
          Company company = companyService.getCompanyById(companyId);
          if (company != null){
             review.setCompany(company);
             reviewRepository.save(review);
             return true;
          }
          else {
              return false;
          }
    }
    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =  reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {

        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewsId, Review updatedReview) {

        if (companyService.getCompanyById(companyId) != null){
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewsId);
            reviewRepository.save(updatedReview);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {

        if (companyService.getCompanyById(companyId) != null
                && reviewRepository.existsById(reviewId)) {
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompanies(companyId, company);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        else {
            return false;
        }
    }
}

