import java.io.Serializable;

/**
 * Genericka trieda Stat reprezentuje hodnotu s min a max limitmi.
 * Pouziva sa pre statistiky ako zdravie, kde je potrebne udrziavat hodnotu v rozsahu.
 * Implementuje Serializable pre ukladanie stavu hry.
 * 
 * @param <T> Typ hodnoty (musi byt cislo)
 * @see Number
 * @see Comparable
 */
public class Stat<T extends Number & Comparable<T>> implements Serializable {
    /** Serial version UID pre serializaciu */
    private static final long serialVersionUID = 1L;
    /** Aktualna hodnota statistiky */
    private T hodnota;
    /** Minimalna povolena hodnota */
    private final T minHodnota;
    /** Maximalna povolena hodnota */
    private final T maxHodnota;

    /**
     * Konstruktor pre vytvorenie statu s pociatocnou, min a max hodnotou.
     * 
     * @param pociatocnaHodnota Pociatocna hodnota statistiky
     * @param minHodnota Minimalna povolena hodnota
     * @param maxHodnota Maximalna povolena hodnota
     */
    public Stat(T pociatocnaHodnota, T minHodnota, T maxHodnota) {
        this.hodnota = pociatocnaHodnota;
        this.minHodnota = minHodnota;
        this.maxHodnota = maxHodnota;
    }


    public T getHodnota() { return hodnota; }
    public void setHodnota(T hodnota) {
        if (hodnota.compareTo(minHodnota) >= 0 && hodnota.compareTo(maxHodnota) <= 0)
            this.hodnota = hodnota;
        else if (hodnota.compareTo(minHodnota) < 0)
            this.hodnota = minHodnota;
        else
            this.hodnota = maxHodnota;
    }
    public void pridaj(T mnozstvo) {
        T novaHodnota = (T) Integer.valueOf(hodnota.intValue() + mnozstvo.intValue());
        setHodnota(novaHodnota);
    }
    public void odcitaj(T mnozstvo) {
        T novaHodnota = (T) Integer.valueOf(hodnota.intValue() - mnozstvo.intValue());
        setHodnota(novaHodnota);
    }
    public boolean jeNaMin() { return hodnota.compareTo(minHodnota) == 0; }
    public boolean jeNaMax() { return hodnota.compareTo(maxHodnota) == 0; }
    public T getMinHodnota() { return minHodnota; }
    public T getMaxHodnota() { return maxHodnota; }
}