package be.infernalwhale.service.fake;

import be.infernalwhale.model.Brewer;
import be.infernalwhale.service.BrewersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FakeBrewerService implements BrewersService {
    private List<Brewer> brewers = generateBrewers();

    @Override
    public List<Brewer> getBrewers() {
        return this.brewers;
    }

    @Override
    public List<Brewer> getBrewers(String nameFilter) {
        return this.brewers.stream()
                .filter(brewer -> brewer.getName().equalsIgnoreCase(nameFilter))
                .collect(Collectors.toList());
    }

    @Override
    public Brewer createBrewer(Brewer brewer) {
        return null;
    }

    @Override
    public Brewer updateBrewer(Brewer brewer) {
        return null;
    }

    @Override
    public boolean deleteBrewerById(Integer id) {
        return false;
    }

    @Override
    public boolean deleteBrewer(Brewer brewer) {
        return false;
    }

    private List<Brewer> generateBrewers() {
        return new ArrayList<>(List.of(
                new Brewer(1, "Achouffe", "Route du Village 32", 6666, "Achouffe-Wibrin", 10000),
                new Brewer(2, "Alken", "Stationstraat 2", 3570, "Alken", 950000),
                new Brewer(3, "Ambly", "Rue Principale 45", 6953, "Ambly-Nassogne", 500),
                new Brewer(4, "Anker", "Guido Gezellelaan 49", 2800, "Mechelen", 3000),
                new Brewer(6, "Artois", "Vaartstraat 94", 3000, "Leuven", 4000000)
        ));
    }
}
