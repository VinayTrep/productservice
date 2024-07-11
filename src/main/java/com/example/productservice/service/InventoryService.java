package com.example.productservice.service;

import com.example.productservice.dtos.CreateInventoryRequestDto;
import com.example.productservice.dtos.InventoryResponseDto;
import com.example.productservice.exception.ProductNotFoundException;

import java.util.UUID;

public interface InventoryService {
    public InventoryResponseDto updateInventory(CreateInventoryRequestDto requestDto) throws ProductNotFoundException;
    public InventoryResponseDto getInventory(UUID productId) throws ProductNotFoundException;
    public void deleteInventory(UUID productId) throws ProductNotFoundException;
}
