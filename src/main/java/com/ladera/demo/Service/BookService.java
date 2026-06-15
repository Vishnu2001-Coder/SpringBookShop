package com.ladera.demo.Service;

import com.ladera.demo.Model.Book;
import com.ladera.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // GET ALL
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // GET BY ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // GET BY AUTHOR
    public List<Book> getBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    // SEARCH BY TITLE
    public List<Book> searchBooks(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }

    // CREATE
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // UPDATE
    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setIsbn(updatedBook.getIsbn());
            book.setPrice(updatedBook.getPrice());
            book.setStock(updatedBook.getStock());
            book.setPublishedDate(updatedBook.getPublishedDate());
            book.setAuthor(updatedBook.getAuthor());
            book.setCategories(updatedBook.getCategories());
            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    // DELETE
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}