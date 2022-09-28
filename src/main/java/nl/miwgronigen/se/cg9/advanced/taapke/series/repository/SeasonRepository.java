package nl.miwgronigen.se.cg9.advanced.taapke.series.repository;

import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Season;
import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
