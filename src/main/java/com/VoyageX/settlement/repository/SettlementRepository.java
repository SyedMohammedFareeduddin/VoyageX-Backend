
package com.VoyageX.settlement.repository;

import com.VoyageX.settlement.entity.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Long> {

    List<Settlement> findByTripIdOrderBySettlementAmountPaidDateDesc ( Long tripId ) ;
    List<Settlement> findByTripIdAndPayerId ( Long tripId , Long payerId ) ;
    List<Settlement> findByTripIdAndPayeeId ( Long tripId , Long payeeId ) ;

}
