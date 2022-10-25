package ch.survalit.books.boundary;

import ch.survalit.books.control.BookStore;
import ch.survalit.books.entity.Book;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("book")
public class BookResource {

    @Inject
    BookStore bookStore;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBook(Book book) {
        this.bookStore.persistBook(book);

        // after POSTing something successful, return 204
        return Response.noContent().build();
    }
}
