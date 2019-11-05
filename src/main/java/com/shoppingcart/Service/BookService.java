package com.shoppingcart.Service;

import com.shoppingcart.domain.Book;
import com.shoppingcart.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
//new array list is for immuatble
    private List<Book> books= new ArrayList<>( Arrays.asList(
                new Book("101", "Java","Basic Book", 101),
                new Book("102", "C#", "Basic", 202)
        ));

        public List<Book> GetAllBooks()  // method to return books
    {
                return books;
    }

    public void addBook(Book book) {
            books.add(book);
    }

    public Book getBook(String id) {
        return books.stream().filter(t->t.getId().equals(id)).findFirst().get();
    }

    public void updateBook(String id, Book book) {

        for ( int i=0; i <books.size(); i++)
            {
                Book b=books.get(i);
                if (b.getId().equals(id))
                {
                    books.set(i,book);
                    return;
                }

            }
    }

    public void deleteBook(String id, Book book) {
            books.removeIf(b->b.getId().equals(id));
    }
}






