package com.shoppingcart.Service;

import com.shoppingcart.domain.Book;
import com.shoppingcart.domain.BookRepository;
import com.shoppingcart.domain.CD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CDService {

   // @Autowired
   // private BookRepository bookRepository;
    //new array list is for immuatble
    private List<CD> cds= new ArrayList<>( Arrays.asList(
            new CD("10001", "Core Java","Advance  Book", 1000),
            new CD("10002", " Core C#", "Advance", 20000)
    ));

    public List<CD> GetAllCD()  // method to return books
    {
        return cds;
    }

    public void addCD(CD cd) {
        cds.add(cd);
    }

    public CD getCD(String id) {
        return cds.stream().filter(t->t.getId().equals(id)).findFirst().get();
    }

    public void updateCD(String id, CD cd) {

        for ( int i=0; i <cds.size(); i++)
        {
            CD b=cds.get(i);
            if (b.getId().equals(id))
            {
                cds.set(i,cd);
                return;
            }

        }
    }

    public void deleteCD(String id,CD cd) {
        cds.removeIf(b->b.getId().equals(id));
    }
}


