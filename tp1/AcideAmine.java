
package tp1;

import java.util.Objects;

/**
 * Contient les getters, setters, constructeur pour la creation de <this>, une 
 * classe equals et toString.
 * 
 * cette classe herite de Codon.
 */
public class AcideAmine extends Codon{
    protected String acideAmine;
    /**
     * Cree une instance de AcideAmine et appele la super classe Codon.
     * 
     * @param partieArn Une chaine de trois caracteres.
     */
    public AcideAmine(String partieArn) {
        super(partieArn);
        setAcideAmine(partieArn);
    }
    /** 
     * @return la valeur de <this>. 
     */
    public String getAcideAmine() {
        return acideAmine;
    }
    /**
     * Remplace la valeur de <this> par le case qui correspond a <codon>.
     * 
     * @param codon Une chaine de trois caracteres 'U', 'A', 'G' ou 'C'.
     */
    public void setAcideAmine(String codon) {
        switch (codon) {
            
            case "GCU" :
            case "GCC" :
            case "GCA" :
            case "GCG" :   
                this.acideAmine = "Alanine";
                break;
            case "CGU" :
            case "CGC" :
            case "CGA" :
            case "CGG" :
            case "AGA" :
            case "AGG" :
                this.acideAmine = "Arginine";
                break;
            case "AAU" :
            case "AAC" :
                this.acideAmine = "Asparagine";
                break;
            case "GAU" :
            case "GAC" :
                this.acideAmine = "Aspartate";
                break;
            case "UGU" :
            case "UGC" :
                this.acideAmine = "Cysteine";
                break;
            case "GAA" :
            case "GAG" :
                this.acideAmine = "Glutamate";
                break;
            case "CAA" :
            case "CAG" :
                this.acideAmine = "Glutamine";
                break;
            case "GGU" :
            case "GGC" :
            case "GGA" :
            case "GGG" :
                this.acideAmine = "Glycine";
                break;
            case "CAU" :
            case "CAC" :
                this.acideAmine = "Histidine";
                break;
            case "AUU" :
            case "AUC" :
            case "AUA" :
                this.acideAmine = "Isoleucine";
                break;
            case "UUA" :
            case "UUG" :
            case "CUU" :
            case "CUC" :
            case "CUA" :
            case "CUG" :
                this.acideAmine = "Leucine";
                break;
            case "AAA" :
            case "AAG" :
                this.acideAmine = "Lysine";
                break;
            case "AUG" :
                this.acideAmine = "Methionine";
                break;
            case "UUU" :
            case "UUC" :
                this.acideAmine = "Phenylalanine";
                break;
            case "CCU" :
            case "CCC" :
            case "CCA" :
            case "CCG" :
                this.acideAmine = "Proline";
                break;
            case "UAG" :
                this.acideAmine = "Pyrrolysine";
                break;
            case "UGA" :
                this.acideAmine = "Selenocysteine";
                break;
            case "UCU" :
            case "UCC" :
            case "UCA" :
            case "UCG" :
            case "AGU" :
            case "AGC" :
                this.acideAmine = "Serine";
                break;
            case "ACU" :
            case "ACC" :
            case "ACA" :
            case "ACG" :
                this.acideAmine = "Threonine";
                break;
            case "UGG" :
                this.acideAmine = "Tryptophane";
                break;
            case "UAU" :
            case "UAC" :
                this.acideAmine = "Tyrosine";
                break;
            case "GUU" :
            case "GUC" :
            case "GUA" :
            case "GUG" :
                this.acideAmine = "Valine";
                break;
            case "UAA" :
                this.acideAmine = "Marqueur";
                break;
        }
    }
    /**
     * Verifie l'egalite enter deux instance de AcideAmine.
     * 
     * Compare seulement le champ <acideAmine> et non pas les <codons> ou
     * les <nucleotides(1, 2, 3)>. Override equals de la classe Object.
     * 
     * @param autre Une variable Object.
     * @return      Vrais si egal, faux si non.
     */
    @Override
    public boolean equals(Object autre) {
        AcideAmine inter = (AcideAmine) autre;
        return ( acideAmine.equals(inter.acideAmine));
                    
    }
    /**
     * Structure les attributs de <this> pour une presentation a l'ecran.
     * 
     * Override la methode toString de la classe Object.
     * 
     * @return La chaine de caractere obtenue apres l'application de toString.
     */
    @Override
    public String toString() {
        return getAcideAmine()+", "+ getCodon() +", "+  getNucleotide1()+ ", "
                        + getNucleotide2() +", "+ getNucleotide3();
    }
    
}

