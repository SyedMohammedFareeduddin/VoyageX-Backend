package com.VoyageX.itinerary.repository;

import com.VoyageX.itinerary.entity.Itinerary;
import com.VoyageX.trip.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

    List<Itinerary> findByTripOrderByItineraryDateAsc ( Long tripId ) ;
    Optional<Itinerary> findByTripIdAndItineraryDate (Long tripId, Long itineraryDate ) ;
    boolean existsByTripIdAndItineraryDate ( Long tripId, LocalDateTime itineraryDate ) ;

}
