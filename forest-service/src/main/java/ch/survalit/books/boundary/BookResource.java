package ch.survalit.books.boundary;

import ch.survalit.books.control.BookStore;
import ch.survalit.books.entity.Book;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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

    @GET
    @Path("{author}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBookByAuthor(@PathParam("author") String author) {
        return this.bookStore.findByAuthor(author);
    }
}
