package be.infernalwhale.service;

import be.infernalwhale.model.Beer;

import java.util.List;

public interface BeerService {
    List<Beer> getBeers();
    List<Beer> getBeers(int alcoholConsumed);
}
