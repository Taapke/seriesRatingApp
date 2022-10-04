package nl.miwgronigen.se.cg9.advanced.taapke.series.service;

import nl.miwgronigen.se.cg9.advanced.taapke.series.repository.SeriesUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Taapke Bergsma <t.bergsma@st.hanze.nl>
 */

@Service
public class SeriesUserDetailService implements UserDetailsService {

    private final SeriesUserRepository seriesUserRepository;

    public SeriesUserDetailService(SeriesUserRepository seriesUserRepository) {
        this.seriesUserRepository = seriesUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return seriesUserRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(
                        String.format("User with name %s was not found.", username))
        );
    }
}
