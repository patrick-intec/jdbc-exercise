package be.infernalwhale.service;

import be.infernalwhale.model.Brewer;
import be.infernalwhale.service.data.Valuta;
import be.infernalwhale.service.exception.ValidationException;

import java.util.List;

/**
 * BrewersService handles all the requests for the BrewersView
 */
public interface BrewersService {
    /**
     * getBrewers() will get all the brewers from the database.
     * @return a List of Brewer objects as represented in the Brewer(s) table
     */
    List<Brewer> getBrewers();

    /**
     * getBrewers() will get all the brewers from the database. Behaviour can be influenced by parameters as described below
     *
     * @param valuta The turnover property will be converted to the selected currency. Conversion rate is present in the valuta object.
     * @return a List of Brewer objects as represented in the Brewer(s) table. Turnover has been converted to valuta
     */
    List<Brewer> getBrewers(Valuta valuta);
    List<Brewer> getBrewers(String nameFilter);
    List<Brewer> getBrewers(String nameFilter, Valuta valuta);

    Brewer createBrewer(Brewer brewer) throws ValidationException;
    Brewer updateBrewer(Brewer brewer) throws ValidationException;

    boolean deleteBrewerById(Integer id);
}
