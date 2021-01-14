package tp4;

public class Pile< E > {
    private class Chainon {
        public E valeur;
        public Chainon precedant;

        public Chainon( E valeur, Chainon precedant ) {
            this.valeur = valeur;
            this.precedant = precedant;
        }
    }

    protected Chainon sommet;

    /**
     * QUESTION 4
     *
     * Echange les deux premier chainons de place.
     *
     * Le chainon contenant le sommet et le chainon precedant sont echanges.
     * Ce N'EST PAS seulement les valeurs qui change, mais les chainons.
     * Cela va vous demander de deplacer les references (pointeur).
     *
     *
     * ************************************************************************
     * Placez vos explications ici :
     *
     * Pour comprendre cet algorithme, il faut comprendre qu'une Pile contient
     * des Chainons qui contiennet une ou des valeurs et une reference vers le
     * prochain chainon. Le problème avec échanger les deux premiers chainons
     * vient du fait qu'une variable temporaire garde les references et donc 
     * que les changements appliqués a cette variable temporaire affectent aussi
     * la variable initiale. Pour echanger deux chainons, il ne suffit donc pas 
     * de seulement passer par une variable temporaire; il faut faire pointer
     * une variable vers le sommet de la Pile pour garder la composition du 
     * sommet, faire pointer le sommet vers le chainon suivant et finallement de
     * faire pointer le chainon suivant vers un nouveau Chainon ayant la valeur
     * du sommet initial et pointant vers la suite de la Pile.
     * 
     * ************************************************************************
     *
     */
    public void echanger() {
        
    	if(!estVide() && !(sommet.precedant == null)) {
    		Chainon tmpSommet = sommet;
    		sommet = sommet.precedant;
			sommet.precedant =
					new Chainon(tmpSommet.valeur,tmpSommet.precedant.precedant);
    	}

    }

    public boolean estVide() {
        return null == sommet;
    }

    public E sommet() throws ExceptionPileVide {
        if( null == sommet ) {
            throw new ExceptionPileVide( "sommet" );
        }

        return sommet.valeur;
    }

    public void empiler( E valeur ) {
        sommet = new Chainon( valeur, sommet );
    }

    public E depiler() throws ExceptionPileVide {
        if( null == sommet ) {
            throw new ExceptionPileVide( "depiler" );
        }

        E temp = sommet.valeur;
        sommet = sommet.precedant;

        return temp;
    }
}
