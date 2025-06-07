package utilidades;

public class ComandosUteis {
    public static String autocentraliza(String string, int sizelimit) {
        String newsubstr = "";
        int leftmargin = 0;
        int rightmargin = 0;
        if (string.length() < sizelimit) {
            leftmargin = (int) ((double) (sizelimit - string.length()) / 2.0 );
            rightmargin = (int) (((double) (sizelimit - string.length()) / 2.0 ) + 0.5);
            for (int i = 0; i < leftmargin; i++) {newsubstr += " ";}
            newsubstr += string;
            for (int i = 0; i < rightmargin; i++) {newsubstr += " ";}
        } else {
            newsubstr += string.substring(0, sizelimit);
        }
        return newsubstr;
    }

}
