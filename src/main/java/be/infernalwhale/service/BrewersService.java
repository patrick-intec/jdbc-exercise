package be.infernalwhale.service;

import be.infernalwhale.model.Brewer;

import java.util.List;

public interface BrewersService {
    List<Brewer> getBrewers();
    List<Brewer> getBrewers(String nameFilter);

    Brewer createBrewer(Brewer brewer);
    Brewer updateBrewer(Brewer brewer);

    boolean deleteBrewerById(Integer id);
    boolean deleteBrewer(Brewer brewer);
}
