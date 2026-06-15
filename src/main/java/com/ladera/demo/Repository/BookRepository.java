package com.ladera.demo.Repository;

import com.ladera.demo.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Custom queries if needed
    List<Book> findByAuthorId(Long authorId);         // Get books by author
    List<Book> findByTitleContaining(String keyword); // Search by title
}
