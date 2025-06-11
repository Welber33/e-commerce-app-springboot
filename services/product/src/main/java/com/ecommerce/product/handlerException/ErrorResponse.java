package com.ecommerce.product.handlerException;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
){}
