package com.shoppingcart.Controller;

import com.shoppingcart.Service.BookService;
import com.shoppingcart.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
private BookService bookService;
@RequestMapping("/books")
@ResponseBody
    public List<Book> GetAllBooks()
{
    return bookService.GetAllBooks();
}
@RequestMapping ("/books/{id}")
@ResponseBody

        public Book getBook(@PathVariable String id )
{
return  bookService.getBook(id);
}

@RequestMapping(method=RequestMethod.POST , value ="/books")
public  void addBook (@RequestBody Book book)
{
    bookService.addBook(book);
}

@RequestMapping(method=RequestMethod.PUT, value ="/books/{id}")
public void updateBook(@RequestBody Book book , @PathVariable String id)
{
    bookService.updateBook(id, book);

}

    @RequestMapping(method=RequestMethod.DELETE, value ="/books/{id}")
    public void deleteBook(@RequestBody Book book , @PathVariable String id)
    {
        bookService.deleteBook(id, book);

    }

}
