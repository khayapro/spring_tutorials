package za.co.aonsource.conferencedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.aonsource.conferencedemo.models.Speaker;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
