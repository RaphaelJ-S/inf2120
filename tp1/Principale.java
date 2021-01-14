
package tp1;

/**
 * @auteur Raphaël Jacob-Simard
 * @CodePermanant JACR26038907
 * @Cours INF2120
 * @Groupe 30
 */

import java.util.ArrayList;
import java.util.Scanner;
/**
 *  Demande et valide deux chaines de caracteres et un entier, forme deux 
 *  <ArrayList> et imprime la déviation minimale entre ces deux listes.
 **/
public class Principale{
    public final static String MSG_SOL_ARN1 ="Entrez la premiere chaine : ";
    public final static String MSG_SOL_ARN2 = "Entrez la deuxieme chaine : ";
    public final static String MSG_SOL_DEVIMAX = "Entrez un entier superieur"
            + " à zero : ";
    /**
     * Cree une ArrayList qui contient des acide amines qui sont crees à partir
     * de la chaine en parametre.
     * 
     * @param entree La chaine à segmenter et à inserer dans la liste.
     * @return       L'ArrayList contenant un nombre <repetition> d'acides.
     */
    public static ArrayList creationListe (String entree) {
        ArrayList arnListe = new ArrayList();
        int repetition = entree.length() / 3;
        int inter = 0;
        
        for ( int i = 0 ; i < repetition ; i++) {
            arnListe.add(new AcideAmine(entree.substring(inter, inter +3)));
            inter = inter +3;
        }
        return arnListe;
    }
    /**
     * Valide la chaine donnee en parametre.
     * 
     * La chaine ne doit pas être null ou vide, doit etre un modulo 3 = 0 et
     * doit seulement contenir les lettres : 'A', 'C', 'U', 'G'.
     * 
     * @param arn La chaine de caractere qui doit etre validee.
     * @return    Une chaine de caractere valide
     */
    public static boolean validerChaine(String arn) {
        boolean valider = false;
        int i = 0;
        
        if ( arn != null && arn.length()%3 == 0 && !arn.isEmpty()) {
            while (i < arn.length() && (arn.charAt(i) == 'A'
                    ||arn.charAt(i)=='U'||arn.charAt(i)=='C'
                    ||arn.charAt(i)=='G')) {
                if (i == arn.length() - 1) {
                    valider = !valider;
                }
                i++;
            }
        }
        return valider;
    }
    /**
     * Affiche les messages de solicitation appropries, prend les valeurs
     * ecrites au clavier et execute les methodes de creation de liste et
     * de calcul.
     * 
     * Affiche un message d'erreur si les valeurs prisent a l'ecran ne sont
     * pas valides et termine le logiciel.
     *  
     */
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList arnAcide1;
        ArrayList arnAcide2;

        try {
            System.out.print(MSG_SOL_ARN1);
            String arn1 = sc.nextLine();
            if (validerChaine(arn1)) {
                System.out.print(MSG_SOL_ARN2);
                String arn2 = sc.nextLine();
                if (validerChaine(arn2)) {
                    System.out.print(MSG_SOL_DEVIMAX);
                    int deviation = sc.nextInt();
                    if (deviation > 0) {
                        arnAcide1 = creationListe(arn1);
                        arnAcide2 = creationListe(arn2);
                        System.out.println(CalculDeviation.deviationMin
                                (arnAcide1, arnAcide2, 
                                deviation));
                    }else {
                        System.err.println("l'entier n'est pas "
                                + "plus grand que zero");
                        System.exit(-1);
                    }
                }else {
                    System.err.println("La chaine n'est pas conforme");
                    System.exit(-2);
                }
            }else {
                System.err.println("La chaine n'est pas conforme");
                System.exit(-2);
            }
        } catch (Exception e) {
            System.err.println("Erreur générale");
            System.exit(-3);
        }
        sc.close();
        System.exit(1);
    }
}