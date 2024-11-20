package lt.vidunas.library;

import lt.vidunas.library.repositories.BookRepository;
import lt.vidunas.library.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class LibraryApplicationTests {

	@MockBean
	private BookRepository bookRepository;

	@Autowired
	private BookService bookService;


	//TODO learn context
	@Test
	void contextLoads() {
	}


}
