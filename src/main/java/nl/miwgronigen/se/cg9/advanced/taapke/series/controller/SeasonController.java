package nl.miwgronigen.se.cg9.advanced.taapke.series.controller;

import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Season;
import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Series;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeasonRepository;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeriesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

@Controller
@RequestMapping("/season")
public class SeasonController {
    private final SeasonRepository seasonRepository;
    private final SeriesRepository seriesRepository;

    public SeasonController(SeasonRepository seasonRepository, SeriesRepository seriesRepository) {
        this.seasonRepository = seasonRepository;
        this.seriesRepository = seriesRepository;
    }

    @GetMapping("/new/{seriesId}")
    protected String createNewSeason(@PathVariable("seriesId") Long seriesId) {
        Optional<Series> series = seriesRepository.findById(seriesId);
        if (!series.isEmpty()) {
            Season season = new Season();
            season.setSeries(series.get());
            seasonRepository.save(season);
        }
        return "redirect:/series/overview";
    }

}
