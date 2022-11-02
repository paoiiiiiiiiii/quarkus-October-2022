package ch.survalit.books.control;

import ch.survalit.books.entity.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookStore {

    @Inject
    EntityManager em;

    @Transactional
    public void persistBook(Book book) {
        this.em.persist(book);
    }

    public List<Book> findByAuthor(String author) {
        return this.em.createNamedQuery("findByAuthor", Book.class)
                .setParameter("author", author)
                .getResultList();
    }
}
