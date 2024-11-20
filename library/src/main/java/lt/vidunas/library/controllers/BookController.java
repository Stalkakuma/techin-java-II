package lt.vidunas.library.controllers;

import jakarta.validation.Valid;
import lt.vidunas.library.dto.BookCreationDTO;
import lt.vidunas.library.entities.Book;
import lt.vidunas.library.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin("*")
@Validated
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody BookCreationDTO bookCreationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookService.addBook(bookCreationDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody BookCreationDTO bookCreationDTO) {
            return ResponseEntity.ok(bookService.updateBook(id, bookCreationDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book successfully deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        return ResponseEntity.ok(book);
    }
}
