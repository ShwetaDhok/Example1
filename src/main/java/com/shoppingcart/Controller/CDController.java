package com.shoppingcart.Controller;

import com.shoppingcart.Service.BookService;
import com.shoppingcart.Service.CDService;
import com.shoppingcart.domain.Book;
import com.shoppingcart.domain.CD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CDController {

    @Autowired
    private CDService cdService;

    @RequestMapping("/cds")
    @ResponseBody
    public List<CD> GetAllCD() {
        return cdService.GetAllCD();
    }

    @RequestMapping("/cds/{id}")
    @ResponseBody

    public CD getCD(@PathVariable String id) {
        return cdService.getCD(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cds")
    public void addCD(@RequestBody CD cd) {
        cdService.addCD(cd);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/cds/{id}")
    public void updateCD(@RequestBody CD cd, @PathVariable String id) {
        cdService.updateCD(id, cd);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cds/{id}")
    public void deleteCD(@RequestBody CD cd, @PathVariable String id) {
        cdService.deleteCD(id, cd);

    }


}
