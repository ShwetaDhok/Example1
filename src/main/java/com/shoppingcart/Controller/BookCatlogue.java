package com.shoppingcart.Controller;

import com.shoppingcart.domain.Book;
import com.shoppingcart.domain.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookCatlogue {
@Autowired
    private RestTemplate restTemplate;
@Autowired
private WebClient.Builder  webClientBuilder;
    @RequestMapping("/{id}")
    public List<Book> getCatlogue(@PathVariable String Id) {
        List<Rating> ratings = new ArrayList<>( Arrays.asList(new Rating("101", 1),
                (new Rating("102", 4)
        )));
        return ratings.stream().map(rating-> {

           // Book book =restTemplate.getForObject("http://localhost:8080/books"+ rating.getId(), Book.class);

              Book book=   webClientBuilder.build()// instance of builder giving you client
                                .get()
        .uri("\"http://localhost:8080/books/101\"+ rating.getId()")
        .retrieve()
        .bodyToMono(Book.class)
        .block() ; //fetch me data

                    return new Book(book.getName(), book.getDescription(), book.getPrice(),book.getId(),rating.getRating());
        })
        .collect(Collectors.toList());
    }
}

