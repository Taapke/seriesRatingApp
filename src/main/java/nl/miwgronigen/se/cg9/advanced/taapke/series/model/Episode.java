package nl.miwgronigen.se.cg9.advanced.taapke.series.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToOne
    private Season season;

    @OneToMany(mappedBy = "episode")
    private List<Rating> ratings = new ArrayList<>();
}
