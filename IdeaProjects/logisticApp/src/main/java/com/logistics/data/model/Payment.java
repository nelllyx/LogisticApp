package com.logistics.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("payment")

public class Payment {
    private String id;
    private String dispatchId;
    private boolean hasPaid;
}
