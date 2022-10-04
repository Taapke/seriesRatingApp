package nl.miwgronigen.se.cg9.advanced.taapke.series.controller;

import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Season;
import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Series;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeasonRepository;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeriesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

@Controller
public class SeasonController {
    private final SeasonRepository seasonRepository;
    private final SeriesRepository seriesRepository;

    public SeasonController(SeasonRepository seasonRepository, SeriesRepository seriesRepository) {
        this.seasonRepository = seasonRepository;
        this.seriesRepository = seriesRepository;
    }

    @PostMapping("/season/{seriesTitle}")
    protected String saveSeason(@PathVariable("seriesTitle") String seriesTitle,
                                @ModelAttribute("season") Season season, BindingResult result) {
        Optional<Series> series = seriesRepository.findByTitle(seriesTitle);
        if (series.isPresent()) {
            season.setSeries(series.get());
            seasonRepository.save(season);

        }
        return "redirect:/series/overview";
    }


}
