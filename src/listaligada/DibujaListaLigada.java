package listaligada;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class DibujaListaLigada extends JPanel{
    private ArrayList<Nodo> nodos;
    private int x=10, y=10;
   
   
    public DibujaListaLigada(ArrayList<Nodo> nodos){
        setBackground(Color.white);
        this.nodos=nodos;
    
    }
       public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for(int i=0;i<nodos.size();i++){
            g2.draw((Rectangle2D)nodos.get(i).getR1());
            g2.draw((Rectangle2D)nodos.get(i).getR2());
            g2.draw((Rectangle2D)nodos.get(i).getR3());
            g2.drawString(String.valueOf(nodos.get(i).getDato()),
                    (int)nodos.get(i).getXdato(),
                    (int)nodos.get(i).getYdato());
            
                if(nodos.get(i).getApuntador()==null)
                g2.drawString(nodos.get(i).getNil(),
                        nodos.get(i).getXnil(),
                        nodos.get(i).getYnil());
            else
                g2.fill((Ellipse2D)nodos.get(i).getC1());
            }
       }
}