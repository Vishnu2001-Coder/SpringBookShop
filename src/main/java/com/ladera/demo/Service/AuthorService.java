package com.ladera.demo.Service;

import com.ladera.demo.Model.Author;
import com.ladera.demo.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        return authorRepository.findById(id).map(author -> {
            author.setName(updatedAuthor.getName());
            author.setEmail(updatedAuthor.getEmail());
            author.setBio(updatedAuthor.getBio());
            return authorRepository.save(author);
        }).orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}