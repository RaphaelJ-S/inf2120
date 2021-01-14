/**
 * Question: 
 * 1.comment mettre les caractères internationaux phonétiques dans un tableau?
 * 2.Changement de prononciation? Comment sans passer à travers toutes les options?
 * 3.Changement de prononciation en comparant les caractères internationaux phonétiques.
 * 4.classe traduire dans TexteCoreen ok?
 * 5.Question générales à propos du casting
 * 6.Espaces dans le texte?
 * 7.valeur des jamo toujour entre la longueur de la table?
 **/
package tp2;

/**
 *Réponses:
 * 1.String s = Character.toString(0x006b); s += Character.toString(0x02b0);
 * ou String s = "\u006b" + "\u02b0"; ou "\u006b\u02b0"
 * 2.
 * 3.
 * 4.
 * 5.il faut caster en string
 * 6.pas d'espaces
 * 7.
 */
public class Hangeul {
    protected String consonneInit;
    protected String voyelle;
    protected String consonneFin;
    
    public Hangeul(char hangeul) {
        int hangeulMod = hangeul - 44032;
        int valInter = hangeulMod - (hangeulMod % 28);
        consonneInit =""+ (1 + hangeulMod / 588);
        voyelle = "" + (1 + ((valInter) % 588) / 28);
        consonneFin = "" + (hangeulMod % 28);
    }

    @Override
    public String toString() {
        return "("+consonneInit + ", "+ voyelle + ", " 
                + consonneFin+")";
    }
}
