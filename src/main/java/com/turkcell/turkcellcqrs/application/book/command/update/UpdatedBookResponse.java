package com.turkcell.turkcellcqrs.application.book.command.update;

import java.util.UUID;

public class UpdatedBookResponse {

    private UUID id;
    private String name;

    public UpdatedBookResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
