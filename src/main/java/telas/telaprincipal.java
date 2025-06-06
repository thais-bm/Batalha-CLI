package telas;
import java.util.ArrayList;
import java.util.List;
import negocios.Jogador;


public class telaprincipal {
    private ArrayList<String> tela;
    int lineamount;
    int linesize;
    ArrayList<ArrayList<String>[]> sprites;

    public telaprincipal() {
        lineamount = 20;
        linesize = 90;
        sprites = new ArrayList<ArrayList<String>>();
        tela = new ArrayList<String>();
        for (int i = 0; i < lineamount; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < linesize; j++) {
                builder.append(" ");
            }
            tela.add(builder.toString());
        }
    }

    public void RenderScreen(){
        for (int i = 0; i < lineamount; i++) {
            System.out.println(tela.get(i));
            }
        }

    public void DrawBatalha(){
        this.Clear();
        tela = telabatalha.DrawUI(this.tela);
        this.RenderScreen();
    }
    
    public void Clear() {
        for (int i = 0; i < tela.size(); i++) {
            String currentline = tela.get(i);
            StringBuilder builder = new StringBuilder(currentline);
            for (int j = 0; j < lineamount; j++) {
                builder.setCharAt(j, ' ');
            }
            tela.set(i, builder.toString());
        }
    }

    public void setPlayerSprite(Jogador jogador) {
        List<String> sprite = jogador.getSprite();
        sprites
    }
}
