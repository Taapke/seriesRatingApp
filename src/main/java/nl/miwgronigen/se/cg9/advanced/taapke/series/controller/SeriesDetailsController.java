package nl.miwgronigen.se.cg9.advanced.taapke.series.controller;

import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Season;
import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Series;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.EpisodeRepository;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.RatingRepository;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeasonRepository;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeriesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

@Controller
public class SeriesDetailsController {
    private final EpisodeRepository episodeRepository;
    private final SeriesRepository seriesRepository;
    private final SeasonRepository seasonRepository;
    private final RatingRepository ratingRepository;

    public SeriesDetailsController(EpisodeRepository episodeRepository, SeriesRepository seriesRepository,
                                   SeasonRepository seasonRepository, RatingRepository ratingRepository) {
        this.episodeRepository = episodeRepository;
        this.seriesRepository = seriesRepository;
        this.seasonRepository = seasonRepository;
        this.ratingRepository = ratingRepository;
    }


    @GetMapping("/series/details/{seriesTitle}")
    protected String showDetailsSeries(@PathVariable("seriesTitle") String seriesTitle, Model model) {
        Optional<Series> series = seriesRepository.findByTitle(seriesTitle);
        if (series.isEmpty()) {
            System.out.println("is empty");
            return "redirect:/series/overview";
        }

        Season season = new Season();
        season.setSeries(series.get());
        model.addAttribute("season", season);
        model.addAttribute("series", series.get());
        return "seriesDetails";
    }
}
