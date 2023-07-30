package com.irfangerard.agit.Controller;

import com.irfangerard.agit.model.*;
import com.irfangerard.agit.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService serv;

    @Operation(summary = "get all book when filter is optimal")
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllBook(@RequestParam(required = false) String status){
        MessageModel msg = new MessageModel();
        List<DAOBook> data = serv.findBook(status);
        if(data != null){
            msg.setData(data);
            msg.setMessage("success");
            msg.setStatus(true);
            return ResponseEntity.ok(msg);
        } else {
            msg.setData("");
            msg.setMessage("failed");
            msg.setStatus(false);
            return ResponseEntity.ok().body(msg);
        }
    }

    @Operation(summary = "insert book")
    @PostMapping(produces = "application/json")
    public ResponseEntity<?> insertBook(@RequestBody createBookModel cBM) throws ParseException {
        MessageModel msg = new MessageModel();
        boolean data = serv.createBook(cBM);
        if(data){
            msg.setData(data);
            msg.setMessage("success");
            msg.setStatus(true);
            return ResponseEntity.ok(msg);
        } else {
            msg.setData("");
            msg.setMessage("failed");
            msg.setStatus(false);
            return ResponseEntity.ok().body(msg);
        }
    }

    @Operation(summary = "update book")
    @PostMapping(value = "/update-book",produces = "application/json")
    public ResponseEntity<?> update_Book(@RequestBody updateBukuModel cBM) throws ParseException {
        MessageModel msg = new MessageModel();
        boolean data = serv.updateBook(cBM);
        if(data){
            msg.setData(data);
            msg.setMessage("success");
            msg.setStatus(true);
            return ResponseEntity.ok(msg);
        } else {
            msg.setData("");
            msg.setMessage("failed");
            msg.setStatus(false);
            return ResponseEntity.ok().body(msg);
        }
    }

    @Operation(summary = "borrow book")
    @PostMapping(value = "/borrow-book",produces = "application/json")
    public ResponseEntity<?> borrow_Book(@RequestBody pinjamBukuModel cBM) throws ParseException {
        MessageModel msg = new MessageModel();
        boolean data = serv.pinjamBuku(cBM);
        if(data){
            msg.setData(data);
            msg.setMessage("success");
            msg.setStatus(true);
            return ResponseEntity.ok(msg);
        } else {
            msg.setData("");
            msg.setMessage("failed");
            msg.setStatus(false);
            return ResponseEntity.ok().body(msg);
        }
    }
    @Operation(summary = "borrow book")
    @DeleteMapping(produces = "application/json")
    public  ResponseEntity<?> deleteBook(@RequestParam String id){
        MessageModel msg = new MessageModel();
        boolean data = serv.deleteBook(id);
        if(data){
            msg.setData(data);
            msg.setMessage("success");
            msg.setStatus(true);
            return ResponseEntity.ok(msg);
        } else {
            msg.setData("");
            msg.setMessage("failed");
            msg.setStatus(false);
            return ResponseEntity.ok().body(msg);
        }
    }

}
