
package tp1;

import java.util.ArrayList;

/**
 * Calcule la deviation minimale entre deux chaines d'acides amines a l'aide
 * d'une equation.
 * 
 * L'equation est divise en methode pour aider la lisibilite.
 */
public class CalculDeviation {
    public static final double E = 2.71828;
    /**
     * Calcule K(s,t).
     * 
     * @param arn1 Premiere liste d'acide amine.
     * @param arn2 Deuxieme liste d'acide amine.
     * @param dev  La valeur de la deviation maximale possible.
     * @return     La difference minimale entre les deux ARN format petit.
     */
    public static double deviationMin( ArrayList arn1, ArrayList arn2, int dev){
        return Math.pow(E, (-6*Math.pow(calculInter(arn1, arn2, dev), 2)));
    }
    /**
     * Calcule M(s,t).
     * 
     * @param arn1 Premiere liste d'acide amine.
     * @param arn2 Deuxieme liste d'acide amine.
     * @param dev  La valeur de la deviation maximale possible.
     * @return     La difference minimale entre les deux ARN format grand.
     */
    private static double calculInter(ArrayList arn1, ArrayList arn2, int dev) {
        return (balayage(arn1, arn2, dev) + balayage(arn2, arn1, dev))
                /(dev*(arn1.size()+arn2.size()));
    }
    /**
     * Calcule la deviation minimale pour chaque case de la premiere liste 
     * par rapport a la deuxieme liste et les additionnent pour donner
     * la deviation minimale de la liste complete.
     * 
     * Choisit une chaine differente dependant de l'indice de la liste
     * 
     * @param arn1 Premiere liste d'acide amine.
     * @param arn2 Deuxieme liste d'acide amine.
     * @param dev  La valeur de la deviation maximale possible.
     * @return     La somme des difference minimale de chaque acide amine.
     */  
    private static double balayage(ArrayList arn1, ArrayList arn2, int dev) {
        double deviationMin = 0;
        double deviationMinFin = 0;
        int indice1 ;
        int indice2 ;
        
        for (int i = 0 ; i < arn1.size() ; i++) {
            if (i == 0) {
                indice1 = diffBoucles(arn1, arn2, 1, i, i, dev);
                deviationMin = Math.min(indice1, dev);
            }else if ( i != 0 && i < arn2.size()) {
                indice1 = diffBoucles(arn1, arn2, 1, i, i, dev);
                indice2 = diffBoucles(arn1, arn2, 2, i, i, dev);
                
                deviationMin = Math.min(Math.min(indice1, indice2), dev);
            }else {
                deviationMin = Math.min(diffBoucles(arn1, arn2, 2, i,
                        arn2.size() - 1, dev), dev);
            }
            deviationMinFin = deviationMinFin + deviationMin;   
        }
        return deviationMinFin;
    }
    /**
     * Calcule la deviation minimale d'un indice de <arn1> par rapport a <arn2>.
     * 
     * Dependant de <variation>, <f> va croitre ou diminuer et si il n'y a 
     * jamais d'egalite, la deviation minimale est la deviation maximale.
     * 
     * @param arn1      Premiere liste d'acide amine.
     * @param arn2      Deuxieme liste d'acide amine.
     * @param variation Le choix de boucle; 1 = f++ 2 = f--.
     * @param i         L'indice de commencement pour la premiere liste d'acide.
     * @param f         L'indice de commencement pour le deuxieme liste d'acide.
     * @param dev       La valeur de la deviation maximale possible.
     * @return          La deviation minimale d'un indice d'<arn1> par rapport
     *                      a toute <arn2>.
     */

    private static int diffBoucles(ArrayList arn1, ArrayList arn2
            , int variation, int i, int f, int dev) {
        int deltaIndice = 0;
        boolean fin = true;
        switch (variation) {
            case 1: 
                while(f < arn2.size() && fin) {
                    if (arn1.get(i).equals(arn2.get(f))) {
                        deltaIndice = Math.abs(f - i);
                        fin = !fin;
                    }else {
                        deltaIndice = dev;
                    }  
                    f++;
                }
                break;
            case 2: 
                while(fin && f >= 0) {
                    if (arn1.get(i).equals(arn2.get(f))) {
                        deltaIndice = Math.abs( f - i);
                        fin = !fin;
                    }else {
                        deltaIndice = dev;
                    }
                    f--;
                }
                break;
        }
        return deltaIndice;
    }
}
    

