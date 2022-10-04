package nl.miwgronigen.se.cg9.advanced.taapke.series.controller;

import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Episode;
import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Season;
import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Series;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.EpisodeRepository;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeasonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

@Controller
public class EpisodeController {

    private final EpisodeRepository episodeRepository;
    private final SeasonRepository seasonRepository;

    public EpisodeController(EpisodeRepository episodeRepository, SeasonRepository seasonRepository) {
        this.episodeRepository = episodeRepository;
        this.seasonRepository = seasonRepository;
    }

    @PostMapping("/series/{seasonId}")
    protected String saveSeason(@PathVariable("seasonId") Long seasonId,
                                @ModelAttribute("episode") Episode episode, BindingResult result) {
        Optional<Season> season = seasonRepository.findById(seasonId);
        if (season.isPresent()) {
            episode.setSeason(season.get());
            episodeRepository.save(episode);
        }
        return String.format("redirect:/series/overview");
    }

}
