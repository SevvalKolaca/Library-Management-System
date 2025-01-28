package com.turkcell.turkcellcqrs.application.book.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.persistance.book.BookRepository;
import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
/* command arayüzü, pipeline icin gerekli bir yapı */
public class CreateBookCommand implements Command<CreatedBookResponse>
{
    //@NotBlank //TODO: validasyon ekle!!!
    private String name;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    /* sistem tarafından tanınabilmesi için component olmalı*/
    @Component
    @RequiredArgsConstructor // final ile isaretlenmis degiskenlerden bir const. olusturur
    public static class CreateBookCommandHandler implements Command.Handler<CreateBookCommand, CreatedBookResponse>
    {
        private final BookRepository bookRepository;

        @Override
        public CreatedBookResponse handle(CreateBookCommand createBookCommand){

            // mapping: CreateBookCommand -> Book
            Book book = new Book();
            book.setName(createBookCommand.getName());
            bookRepository.save(book);

            CreatedBookResponse createdBookResponse = new CreatedBookResponse(book.getId(),book.getName());
            return createdBookResponse;
        }

    }
}


