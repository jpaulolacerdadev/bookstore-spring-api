package com.bookstore.jpa.repositories;

import com.bookstore.jpa.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewModel, Long> {
}
