package io.mahesh.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/")
    public List<Author> GetAuthors() {
        return authorRepository.findAll();
    }
    @GetMapping("/{id}")
    public Author GetAuthor(@PathVariable String id) {
        return authorRepository.findById(id).orElse(null);
    }
    @PostMapping("/")
    public Author PostAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }
    @PutMapping("/")
    public Author PutAuthor(@RequestBody Author author) {
        Author oldAuthor = authorRepository.findById(author.getId().toString()).orElse(null);
        oldAuthor.setFirstName(author.getFirstName());
        oldAuthor.setLastName(author.getLastName());
        oldAuthor.setBooks(author.getBooks());
        return authorRepository.save(oldAuthor);
    }
    @DeleteMapping("/{id}")
    public String DeleteAuthor(@PathVariable String id) {
        authorRepository.deleteById(id);
        return id;
    }
}