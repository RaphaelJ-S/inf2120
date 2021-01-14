package tp2;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Constantes {
    public static final int TEXT_AREA_COREEN_NBR_COLONNES = 30;
    public static final int TEXT_AREA_COREEN_NBR_LIGNES = 20;
    public static final int TEXT_AREA_PRONONCIATION_NBR_COLONNES = 30;
    public static final int TEXT_AREA_PRONONCIATION_NBR_LIGNES = 20;

    public static final Insets INSETS_BUTTON_TRADUIRE = new Insets( 0, 0, 0, 0 );
    public static final Insets INSETS_TEXT_AREA_COREEN = new Insets( 2, 0, 2, 1 );
    public static final Insets INSETS_TEXT_AREA_PRONONCIATION = new Insets( 2, 1, 2, 0 );

    public static final GridBagConstraints POSITION_BUTTON_TRADUIRE =
            new GridBagConstraints( 1, 2, 2, 1, 0, 1, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, INSETS_BUTTON_TRADUIRE, 0, 0 );

    public static final GridBagConstraints POSITION_TEXT_AREA_COREEN =
            new GridBagConstraints( 1, 1, 1, 1, 0, 7, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, INSETS_TEXT_AREA_COREEN, 0, 0 );
    public static final GridBagConstraints POSITION_TEXT_AREA_PRONONCIATION =
            new GridBagConstraints( 2, 1, 1, 1, 0, 7, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, INSETS_TEXT_AREA_PRONONCIATION, 0, 0 );

}
