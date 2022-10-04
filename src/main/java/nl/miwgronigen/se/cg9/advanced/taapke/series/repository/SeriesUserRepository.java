package nl.miwgronigen.se.cg9.advanced.taapke.series.repository;

import nl.miwgronigen.se.cg9.advanced.taapke.series.model.SeriesUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeriesUserRepository extends JpaRepository<SeriesUser, Long> {
    Optional<SeriesUser> findByUsername(String username);
}
