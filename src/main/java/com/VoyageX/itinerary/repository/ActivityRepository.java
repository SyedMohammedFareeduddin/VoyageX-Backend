
package com.VoyageX.itinerary.repository;

import com.VoyageX.itinerary.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByItineraryIdOrderByDisplayOrderAsc ( Long itineraryId ) ;
    List<Activity> findByItineraryTripOrderByDisplayOrderAsc ( Long tripId ) ;

}
