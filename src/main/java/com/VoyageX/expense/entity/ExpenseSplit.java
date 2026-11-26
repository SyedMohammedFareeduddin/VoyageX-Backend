
package com.VoyageX.expense.entity;

import com.VoyageX.common.entity.BaseEntity;
import com.VoyageX.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(
        name = "expenses_split" ,
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_expenses_split_users" ,
                        columnNames = { "expense_id" , "user_id" }
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseSplit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "expense_id", nullable = false)
    private Expense expense;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "split_amount", precision = 12, scale = 2, nullable = false)
    private BigDecimal splitAmount;

}
