package tp2;

import javax.swing.SwingUtilities;

public class Principal {
    public static void main( String arg[] ) {
        SwingUtilities.invokeLater( () -> new Fenetre() );
    }
}
