package mk.ukim.finki.emt.librarymodule.config;

import mk.ukim.finki.emt.librarymodule.model.Author;
import mk.ukim.finki.emt.librarymodule.model.Book;
import mk.ukim.finki.emt.librarymodule.model.Category;
import mk.ukim.finki.emt.librarymodule.model.Country;
import mk.ukim.finki.emt.librarymodule.service.AuthorService;
import mk.ukim.finki.emt.librarymodule.service.BookService;
import mk.ukim.finki.emt.librarymodule.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void init() {
        Country country1 = new Country((long)1,"North Macedonia", "Europe");
        countryService.save(country1);
        countryService.save("Albania", "Europe");
        countryService.save("Canada", "North America");
        countryService.save("Chile", "South America");
        countryService.save("Germany", "Europe");

        Author author1 = new Author((long)1,"Slavko", "Janevski", country1);
        authorService.save(author1);

        bookService.save("Seloto zad sedumte jaseni", Category.NOVEL, author1.getId(), 15);
    }
}
