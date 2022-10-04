package nl.miwgronigen.se.cg9.advanced.taapke.series;

import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Season;
import nl.miwgronigen.se.cg9.advanced.taapke.series.model.Series;
import nl.miwgronigen.se.cg9.advanced.taapke.series.model.SeriesUser;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeasonRepository;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeriesRepository;
import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeriesUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

@SpringBootApplication
public class SeriesKickstarter implements CommandLineRunner {

    private final SeriesUserRepository seriesUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final SeriesRepository seriesRepository;
    private final SeasonRepository seasonRepository;

    public SeriesKickstarter(SeriesUserRepository seriesUserRepository,
                             PasswordEncoder passwordEncoder,
                             SeriesRepository seriesRepository,
                             SeasonRepository seasonRepository) {
        this.seriesUserRepository = seriesUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.seriesRepository = seriesRepository;
        this.seasonRepository = seasonRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (seriesUserRepository.findByUsername("admin").isEmpty()) {
            // create default admin
            SeriesUser admin = new SeriesUser();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("changeThisNow"));
            seriesUserRepository.save(admin);

//            // Create new Series
//            Series buffy = new Series();
//            buffy.setTitle("Buffy the Vampire Slayer");
//            seriesRepository.save(buffy);
//
//            // Create new season
//            Season seasonOne = new Season();
//            seasonOne.setSeries(buffy);
//            seasonOne.setSeasonNumber(1);
//            buffy.getSeasons().add(seasonOne);
//            seriesRepository.save(buffy);
//            seasonRepository.save(seasonOne);

        }
    }
}
