package be.vdab.rekening;

public final class Spaarrekening extends Rekening {
    private static double intrest;

    public Spaarrekening(String reknr, double intrest) {
        this(reknr, intrest, 0.0);
    }

    public Spaarrekening(String reknr, double intrest, double saldo) {
        super(reknr, saldo);
        setIntrest(intrest);
    }

    public static double getIntrest() {
        return intrest;
    }
    @Override
    public void afhalen(double bedrag) {
        if (bedrag > 0.0) {
            var testSaldo = getSaldo()- bedrag;
            if (testSaldo >= 0) {
                super.afhalen(bedrag);
            }
        } }
    public final void setIntrest(double intrest){
        if (intrest > 0.0){
            Spaarrekening.intrest = intrest;
        }
    }
    @Override
    public String toString(){
        return super.toString() + ", "+intrest;
    }
    @Override
    public double berekenIntrest(){
        return getSaldo() * intrest / 100;
    }

}