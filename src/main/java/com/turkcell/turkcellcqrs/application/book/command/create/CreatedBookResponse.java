package com.turkcell.turkcellcqrs.application.book.command.create;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

/* eklediğim kitabın bilgileri şunlardır.... şeklinde bir dönüş almak için
* yani CREATE işlemine ait DTO burada!
* */

public class CreatedBookResponse {
    private UUID id;
    private String name;

//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
