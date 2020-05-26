package listaligada;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class ListaLigada extends JFrame{
    private JMenuBar barraMenu;
    private JMenu menuArchivo;
    private JMenuItem itemNuevo;
    private JMenuItem itemAbrir;
    private JMenuItem itemGuardar;
    private JMenuItem itemCerrar;
    private JLabel etiDato,etiNumNodos,numNodos,nodosEncontrados
            ,nodosEncontra;
    private JTextField jtfDato;
    private JRadioButton rbFIFO,rbLIFO;
    private ButtonGroup grupo;
    private JButton bInsertar,bBuscar,bEliminar;
    private DibujaListaLigada panel;
    private ArrayList<Nodo> nodos;
    private int x=10, y=10;
    private Nodo raiz, actual,previo;
    private int size=0;
    private JScrollPane jspPanel;
    ListaLigada(){
        setSize(900,600);
        setTitle("Lista Ligada");
        this.setResizable(false);
        MisComponentes();
    }
    private void MisComponentes(){
        barraMenu = new JMenuBar();
        menuArchivo = new JMenu("Archivo");
        itemNuevo = new JMenuItem("Nuevo");
        itemAbrir = new JMenuItem("Abrir");
        itemGuardar = new JMenuItem("Guardar");
        itemCerrar = new JMenuItem("Cerrar");
        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemAbrir);
        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemCerrar);
        barraMenu.add(menuArchivo);
        barraMenu.setBounds(0,0,300,25);
        add(barraMenu);
        raiz = null;
        actual = null;
        previo = null;
        etiDato = new JLabel("Dato");
        etiNumNodos=new JLabel("Numero de nodos:");
        numNodos = new JLabel ("");
        nodosEncontrados = new JLabel("Nodos encontrados:");
        nodosEncontra = new JLabel("");
        jtfDato= new JTextField();
        rbFIFO = new JRadioButton("FiFo");//Cola
        rbLIFO = new JRadioButton("LiFo");//Pila o Stack
        grupo=new ButtonGroup();
        grupo.add(rbFIFO);
        grupo.add(rbLIFO);
        bInsertar = new JButton("Insertar");
        bBuscar = new JButton("Buscar");
        bEliminar = new JButton("Eliminar");
        nodos = new ArrayList<Nodo>();
        panel = new DibujaListaLigada(nodos);
        jspPanel = new JScrollPane(panel);
        jspPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jspPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.setPreferredSize(new Dimension(0, 900));
        setLayout(null);
        etiNumNodos.setBounds(10,350,120,25);
        add(etiNumNodos);
        numNodos.setBounds(190,350,50,25);
        add(numNodos);
        nodosEncontrados.setBounds(10,400,150,25);
        add(nodosEncontrados);
        nodosEncontra.setBounds(190,400,150,25);
        add(nodosEncontrados);
        etiDato.setBounds(50,50,100,25);
        add(etiDato);
        jtfDato.setBounds(150,50,100,25);
        add(jtfDato);
        rbFIFO.setBounds(50,100,100,25);
        add(rbFIFO);
        rbLIFO.setBounds(150,100,100,25);
        add(rbLIFO);
        jspPanel.setBounds(300,0,580,550);
        add(jspPanel);
        bInsertar.setBounds(100,200,100,25);
        add(bInsertar);
        bBuscar.setBounds(100,250,100,25);
        add(bBuscar);
        bEliminar.setBounds(100,300,100,25);
        add(bEliminar);
        bInsertar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evento){
            int dato=0;
            Nodo apuntador;
            try{
                dato=Integer.parseInt(jtfDato.getText());
            }catch(NumberFormatException ex)
            {JOptionPane.showMessageDialog(null,"Error numerico y dato debe ser !=0");dato=0;}
                if (dato!=0){
                    apuntador = null;//R1
                    Nodo n = new Nodo
                       /*R1*/   (x,y,50,25,
                       /*R2*/    x+50,y,25,25,
                       /*R3*/    x+60,y+10,5,5,
                       /*C*/     x+75,y+10,30,5,
                               dato,apuntador,
                               x+15,y+15,/*cordenadas dato*/
                               x+80,y+15);//Xnull,Ynull//
                    nodos.add(n);
                    panel.repaint();
                    x+=105;
                    if(x>500){
                        x=10;
                        y+=40;
                    }
                    addInEnd(n);
                    System.out.println();
                    imprimeLista();
                }
            }
        });
        bBuscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                int data=0;
                    try{data=Integer.parseInt(jtfDato.getText());
                    }catch(NumberFormatException e){JOptionPane.showMessageDialog(null, "Error numerico");}
            }
        });
        bEliminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                if (rbFIFO.isSelected()){
                    DesenColar();
                    //int first = DesEncolar;
                    nodos.remove(0);
                    x=10;
                     y=10;
                    for(int i=0;i<size;i++)
                    {
                      nodos.get(i).setXdato(x+15);
                      nodos.get(i).setXnil(x+80);
                      nodos.get(i).setYdato(y+15);
                      nodos.get(i).setYnil(y+15); 
                      nodos.get(i).getR1().setFrame(x, y, 50, 25);
                      nodos.get(i).getR2().setFrame(x+50, y, 25, 25);
                      nodos.get(i).getR3().setFrame(x+60, y+10, 5, 5);
                      nodos.get(i).getC1().setFrame(x+75, y+10, 30, 5);
                      x+=105;

                        if(x>500 && y>40 && x<9){
                                x=10;
                                y-=40;
                            }

                    }
                        }
                if(rbLIFO.isSelected()){
                    nodos.remove(Pop());
                }
                imprimeLista();
                panel.repaint();
            }
        });
        itemCerrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            System.exit(0);
            }
        });
      itemAbrir.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evento){
            //condicion guardar
            Scanner sc=null;
            nodos.clear();
            raiz=null;
            actual=null;
            panel.repaint();
            Nodo apuntador;
            try{
                x=y=10;
                String aux="";
                JFileChooser ar = new JFileChooser();
                ar.showOpenDialog(null);
                File abre = ar.getSelectedFile();
                FileReader archi = new FileReader(abre);
                sc = new Scanner(archi);
                while((aux=sc.next())!=null){
                    apuntador = null;//R1
                    Nodo n = new Nodo
                       /*R1*/   (x,y,50,25,
                       /*R2*/    x+50,y,25,25,
                       /*R3*/    x+60,y+10,5,5,
                       /*C*/     x+75,y+10,30,5,
                               Integer.parseInt(aux),apuntador,
                               x+15,y+15,/*cordenadas dato*/
                               x+80,y+15);//Xnull,Ynull//
                    nodos.add(n);
                    panel.repaint();
                    x+=105;
                    if(x>500){
                        x=10;
                        y+=40;
                    }
                    EnColar(n);
                    System.out.println("Lista");
                    imprimeLista();
                    
                }
                sc.close();
                
            }catch(Exception ex){JOptionPane.showMessageDialog(null, "Error Abrir Archivo");}
            finally{
                try{
                    
                    if(null!= sc)
                        sc.close();
                }catch(Exception ex2){ex2.printStackTrace();
                
                }
            }
        }
    });
    
        itemGuardar.addActionListener(new ActionListener(){
            private int C;
            public void actionPerformed(ActionEvent e){
                try{
                    File fichero = new File("ArchivoLista.txt");
                    if(!fichero.exists())
                        fichero.createNewFile();
                    FileWriter fw= new FileWriter(fichero);
                    BufferedWriter bw = new BufferedWriter(fw);
                    for(int i=0;i<nodos.size();i++){
                        //bw = new BufferedWriter(new FileWriter(fichero));
                        bw.write(nodos.get(i).getDato()+"\n");
                    }
                    bw.close();
                }catch(Exception ex){}
            }
        });
        //JOptionPane.showMessageDialog(null,"Error al abrir archivo"
    }
    ///METODOS DE NUESTRA PROGRAMACIÃ“N///
    public boolean IsEmpty(){
        return raiz==null;
    }
    public int getTama(){
        return size;
    }
    public void addInEnd(Nodo n){
        if(IsEmpty())
            raiz=actual=n;
            else{
                Nodo aux = actual;
                    while(aux.getApuntador()!=null)
                        aux=aux.getApuntador();/*Asignamos el siguieete nodo*/
                        aux.setApuntador(n); /* Enlazar nodo por referencia*/
                        /*n.setApuntador(aux); /*Enlazar nodo por apuntador*/
            }
            size++;
            numNodos.setText(""+size);
    }
    public void EnColar(Nodo n){
        if(IsEmpty())
            raiz=actual=n;
        else{
            Nodo aux = actual;
                while(aux.getApuntador()!=null)
                    aux=aux.getApuntador();/*Asignamos el siguieete nodo*/
                    aux.setApuntador(n); /* Enlazar nodo por referencia*/
                    /*n.setApuntador(aux); /*Enlazar nodo por apuntador*/
            }
            size++;
            numNodos.setText(""+size);
    }
    public void imprimeLista(){
        Nodo aux=actual;
        if(IsEmpty()){
            System.out.println("Error");
        }else{
            while(aux.getApuntador()!=null){
                System.out.print(aux.getDato()+"----->");
                aux=aux.getApuntador();
            } 
        System.out.print(aux.getDato()+"----->");
        }
    }
    public void DesenColar(){
        Nodo aux = actual;
        if(actual==null){//Cuando actual es nulo, no hay nada que desencolar
            JOptionPane.showMessageDialog(null, "Error FiFo vacio", "Error", 0);
        }
        else {
            aux=aux.getApuntador();
            actual = aux;
        }
        size --;
    }
    public void Push(Nodo n){
        if(IsEmpty())
            raiz = actual = n;
        else{
            Nodo aux = actual;
            while(aux.getApuntador()!=null)
                aux=aux.getApuntador();/*Asignamos el siguieete nodo*/
                aux.setApuntador(n); 
        }
        size++;
    }
    public int Pop(){
        Nodo aux = actual;
        int retorno;
        if(aux == null)
            JOptionPane.showMessageDialog(null,"Error LiFo vacio","Error",0);
        else{
            while(aux.getApuntador()==null){
                aux = aux.getApuntador();
                if(aux.getApuntador()==null)
                    break;
            }
            aux = null;
        }
        size--;
        return size;
    }
    public static void main(String[] args) {
        ListaLigada fr = new ListaLigada();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}