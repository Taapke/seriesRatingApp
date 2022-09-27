package nl.miwgronigen.se.cg9.advanced.taapke.series.repository;

import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

public interface SeriesRepository extends JpaRepository<Series, Long> {
    Optional<Series> findByTitle(String title);
}
