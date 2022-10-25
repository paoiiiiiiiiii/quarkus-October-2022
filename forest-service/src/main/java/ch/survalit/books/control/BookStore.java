package ch.survalit.books.control;

import ch.survalit.books.entity.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class BookStore {

    @Inject
    EntityManager em;

    @Transactional
    public void persistBook(Book book) {
        em.persist(book);
    }
}
