package be.vdab.rekening;

public final class Zichtrekening extends Rekening {
    private int maxKrediet;
    private static final double INTREST_ZICHTREKENING = 0.25;

    public Zichtrekening(String rekeningNummer, double saldo, int bedrag) {
        super(rekeningNummer, saldo);
        setMaxKrediet(bedrag);
    }

    public Zichtrekening(String rekeningNummer, int bedrag) {
        this(rekeningNummer, 0.0, bedrag);

    }

    public int getMaxKrediet() {
        return maxKrediet;
    }

    public final void setMaxKrediet(int maxKrediet) {
        if (maxKrediet > 0) {
            this.maxKrediet = maxKrediet;
        }

    }

    @Override
    public void afhalen(double bedrag) {
        if (bedrag > 0.0) {
            var testSaldo = getSaldo() - bedrag + maxKrediet;
            if (testSaldo >= 0)
                super.afhalen(bedrag);

        }
    }

    @Override
    public String toString() {
        return super.toString() + ", " + maxKrediet;
    }

    @Override
    public double berekenIntrest() {
        if (getSaldo() > 0) {
            return getSaldo() * INTREST_ZICHTREKENING / 100;
        } else {
            return 0.0;
        }
    }
}
