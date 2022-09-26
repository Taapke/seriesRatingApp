package nl.miwgronigen.se.cg9.advanced.taapke.series.controller;

import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeriesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

@Controller
public class SeriesController {

    private final SeriesRepository seriesRepository;

    public SeriesController(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @GetMapping("/series")
    protected String showSeriesOverview(Model model) {
        model.addAttribute("allSeries", seriesRepository.findAll());
        return "seriesOverview";
    }
}
