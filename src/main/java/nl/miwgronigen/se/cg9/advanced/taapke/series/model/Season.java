package nl.miwgronigen.se.cg9.advanced.taapke.series.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

@Entity @Getter @Setter
public class Season {
    @Id @GeneratedValue
    Long seasonId;

    private Integer seasonNumber;

    @ManyToOne
    private Series series;

    @OneToMany(mappedBy = "season")
    private List<Episode> episodes = new ArrayList<>();

}
