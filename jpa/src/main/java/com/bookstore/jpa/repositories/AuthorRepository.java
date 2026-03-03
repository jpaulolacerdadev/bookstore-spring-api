package com.bookstore.jpa.repositories;

import com.bookstore.jpa.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {


}
