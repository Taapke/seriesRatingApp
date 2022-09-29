package nl.miwgronigen.se.cg9.advanced.taapke.series.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

@Entity
@Getter
@Setter
public class Rating {
    @Id
    @GeneratedValue
    Long ratingId;

    private LocalDateTime localDateTime;
    private Double score;
    private String notes;

    @ManyToOne
    private Episode episode;

}
