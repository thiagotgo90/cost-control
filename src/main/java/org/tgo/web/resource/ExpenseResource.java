package org.tgo.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tgo.domain.Expense;
import org.tgo.service.ExpenseService;

@RestController
public class ExpenseResource {

    @Autowired
    private ExpenseService service;

    @RequestMapping(value = "/expense", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Object> getAll() {
        List<Expense> expenses = service.getAll();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @RequestMapping(value = "/expense", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody Expense expense) {
        service.save(expense);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
