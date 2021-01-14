
package tp1;

/**
 * Contient les setters, getters et constructeur pour la creation d'une 
 * instance de <Nucleotide>.
 * 
 * Cette classe est abstraite et contient 3 champs de type String.
 */
public abstract class Nucleotide {
    protected String nucleotide1;
    protected String nucleotide2;
    protected String nucleotide3;
    /**
     * Cree trois instances de <Nucleotide> à partir d'une chaine de 3 
     * caracteres.
     * 
     * @param nucleotide 
     */
    public Nucleotide(String nucleotide) {
        setNucleotide(nucleotide);
    }
    /**
     * Retourne la valeur de <this>.
     * 
     * @return la valeur de <this>
     */
    public String getNucleotide1() {
        return nucleotide1;
    }
    /**
     * Retourne la valeur de <this>.
     * 
     * @return la valeur de <this>
     */
    public String getNucleotide2() {
        return nucleotide2;
    }
    /**
     * Retourne la valeur de <this>.
     * 
     * @return la valeur de <this>
     */
    public String getNucleotide3() {
        return nucleotide3;
    }
    /**
     * Remplace la valeur des trois <this> par les trois lettre du Codon donne
     * en parametre.
     * 
     * @param Codon Le codon duquel on prend les nucleotides.
     */
    protected void setNucleotide(String Codon) {
        nucleotide1 = "" + Codon.charAt(0);
        nucleotide2 = "" + Codon.charAt(1);
        nucleotide3 = "" + Codon.charAt(2);
    }
        
}
