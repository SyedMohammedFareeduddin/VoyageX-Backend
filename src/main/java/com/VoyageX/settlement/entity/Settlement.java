
package com.VoyageX.settlement.entity;

import com.VoyageX.common.entity.BaseEntity;
import com.VoyageX.expense.entity.Expense;
import com.VoyageX.trip.entity.Trip;
import com.VoyageX.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "settlements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Settlement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payer_id", nullable = false)
    private User payer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payee_id", nullable = false)
    private User payee;

    @Column(name = "settlement_amount", precision = 12, scale = 2, nullable = false)
    private BigDecimal settlementAmount;

    @Column(name = "settlement_amount_paid_date", nullable = false)
    private LocalDateTime settlementAmountPaidDate;

    @Column(name = "settlement_note", nullable = false, length = 500)
    private String settlementNote;

}
