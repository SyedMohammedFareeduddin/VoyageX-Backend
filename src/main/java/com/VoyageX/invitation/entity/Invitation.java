
package com.VoyageX.invitation.entity;

import com.VoyageX.common.entity.BaseEntity;
import com.VoyageX.invitation.enums.InvitationStatus;
import com.VoyageX.trip.entity.Trip;
import com.VoyageX.trip.enums.TripMemberRole;
import com.VoyageX.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "invitations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invitation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invited_by_user_id", nullable = false)
    private User invitedBy;

    @Column(name = "invitee_email",nullable = false, length = 150)
    private String inviteeEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "proposed_role", nullable = false, length = 20)
    private TripMemberRole proposedRole = TripMemberRole.VIEWER ;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private InvitationStatus status = InvitationStatus.PENDING ;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt ;

}
