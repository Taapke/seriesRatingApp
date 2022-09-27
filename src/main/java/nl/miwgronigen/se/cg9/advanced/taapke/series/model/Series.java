package nl.miwgronigen.se.cg9.advanced.taapke.series.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Year;
import java.util.Date;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */
@Entity @Getter
@Setter
public class Series {
    @Id
    @GeneratedValue
    private Long seriesId;

    private String title;
    private int season;
    private int episodesNumber;

}
