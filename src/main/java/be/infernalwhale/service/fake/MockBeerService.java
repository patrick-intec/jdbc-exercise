package be.infernalwhale.service.fake;

import be.infernalwhale.model.Beer;
import be.infernalwhale.model.Brewer;
import be.infernalwhale.model.Category;
import be.infernalwhale.service.BeerService;

import java.util.ArrayList;
import java.util.List;

public class MockBeerService implements BeerService {
    private final List<Beer> beers = generateBeerList();


    @Override
    public List<Beer> getBeers() {
        return beers;
    }

    @Override
    public List<Beer> getBeers(int alcoholConsumed) {
        return beers;
    }


    private List<Beer> generateBeerList() {
        return new ArrayList<>(List.of(
                new Beer(4,"A.C.O.",new Brewer(104, "Test", null, null, null, null),new Category(18, null),2.75,188,7),
                new Beer(5,"Aalbeeks St. Corneliusbier.",new Brewer(113, null, null, null, null, null),new Category(18, null),2.65,12,6),
                new Beer(6,"Aardbeien witbier",new Brewer(56, null, null, null, null, null),new Category(53, null),2.65,44,6),
                new Beer(7,"Adler",new Brewer(51, null, null, null, null, null),new Category(42, null),2.65,44,6)
        ));
    }
}
