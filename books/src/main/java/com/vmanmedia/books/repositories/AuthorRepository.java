package com.vmanmedia.books.repositories;

import com.vmanmedia.books.entities.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository <Authors, Long> {
}
