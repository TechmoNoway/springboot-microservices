package com.trikynguci.orderservice.dto.response;

import com.trikynguci.orderservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long orderId;
    private String product;
    private Double price;
    private UserDto user;
}
