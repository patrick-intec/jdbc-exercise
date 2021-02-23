package be.infernalwhale.service.data;

public enum Valuta {
    EURO(1.0),
    USD(1.1),
    YEN(127.7);

    private final Double conversionRate;

    Valuta(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Double getConversionRate() {
        return conversionRate;
    }
}
