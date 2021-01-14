package tp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TexteCoreenTest {
    private static final int DEBUT_COREEN = 44032;

    private static final int NO_PREMIER_CI = 1;
    private static final int NO_DERNIER_CI = 19;

    private static final int NO_PREMIERE_VOYELLE = 1;
    private static final int NO_DERNIERE_VOYELLE = 21;
    private static final int NB_VOYELLE =
        NO_DERNIERE_VOYELLE - NO_PREMIERE_VOYELLE + 1;

    private static final int NO_PREMIER_CF = 0;
    private static final int NO_DERNIER_CF = 27;
    private static final int NB_CONSONNE_FINAL =
        NO_DERNIER_CF - NO_PREMIER_CF + 1;

    public static String construireUnicode( int c, int v, int d ) {
        return Character.toString(
                DEBUT_COREEN + d + NB_CONSONNE_FINAL * ( ( v - 1 ) + NB_VOYELLE *  ( c - 1 ) )
        );
    }

    private static final String H_1_1_0 = construireUnicode( 1, 1, 0 );
    private static final String H_2_1_0 = construireUnicode( 2, 1, 0 );
    private static final String H_12_1_0 = construireUnicode( 12, 1, 0 );
    private static final String H_18_1_0 = construireUnicode( 18, 1, 0 );
    private static final String H_19_1_0 = construireUnicode( 19, 1, 0 );
    private static final String H_1_2_0 = construireUnicode( 1, 2, 0 );
    private static final String H_1_10_0 = construireUnicode( 1, 10, 0 );
    private static final String H_1_20_0 = construireUnicode( 1, 20, 0 );
    private static final String H_1_21_0 = construireUnicode( 1, 21, 0 );
    private static final String H_1_1_1 = construireUnicode( 1, 1, 1 );
    private static final String H_1_1_13 = construireUnicode( 1, 1, 13 );
    private static final String H_1_1_26 = construireUnicode( 1, 1, 26 );
    private static final String H_1_1_27 = construireUnicode( 1, 1, 27 );

    private static final String H_2_2_2 = construireUnicode( 2, 2, 2 );
    private static final String H_3_3_3 = construireUnicode( 3, 3, 3 );
    private static final String H_4_4_4 = construireUnicode( 4, 4, 4 );
    private static final String H_5_5_5 = construireUnicode( 5, 5, 5 );
    private static final String H_6_6_6 = construireUnicode( 6, 6, 6 );
    private static final String H_7_7_7 = construireUnicode( 7, 7, 7 );
    private static final String H_8_8_8 = construireUnicode( 8, 8, 8 );
    private static final String H_9_9_9 = construireUnicode( 9, 9, 9 );
    private static final String H_10_10_10 = construireUnicode( 10, 10, 10 );
    private static final String H_11_11_11 = construireUnicode( 11, 11, 11 );
    private static final String H_12_12_12 = construireUnicode( 12, 12, 12 );
    private static final String H_13_13_13 = construireUnicode( 13, 13, 13 );
    private static final String H_14_14_14 = construireUnicode( 14, 14, 14 );
    private static final String H_15_15_15 = construireUnicode( 15, 15, 15 );
    private static final String H_16_16_16 = construireUnicode( 16, 16, 16 );
    private static final String H_17_17_17 = construireUnicode( 17, 17, 17 );
    private static final String H_18_18_18 = construireUnicode( 18, 18, 18 );
    private static final String H_19_19_19 = construireUnicode( 19, 19, 19 );
    private static final String H_19_20_20 = construireUnicode( 19, 20, 20 );
    private static final String H_19_21_21 = construireUnicode( 19, 21, 21 );
    private static final String H_19_21_22 = construireUnicode( 19, 21, 22 );
    private static final String H_19_21_23 = construireUnicode( 19, 21, 23 );
    private static final String H_19_21_24 = construireUnicode( 19, 21, 24 );
    private static final String H_19_21_25 = construireUnicode( 19, 21, 25 );
    private static final String H_19_21_26 = construireUnicode( 19, 21, 26 );
    private static final String H_19_21_27 = construireUnicode( 19, 21, 27 );

    @Test
    void noConsonneInitiale1() {
        TexteCoreen t = new TexteCoreen(  H_1_1_0 );
        assertEquals( 1, t.noConsonneInitiale( 0 ) );
    }

    @Test
    void noConsonneInitiale2() {
        TexteCoreen t = new TexteCoreen( H_2_1_0 );
        assertEquals( 2, t.noConsonneInitiale( 0 ) );
    }

    @Test
    void noConsonneInitiale3() {
        TexteCoreen t = new TexteCoreen( H_1_1_0 + H_12_1_0 + H_1_1_0 );
        assertEquals( 12, t.noConsonneInitiale( 1 ) );
    }

    @Test
    void noConsonneInitiale4() {
        TexteCoreen t = new TexteCoreen( H_18_1_0 );
        assertEquals( 18, t.noConsonneInitiale( 0 ) );
    }

    @Test
    void noConsonneInitiale5() {
        TexteCoreen t = new TexteCoreen( H_19_1_0 );
        assertEquals( 19, t.noConsonneInitiale( 0 ) );
    }

    @Test
    void noVoyelle1() {
        TexteCoreen t = new TexteCoreen( H_1_1_0 );
        assertEquals( 1, t.noVoyelle( 0 ) );
    }

    @Test
    void noVoyelle2() {
        TexteCoreen t = new TexteCoreen( H_1_2_0 );
        assertEquals( 2, t.noVoyelle( 0 ) );
    }

    @Test
    void noVoyelle3() {
        TexteCoreen t = new TexteCoreen( H_1_1_0 + H_1_10_0 + H_1_1_0 );
        assertEquals( 10, t.noVoyelle( 1 ) );
    }

    @Test
    void noVoyelle4() {
        TexteCoreen t = new TexteCoreen( H_1_20_0 );
        assertEquals( 20, t.noVoyelle( 0 ) );
    }

    @Test
    void noVoyelle5() {
        TexteCoreen t = new TexteCoreen( H_1_21_0 );
        assertEquals( 21, t.noVoyelle( 0 ) );
    }

    @Test
    void noConsonneFinale1() {
        TexteCoreen t = new TexteCoreen( H_1_1_0 );
        assertEquals( 0, t.noConsonneFinale( 0 ) );
    }

    @Test
    void noConsonneFinale2() {
        TexteCoreen t = new TexteCoreen( H_1_1_1 );
        assertEquals( 1, t.noConsonneFinale( 0 ) );
    }

    @Test
    void noConsonneFinale3() {
        TexteCoreen t = new TexteCoreen( H_1_1_0 + H_1_1_13 + H_1_1_0 );
        assertEquals( 13, t.noConsonneFinale( 1 ) );
    }

    @Test
    void noConsonneFinale4() {
        TexteCoreen t = new TexteCoreen( H_1_1_26 );
        assertEquals( 26, t.noConsonneFinale( 0 ) );
    }

    @Test
    void noConsonneFinale5() {
        TexteCoreen t = new TexteCoreen( H_1_1_27 );
        assertEquals( 27, t.noConsonneFinale( 0 ) );
    }

    @Test
    void no() {
        for( int c = NO_PREMIER_CI; c <= NO_DERNIER_CI; ++ c ) {
            for( int v = NO_PREMIERE_VOYELLE; v <= NO_DERNIERE_VOYELLE; ++ v ) {
                for( int d = NO_PREMIER_CF; d <= NO_DERNIER_CF; ++ d ) {
                    String hangeul = construireUnicode( c, v, d );
                    TexteCoreen t = new TexteCoreen( hangeul );
                    assertEquals( c, t.noConsonneInitiale( 0 ) );
                    assertEquals( v, t.noVoyelle( 0 ) );
                    assertEquals( d, t.noConsonneFinale( 0 ) );

                    TexteCoreen t2 = new TexteCoreen( H_1_1_0 + hangeul );
                    assertEquals( c, t2.noConsonneInitiale( 1 ) );
                    assertEquals( v, t2.noVoyelle( 1 ) );
                    assertEquals( d, t2.noConsonneFinale( 1 ) );

                    TexteCoreen t3 = new TexteCoreen( H_1_1_0 + hangeul + H_1_1_0 );
                    assertEquals( c, t3.noConsonneInitiale( 1 ) );
                    assertEquals( v, t3.noVoyelle( 1 ) );
                    assertEquals( d, t3.noConsonneFinale( 1 ) );
                }
            }
        }
    }

    // jamo -> API       : 28
    // hangeul -> API    : 20
    // nombre de hangeul : 5
    // pas un Hangeul.   : 5

    @Test
    void traduireJamo1() {
        TexteCoreen t = new TexteCoreen( H_1_1_0 );
        assertEquals( "\u006b\u0061", t.traduire() );
    }

    @Test
    void traduireJamo2() {
        TexteCoreen t = new TexteCoreen( H_1_1_1 );
        assertEquals( "\u006b\u0061\u006b\u031a", t.traduire() );
    }

    @Test
    void traduireJamo3() {
        TexteCoreen t = new TexteCoreen( H_2_2_2 );
        assertEquals( "\u006b\u0324\u025b\u006b\u031a", t.traduire() );
    }

    @Test
    void traduireJamo4() {
        TexteCoreen t = new TexteCoreen( H_3_3_3 );
        assertEquals( "\u006e\u006a\u0061\u006b", t.traduire() );
    }

    @Test
    void traduireJamo5() {
        TexteCoreen t = new TexteCoreen( H_4_4_4 );
        assertEquals( "\u0074\u006a\u025b\u006e", t.traduire() );
    }

    @Test
    void traduireJamo6() {
        TexteCoreen t = new TexteCoreen( H_5_5_5 );
        assertEquals( "\u0074\u0324\u028c\u006e\u0074\u0255", t.traduire() );
    }

    @Test
    void traduireJamo7() {
        TexteCoreen t = new TexteCoreen( H_6_6_6 );
        assertEquals( "\u027e\u0065\u006e\u0068", t.traduire() );
    }

    @Test
    void traduireJamo8() {
        TexteCoreen t = new TexteCoreen( H_7_7_7 );
        assertEquals( "\u006d\u006a\u028c\u0074\u031a", t.traduire() );
    }

    @Test
    void traduireJamo9() {
        TexteCoreen t = new TexteCoreen( H_8_8_8 );
        assertEquals( "\u0070\u006a\u0065\u006c", t.traduire() );
    }

    @Test
    void traduireJamo10() {
        TexteCoreen t = new TexteCoreen( H_9_9_9 );
        assertEquals( "\u0070\u0324\u006f\u006b", t.traduire() );
    }

    @Test
    void traduireJamo11() {
        TexteCoreen t = new TexteCoreen( H_10_10_10 );
        assertEquals( "\u0073\u0077\u0061\u006d", t.traduire() );
    }

    @Test
    void traduireJamo12() {
        TexteCoreen t = new TexteCoreen( H_11_11_11 );
        assertEquals( "\u0073\u0324\u0077\u025b\u0070", t.traduire() );
    }

    @Test
    void traduireJamo13() {
        TexteCoreen t = new TexteCoreen( H_12_12_12 );
        assertEquals( "\u00f8\u0073", t.traduire() );
    }

    @Test
    void traduireJamo14() {
        TexteCoreen t = new TexteCoreen( H_13_13_13 );
        assertEquals( "\u0074\u0255\u006a\u006f\u0074\u02b0", t.traduire() );
    }

    @Test
    void traduireJamo15() {
        TexteCoreen t = new TexteCoreen( H_14_14_14 );
        assertEquals( "\u0074\u0324\u0255\u0075\u0070\u02b0", t.traduire() );
    }

    @Test
    void traduireJamo16() {
        TexteCoreen t = new TexteCoreen( H_15_15_15 );
        assertEquals( "\u0074\u0255\u02b0\u0077\u028c\u0068", t.traduire() );
    }

    @Test
    void traduireJamo17() {
        TexteCoreen t = new TexteCoreen( H_16_16_16 );
        assertEquals( "\u006b\u02b0\u0077\u0065\u006d", t.traduire() );
    }

    @Test
    void traduireJamo18() {
        TexteCoreen t = new TexteCoreen( H_17_17_17 );
        assertEquals( "\u0074\u02b0\u0079\u0070\u031a", t.traduire() );
    }

    @Test
    void traduireJamo19() {
        TexteCoreen t = new TexteCoreen( H_18_18_18 );
        assertEquals( "\u0070\u02b0\u006a\u0075\u0070\u031a", t.traduire() );
    }

    @Test
    void traduireJamo20() {
        TexteCoreen t = new TexteCoreen( H_19_19_19 );
        assertEquals( "\u0068\u026f\u0074\u031a", t.traduire() );
    }

    @Test
    void traduireJamo21() {
        TexteCoreen t = new TexteCoreen( H_19_20_20 );
        assertEquals( "\u0068\u0270\u0069\u0074\u031a", t.traduire() );
    }

    @Test
    void traduireJamo22() {
        TexteCoreen t = new TexteCoreen( H_19_21_21 );
        assertEquals( "\u0068\u0069\u014b", t.traduire() );
    }

    @Test
    void traduireJamo23() {
        TexteCoreen t = new TexteCoreen( H_19_21_22 );
        assertEquals( "\u0068\u0069\u0074\u031a", t.traduire() );
    }

    @Test
    void traduireJamo24() {
        TexteCoreen t = new TexteCoreen( H_19_21_23 );
        assertEquals( "\u0068\u0069\u0074\u031a", t.traduire() );
    }

    @Test
    void traduireJamo25() {
        TexteCoreen t = new TexteCoreen( H_19_21_24 );
        assertEquals( "\u0068\u0069\u006b\u031a", t.traduire() );
    }

    @Test
    void traduireJamo26() {
        TexteCoreen t = new TexteCoreen( H_19_21_25 );
        assertEquals( "\u0068\u0069\u0074\u031a", t.traduire() );
    }

    @Test
    void traduireJamo27() {
        TexteCoreen t = new TexteCoreen( H_19_21_26 );
        assertEquals( "\u0068\u0069\u0070\u031a", t.traduire() );
    }

    @Test
    void traduireJamo28() {
        TexteCoreen t = new TexteCoreen( H_19_21_27 );
        assertEquals( "\u0068\u0069\u0074\u031a", t.traduire() );
    }
}