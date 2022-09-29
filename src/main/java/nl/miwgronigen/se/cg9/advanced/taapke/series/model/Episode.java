package nl.miwgronigen.se.cg9.advanced.taapke.series.model;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */
@Entity
@Getter @Setter

public class Episode {
    @Id @GeneratedValue
    Long episodeId;
    private Integer episodeNumber;
    private String title;
    private Integer rating;

    @ManyToOne
    private Season season;

    @OneToMany(mappedBy = "episode")
    private List<Rating> ratings;

    public double getAverageRating() {
        var scoreObj = new Object() {
            int value = 0;
        };
        ratings.forEach(rating -> scoreObj.value += rating.getScore());
        return (scoreObj.value / ratings.size());
    }
}
