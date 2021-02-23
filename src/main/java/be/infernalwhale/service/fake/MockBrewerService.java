package be.infernalwhale.service.fake;

import be.infernalwhale.model.Brewer;
import be.infernalwhale.service.BrewersService;
import be.infernalwhale.service.data.Valuta;
import be.infernalwhale.service.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MockBrewerService implements BrewersService {
    private final List<Brewer> brewers = generateBrewers();

    @Override
    public List<Brewer> getBrewers() {
        return this.brewers;
    }

    @Override
    public List<Brewer> getBrewers(Valuta valuta) {
        return this.brewers.stream()
                .map(brewer -> convertToCurrency(brewer, valuta))
                .collect(Collectors.toList());
    }

    @Override
    public List<Brewer> getBrewers(String nameFilter) {
        return this.brewers.stream()
                .filter(brewer -> brewer.getName().equalsIgnoreCase(nameFilter))
                .collect(Collectors.toList());
    }

    @Override
    public List<Brewer> getBrewers(String nameFilter, Valuta valuta) {
        return this.brewers.stream()
                .filter(brewer -> brewer.getName().equalsIgnoreCase(nameFilter))
                .map(brewer -> convertToCurrency(brewer, valuta))
                .collect(Collectors.toList());
    }

    @Override
    public Brewer createBrewer(Brewer brewer) throws ValidationException {
        if (brewer.getTurnover() < 0) throw new ValidationException("Turnover can not be negative");
        if (brewer.getId() != null && !brewer.getId().equals(0))
            throw new ValidationException("Id must be null or zero when creating a new Brewer");

        brewer.setId(Integer.MAX_VALUE - new Random().nextInt());

        return new Brewer(brewer);
    }

    @Override
    public Brewer updateBrewer(Brewer brewer) throws ValidationException {
        if (brewer.getTurnover() < 0) throw new ValidationException("Turnover can not be negative");

        return new Brewer(brewer);
    }

    @Override
    public boolean deleteBrewerById(Integer id) {
        return true;
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

    private Brewer convertToCurrency(Brewer b, Valuta currency) {
        Brewer brewerCopy = new Brewer(b);
        Integer turnover = (int) Math.round(b.getTurnover() * currency.getConversionRate());
        brewerCopy.setTurnover(turnover);
        return brewerCopy;
    }
}
