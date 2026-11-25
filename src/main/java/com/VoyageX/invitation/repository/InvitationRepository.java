
package com.VoyageX.invitation.repository;

import com.VoyageX.invitation.entity.Invitation;
import com.VoyageX.invitation.enums.InvitationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InvitationRepository extends JpaRepository<Invitation, Integer> {

    List<Invitation> findByInviteeEmailIgnoreCase ( String inviteeEmail ) ;
    List<Invitation> findByTripId ( String tripId ) ;
    Optional<Invitation> findByIdAndInviteeEmailIgnoreCase ( Long id , String inviteeEmail ) ;
    boolean existsByTripIdAndInviteeEmailIgnoreCaseAndStatus (
            Long id ,
            String inviteeEmail ,
            InvitationStatus status ) ;

}
