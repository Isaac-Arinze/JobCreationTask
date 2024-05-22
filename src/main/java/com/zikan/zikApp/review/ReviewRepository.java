package com.zikan.zikApp.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {


//    void save(Review review, Long companyId);

    List<Review> findByCompanyId(Long companyId);
}

