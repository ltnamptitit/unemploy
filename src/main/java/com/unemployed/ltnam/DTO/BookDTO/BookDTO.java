package com.unemployed.ltnam.DTO.BookDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDTO {
    private String name;
    private int price;
    private int is_available;
    private String author;
    private String publisher;
    private String genre;
    private int stock_quantity;
    private String description;
}
