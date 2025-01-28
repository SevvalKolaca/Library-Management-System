package com.turkcell.turkcellcqrs.application.book.command.update;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.persistance.book.BookRepository;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UpdateBookCommand implements Command<UpdatedBookResponse>
{
    private String name;
    private UUID id;

    @Component
    public static class UpdateBookCommandaHandler implements Command.Handler<UpdateBookCommand, UpdatedBookResponse>{

        private final BookRepository bookRepository;

        public UpdateBookCommandaHandler(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

        @Override
        public UpdatedBookResponse handle(UpdateBookCommand updateBookCommand) {
            Book book = bookRepository
                    .findById(updateBookCommand.getId())
                    .orElseThrow(()-> new RuntimeException("Book not found!"));
            book.setName(updateBookCommand.getName());
            bookRepository.save(book);
            return new UpdatedBookResponse(book.getId(), book.getName());
        }
    }
}
