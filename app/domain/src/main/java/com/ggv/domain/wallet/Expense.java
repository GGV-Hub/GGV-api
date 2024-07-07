package com.ggv.domain.wallet;

import com.ggv.domain.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Expense extends BaseEntity {

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private double price;

    @Builder
    private Expense(Long userId, String description, String paymentMethod, double price) {
        this.userId = userId;
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.price = price;
    }
}
