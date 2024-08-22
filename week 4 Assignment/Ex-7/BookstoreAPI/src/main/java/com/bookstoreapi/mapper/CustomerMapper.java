package com.bookstoreapi.mapper;

import com.bookstoreapi.dto.CustomerDTO;
import com.bookstoreapi.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
}
