
package com.VoyageX.trip.entity;

import com.VoyageX.trip.enums.TripMemberRole;
import com.VoyageX.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "trip_members" ,
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_trip_members_trip_user_id_and_trip_id" ,
                        columnNames = { "trip_id" , "user_id" }
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "trip_member_role", nullable = false, length = 20)
    private TripMemberRole tripMemberRole = TripMemberRole.VIEWER ;

    @Column(name = "joined_at",nullable = false)
    private LocalDateTime joinedAt;

}
