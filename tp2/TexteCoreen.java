package tp2;


import java.util.ArrayList;

public class TexteCoreen {
    private static final String [] TABLE_CONSONNE_INIT = 
            {"","\u006B","\u006b\u0324","\u006e","\u0074","\u0074\u0324"
            ,"\u027e","\u006d","\u0070","\u0070\u0324","\u0073","\u0073\u0324"
            ,"","\u0074\u0255","\u0074\u0255\u0324","\u0074\u0255\u02b0"
            ,"\u006b\u02b0","\u0074\u02b0","\u0070\u02b0","\u0068","\u006c"
            ,"\u006b\u031a","\u0074\u031a","\u0070\u031a"};
    private static final String [] TABLE_VOYELLE = 
            {"","\u0061","\u025b","\u006a\u0061","\u006a\u025b","\u028c",
            "\u0065","\u006a\u028c","\u006a\u0065","\u006f","\u0077\u0061"
            ,"\u0077\u025b","\u00f8","\u006a\u006f","\u0075","\u0077\u028c"
            ,"\u0077\u0065","\u0079","\u006a\u0075","\u026f","\u0270\u0069"
            ,"\u0069"};
    private static final String [] TABLE_CONSONNE_FIN = 
            {"","\u006b\u031a","\u006b\u031a","\u006b","\u006e","\u006e\u0074"
            + "\u0255","\u006e\u0068","\u0074\u031a","\u006c","\u006b","\u006d",
            "\u0070","\u0073","\u0074\u02b0","\u0070\u02b0","\u0068","\u006d",
            "\u0070\u031a","\u0070\u031a","\u0074\u031a","\u0074\u031a",
            "\u014b","\u0074\u031a","\u0074\u031a","\u006b\u031a","\u0074\u031a"
            ,"\u0070\u031a","\u0074\u031a","\u006b\u0324","\u0073\u0324",
            "\u027e"};

    
    protected ArrayList<Hangeul> texteHang = new ArrayList<>();
    
    public TexteCoreen(String texte ) {
        if(!texte.isEmpty()) {
            for(int i = 0 ; i < texte.length() ; i++) {
                texteHang.add(new Hangeul(texte.charAt(i)));
            }
        }
    }
    public void testTable() {
    	String test = TABLE_CONSONNE_INIT[14] + TABLE_VOYELLE[14] + 
    			TABLE_CONSONNE_FIN[14];
    	System.out.println(test);
    }

    public int noConsonneInitiale( int position ){
        return Integer.valueOf(texteHang.get(position).consonneInit);
    }

    public int noVoyelle( int position ) {
        return Integer.valueOf(texteHang.get(position).voyelle);
    }

    public int noConsonneFinale( int position ) {
        return Integer.valueOf(texteHang.get(position).consonneFin);
    }

    public String traduire() {
        String reponse = "";
        correctionPhon();
        for ( Hangeul x : texteHang) {
            x.consonneInit = TABLE_CONSONNE_INIT
                    [Integer.valueOf(x.consonneInit)];
            x.voyelle = TABLE_VOYELLE[Integer.valueOf(x.voyelle)];
            x.consonneFin = TABLE_CONSONNE_FIN[Integer.valueOf(x.consonneFin)];
            reponse += x.consonneInit + x.voyelle + x.consonneFin;
        }
        return reponse;
    }
    private void correctionPhon() {    
        for(int i = 0 ; i < texteHang.size() -1 ; i++) {
            String concatenation = texteHang.get(i).consonneFin 
                    +"/"+ texteHang.get(i + 1).consonneInit;
                switch (concatenation ) {
                    case "1/8":
                    case "1/7":
                    case "1/12": 
                        setPhon(3, 0 , i);
                        break;  
                    case "3/4":
                    case "7/4":
                    case "18/4":
                    case "19/4":
                    case "20/4":
                    case "23/4":
                    case "25/4": 
                        setPhon(0, 22 , i);
                        break;  
                    case "3/12":
                    case "18/12": 
                        setPhon(0, 10, i);
                        break;  
                    case "6/4":
                    case "20/3": 
                        setPhon(4, 22, i);
                        break;
                    case "6/12":
                    case "15/12": 
                        setPhon(8, 19, i);
                        break;  
                    case "8/3":
                    case "8/6": 
                        setPhon(0, 20, i);
                        break;  
                    case "8/12":
                    case "8/19":
                    case "27/6": 
                        setPhon(30, 0, i);
                        break;  
                    case "12/4":
                    case "15/4": 
                        setPhon(8, 22, i);
                        break;  
                    case "13/4":
                    case "13/12": 
                        setPhon(8, 17, i);
                        break;  
                    case "17/3":
                    case "17/7": 
                        setPhon(16, 0 , i);
                        break;  
                    case "20/10":
                    case "20/12": 
                        setPhon(0, 29, i);
                        break; 
                    case "20/13":
                    case "21/12":
                    case "21/19":
                    case "22/12":
                    case "22/19":
                    case "23/12":
                    case "23/19":
                    case "25/12":
                    case "27/3":
                    case "27/7":
                    case "27/12": 
                        setPhon(0, 15, i);
                        break;  
                    case "24/12":
                    case "26/12": 
                        setPhon(0, 19 ,i);
                        break;  
                    case "1/1": 
                        setPhon(0, 21, i);
                        break;  
                    case "1/3": 
                        setPhon(21, 0 , i);
                        break;  
                    case "1/6": 
                        setPhon(3, 3, i);
                        break;  
                    case "2/12": 
                        setPhon(28, 19, i);
                        break;  
                    case "2/19": 
                        setPhon(28, 0, i);
                        break;  
                    case "4/6": 
                        setPhon(8, 20, i);
                        break;  
                    case "5/12": 
                        setPhon(4, 13, i);
                        break;  
                    case "9/12": 
                        setPhon(8, 1, i);
                        break;  
                    case "10/12": 
                        setPhon(8, 7, i);
                        break;  
                    case "11/12": 
                        setPhon(8, 8, i);
                        break;  
                    case "12/12": 
                        setPhon(8, 10, i);
                        break;  
                    case "14/12": 
                        setPhon(8, 18, i);
                        break;  
                    case "16/6": 
                        setPhon(0, 3, i);
                        break;  
                    case "17/1": 
                        setPhon(11, 0, i);
                        break;  
                    case "17/6": 
                        setPhon(16, 3, i);
                        break;  
                    case "17/8": 
                        setPhon(0, 23, i);
                        break;  
                    case "19/12": 
                        setPhon(12, 0, i);
                        break;  
                    case "21/6": 
                        setPhon(4, 0, i);
                        break;  
                    case "24/7": 
                        setPhon(0, 4, i);
                        break;  
                    case "27/1": 
                        setPhon(15, 21, i);
                        break;  
                    case "27/4": 
                        setPhon(15, 22, i);
                        break;
                }
        }
    }
    private void setPhon(int x, int y, int i) {
        if ( x == 0 && y !=0) {
            texteHang.get(i+1).consonneInit = "" + y;
        }else if (x != 0 && y ==0 ) {
            texteHang.get(i).consonneFin = "" + x;
            texteHang.get(i+1).consonneInit = "0";
        }else {
            texteHang.get(i+1).consonneInit = "" + y;
            texteHang.get(i).consonneFin = "" + x;
        }
    }
}
