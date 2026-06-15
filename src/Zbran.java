/**
 * Zbran poskytuje bonusove poskodenie k utoku hraca.
 * Ma prideleny material, ktory ma vyznam pri interakcii s elementmi nepriatelov.
 * 
 * @see Vybavenie
 * @see Material
 * @see EntityHrac
 */
public class Zbran extends Vybavenie {
    /** Serial version UID pre serializaciu */
    private static final long serialVersionUID = 1L;
    /** Bonusove poskodenie pridavane k zakladnej sile */
    private int bonusovePoskodenie;
    /** Material zbrane */
    private Material material;

    /**
     * Konstruktor pre vytvorenie zbrane.
     *
     * @param nazov              Nazov zbrane
     * @param bonusovePoskodenie Bonusove poskodenie zbrane
     * @param material           Material zbrane
     */
    public Zbran(String nazov, int bonusovePoskodenie, Material material) {
        super(nazov);
        this.bonusovePoskodenie = bonusovePoskodenie;
        this.material = material;
    }

    public int getBonusovePoskodenie() {
        return bonusovePoskodenie;
    }

    public Material getMaterial() {
        return material;
    }
}