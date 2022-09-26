package nl.miwgronigen.se.cg9.advanced.taapke.series.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */
@Entity
public class Series {
    @Id
    @GeneratedValue
    private Long seriesId;

    private String title;
    private String actor;

    public void setSeriesId(Long seriesId) {
        this.seriesId = seriesId;
    }

    public Long getSeriesId() {
        return seriesId;
    }

    public String getTitle() {
        return title;
    }

    public String getActor() {
        return actor;
    }
}
