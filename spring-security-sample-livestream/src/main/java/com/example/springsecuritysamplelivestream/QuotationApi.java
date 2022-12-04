package com.example.springsecuritysamplelivestream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuotationApi {

    private List<Quotation> quotations;

    public QuotationApi() {
        this.quotations = new ArrayList<>();
        quotations.add(new Quotation("aaaaaaaaaaaaaa", "Eduard"));
        quotations.add(new Quotation("bbbbbbbbbbbbbb", "Beatrice"));
        quotations.add(new Quotation("cccccccccccccc", "Maxymilian"));
    }

    @GetMapping("/api")
//    @RequestMapping(method = RequestMethod.GET, name = "/api")
    public List<Quotation> getQuotations() {
      return quotations;
    }

    @PostMapping("/api")
    public Boolean addQuotation(@RequestBody Quotation quotation) {
        return quotations.add(quotation);
    }

    // http://localhost:8080/api/?index=0
    @DeleteMapping("/api")
    public void delQuotation(@RequestParam int index) {
        quotations.remove(index);
    }

}
