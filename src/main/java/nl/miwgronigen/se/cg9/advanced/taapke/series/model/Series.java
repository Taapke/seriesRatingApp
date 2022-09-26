package nl.miwgronigen.se.cg9.advanced.taapke.series.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Year;
import java.util.Date;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */
@Entity
public class Series {
    @Id
    @GeneratedValue
    private Long seriesId;

    private String title;
    private String genre;
    private Date firstAired;

    public void setSeriesId(Long seriesId) {
        this.seriesId = seriesId;
    }

    public Long getSeriesId() {
        return seriesId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Date getFirstAired() {
        return firstAired;
    }
}
