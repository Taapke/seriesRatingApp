package nl.miwgronigen.se.cg9.advanced.taapke.series.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "series")
    private List<Season> seasons = new ArrayList<>();

    public int getNumberOfSeasons(){
        int count = 0;
        for (Season season :seasons) {
            count++;
        }
        System.out.println("number of copies: " + count);
        return count;
    }

}
