package com.ggv.domain.wallet;

import com.ggv.domain.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class UserExpense extends BaseEntity {

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Instant dateTime;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private String category;

    @Column()
    private String memo;

    @Builder
    private UserExpense(Long userId, String title, Instant dateTime, double price, String paymentMethod,
                        String category,
                        String memo) {
        this.userId = userId;
        this.title = title;
        this.dateTime = dateTime;
        this.price = price;
        this.paymentMethod = paymentMethod;
        this.category = category;
        this.memo = memo;
    }
}
