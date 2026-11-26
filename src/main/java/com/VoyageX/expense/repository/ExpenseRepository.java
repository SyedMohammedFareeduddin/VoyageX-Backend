
package com.VoyageX.expense.repository;

import com.VoyageX.expense.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByTripIdOrderByExpensePaidDateDesc ( Long tripId ) ;
    Optional<Expense> findByIdAndTripId ( Long id , Long tripId ) ;
    List<Expense> findByPaidByAndTripId ( Long paidUserId , Long tripId ) ;

}
