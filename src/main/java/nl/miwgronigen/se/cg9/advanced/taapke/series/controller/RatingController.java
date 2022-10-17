package nl.miwgronigen.se.cg9.advanced.taapke.series.controller;

import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Episode;
import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Rating;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.EpisodeRepository;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.RatingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

@Controller
public class RatingController {

    private final RatingRepository ratingRepository;
    private final EpisodeRepository episodeRepository;


    public RatingController(RatingRepository ratingRepository, EpisodeRepository episodeRepository) {
        this.ratingRepository = ratingRepository;
        this.episodeRepository = episodeRepository;
    }

    @GetMapping("/episode/rating/new/{episodeId}")
    protected String showRatingForm(@PathVariable("episodeId") Long episodeId, Model model) {
        Optional<Episode> episode = episodeRepository.findById(episodeId);
        if (episode.isEmpty()) {
            return "redirect:/series/overview";
        }
        Rating rating = new Rating();
        model.addAttribute("rating", rating);
        model.addAttribute("episode", episode.get());
        return "ratingForm";
    }

    @PostMapping("/rating/{episodeId}")
    protected String saveRating(@PathVariable("episodeId") Long episodeId,
                                @ModelAttribute("rating") Rating rating, BindingResult result) {
        Optional<Episode> episode = episodeRepository.findById(episodeId);
        if (episode.isPresent()) {
            rating.setLocalDateTime(LocalDateTime.now());
            rating.setEpisode(episode.get());
            ratingRepository.save(rating);
        }
        String seriesTitle = episode.get().getSeason().getSeries().getTitle();
        String redirect = String.format("redirect:/series/details/%s", seriesTitle);
        return (redirect);
    }

}
