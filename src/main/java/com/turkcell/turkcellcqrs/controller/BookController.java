package com.turkcell.turkcellcqrs.controller;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.turkcellcqrs.application.book.command.create.CreateBookCommand;
import com.turkcell.turkcellcqrs.application.book.command.create.CreatedBookResponse;
import com.turkcell.turkcellcqrs.application.book.command.update.UpdateBookCommand;
import com.turkcell.turkcellcqrs.application.book.command.update.UpdatedBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final Pipeline pipeline;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedBookResponse create(@RequestBody CreateBookCommand createBookCommand){
        return createBookCommand.execute(pipeline);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public UpdatedBookResponse update(@RequestBody UpdateBookCommand updateBookCommand){
        return updateBookCommand.execute(pipeline);
    }
}
