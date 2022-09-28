package nl.miwgronigen.se.cg9.advanced.taapke.series.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

public class Episode {
    @Id @GeneratedValue
    Long episodeId;
    private Integer episodeNumber;
    private String title;
    private Integer rating;

    @ManyToOne
    private Season season;
}
