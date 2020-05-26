package listaligada;
import java.awt.*;
import java.awt.geom.*;
public class Nodo{
    private int dato;
    private Nodo apuntador; 
    private Rectangle2D R1,R2,R3;
    private Ellipse2D C1;
    private int Xdato, Ydato;
    private String nil="Null";
    private int Xnil,Ynil;
    Nodo(double r1x, double r1y, double r1w, double r1h,
        double r2x, double r2y, double r2w, double r2h,
        double r3x, double r3y, double r3w, double r3h,
        double c1x, double c1y, double c1w, double c1h,
        int dato, Nodo apuntador,int Xdato, int Ydato,int Xnil,int Ynil){
       
        this.dato=dato;
        this.Xdato=Xdato;
        this.Ydato=Ydato;
        this.Xnil=Xnil;
        this.Ynil=Ynil;
        this.apuntador=apuntador;
        R1 = new Rectangle2D.Double(r1x,r1y,r1w,r1h);
        R2 = new Rectangle2D.Double(r2x,r2y,r2w,r2h);
        R3 = new Rectangle2D.Double(r3x,r3y,r3w,r3h);
        C1 = new Ellipse2D.Double(c1x,c1y,c1w,c1h);
    }
    public int getXnil(){
        return Xnil;
        
    }
    public int getYnil(){
        return Ynil;
    }
    public void setXnil(int x){
        Xnil=x;
    }
    public void setYnil(int y){
        Ynil=y;
    }
    
    
    public String getNil(){
        return nil;
    }
 
    public int getDato(){
        return dato;
    }
    public void setDato(int dato){
        this.dato = dato;
    }
    public Nodo getApuntador(){
        return apuntador;
    }
    public void setApuntador(Nodo apuntador){
        this.apuntador = apuntador;
    }
    public Rectangle2D getR1() {
        return R1;
    }
    public Rectangle2D getR2() {
        return R2;
    }
    public Rectangle2D getR3() {
        return R3;
    }

    public Ellipse2D getC1() {
        return C1;
    }

    public int getXdato() {
        return Xdato;
    }

    public void setXdato(int Xdato) {
        this.Xdato = Xdato;
    }

    public int getYdato() {
        return Ydato;
    }

    public void setYdato(int Ydato) {
        this.Ydato = Ydato;
    }
}