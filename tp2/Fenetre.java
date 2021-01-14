package tp2;

import java.awt.event.ActionListener;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Fenetre extends JFrame {
    private JButton buttonTraduire;
    private JTextArea textAreaCoreen;
    private JTextArea textAreaPrononciation;

    ActionListener actionButtonTraduire =
            e -> textAreaPrononciation.setText( new TexteCoreen( textAreaCoreen.getText() ).traduire() );

    public Fenetre() {
        super( Textes.TITRE_FENETRE );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLayout( new GridBagLayout() );

        textAreaCoreen =
                new JTextArea( Constantes.TEXT_AREA_COREEN_NBR_LIGNES, Constantes.TEXT_AREA_COREEN_NBR_COLONNES );
        add( textAreaCoreen, Constantes.POSITION_TEXT_AREA_COREEN );
        textAreaPrononciation =
                new JTextArea( Constantes.TEXT_AREA_PRONONCIATION_NBR_LIGNES,
                        Constantes.TEXT_AREA_PRONONCIATION_NBR_COLONNES );
        textAreaPrononciation.setEditable( false );
        add( textAreaPrononciation, Constantes.POSITION_TEXT_AREA_PRONONCIATION );

        buttonTraduire = new JButton( Textes.BUTTON_TRADUIRE );
        buttonTraduire.addActionListener( actionButtonTraduire );
        add( buttonTraduire, Constantes.POSITION_BUTTON_TRADUIRE );

        pack();
        setVisible( true );
    }
}
