package com.unemployed.ltnam.Mapper;

import com.unemployed.ltnam.DTO.BookDTO.BookDTO;
import com.unemployed.ltnam.Entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
//    @Mapping(target = "id", ignore = true)
    @Mapping(target = "id", ignore = true)
    Book toBook(BookDTO bookDTO);

    
    @Mapping(target = "id", ignore = true)
    Book toUpdateBook(BookDTO newBook, @MappingTarget Book oldBook);
}