
package com.VoyageX.itinerary.entity;

import com.VoyageX.trip.entity.Trip;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "itineraries" ,
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_itineraries_trip_date",
                        columnNames = { "trip_id" , "itinerary_date" }
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Column(name = "itinerary_data", nullable = false)
    private LocalDateTime itineraryDate;

    @Column(nullable = false)
    private String notes;

}
