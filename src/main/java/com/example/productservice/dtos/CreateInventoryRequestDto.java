package com.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInventoryRequestDto {
    private String productId;
    private int quantity;
}
