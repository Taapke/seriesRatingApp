package nl.miwgronigen.se.cg9.advanced.taapke.series.controller;

import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Series;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeasonRepository;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeriesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

@Controller
public class SeriesController {

    private final SeriesRepository seriesRepository;
    private final SeasonRepository seasonRepository;

    public SeriesController(SeriesRepository seriesRepository, SeasonRepository seasonRepository) {
        this.seriesRepository = seriesRepository;
        this.seasonRepository = seasonRepository;
    }

    @GetMapping({"/","/series/overview"})
    protected String showSeriesOverview(Model model) {
        model.addAttribute("allSeries", seriesRepository.findAll());
        return "seriesOverview";
    }

    @GetMapping("/series/new")
    protected String showNewSeriesForm(Model model) {
        model.addAttribute("series", new Series());
        return "seriesForm";
    }

    @GetMapping("/series/update/{seriesTitle}")
//    protected String showUpdateBookForm(@PathVariable("seriesId") Long seriesId, Model model) {
//        Optional<Series> series = seriesRepository.findById(seriesId);
    protected String showUpdateBookForm(@PathVariable("seriesTitle") String seriesTitle, Model model) {
        Optional<Series> series = seriesRepository.findByTitle(seriesTitle);
        if (series.isEmpty()) {
            return "redirect:/series/overview";
        }
        model.addAttribute("series", series.get());
        return "seriesForm";
    }

    @PostMapping("/series/new")
    protected String saveOrUpdateSeries(@ModelAttribute("series") Series series, BindingResult result) {
        if (!result.hasErrors()) {
            seriesRepository.save(series);
        }
        return "redirect:/series/overview";
    }
}
