
package tp1;

/**
 * Contient les setters, getters et constructeur pour la construction d'une
 * instance de <Codon>.
 * 
 * Est une classe abstraite et herite de Nucleotide
 */
public abstract class Codon extends Nucleotide{
    protected String codon;
    /**
     * Cree une instance de Codon et appele la super classe Nucleotides.
     * 
     * @param codon Est une chaine de trois caracteres.
     */
    public Codon(String codon) {
        super(codon);
        this.codon = codon;
    }
    /**
     * @return La valeur de <this>.
     */
    public String getCodon() {
        return codon;
    }
    /**
     * Remplace la valeur de <this> par <codon>.
     * 
     * @param codon la valeur qui remplace <this>. 
     */
    public void setCodon(String codon) {
        this.codon = codon;
    }
    

}
