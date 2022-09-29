package nl.miwgronigen.se.cg9.advanced.taapke.series.repository;

import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Episode;
import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long>{
}

