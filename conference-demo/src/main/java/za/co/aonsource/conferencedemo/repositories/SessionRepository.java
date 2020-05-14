package za.co.aonsource.conferencedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.aonsource.conferencedemo.models.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
}
