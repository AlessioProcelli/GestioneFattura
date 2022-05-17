/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Home;

import FiltraFatture.ControllerFiltraFattura;
import MVC.HomeController;
import MVC.HomeModel;
import FiltraFatture.ModelFiltraFattura;
import MVC.View;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.IntelliJTheme;
import FiltraFatture.FiltraFatture;
import gestorefatture.AggiungiFattura;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import static javax.swing.UIManager.put;

/**
 *
 * @author Alessio
 */
public class Home extends View{ 
    final String PATH_TEMA="/temi/";
    final String NOME_TEMA="Cyan.theme.json";
    final String PATH_iCONA="/res/icon.png";
    final int ROUND_BORDO=8;
    final int BORDO_CECK=1;
    private AggiungiFattura aggiungiFattura;
    private MenùDiNavigazione menù;
    private FiltraFatture filtraFatture;
    //private RiepilogoFatture riepilogoFatture;
    private JPanel schermata;
    private HomeController homeController;
    private HomeModel homeModel;
    public JPanel getSchermata() {
        return schermata;
    }

    /**
     * Creates new form Home
     */
    public Home(HomeController hc, HomeModel hm) {
        super(hc, hm);
        initComponents();
        temaSetUp();
        
        
        homeController=hc;
        homeModel=hm;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ModelFiltraFattura mf= new ModelFiltraFattura();
        ControllerFiltraFattura cf= new ControllerFiltraFattura(mf);
        filtraFatture=new FiltraFatture(cf,mf);
        aggiungiFattura=new AggiungiFattura();
        menù=new MenùDiNavigazione(this);
        schermata=(JPanel) filtraFatture.getContentPane();
        
        Container panelMenu=menù.getContentPane();
        
        this.setLayout(new BorderLayout());
        this.add(panelMenu,BorderLayout.NORTH);
        this.add(schermata,BorderLayout.CENTER);
        this.validate();
        this.repaint();
        
    }

    public HomeController getHomeController() {
        return homeController;
    }
    
    @Override
    public void update(){
       this.remove(schermata);
       if(homeModel.isAggiungiFattura())
           schermata=(JPanel) aggiungiFattura.getContentPane();
       else if(homeModel.isFiltraFatture())
           schermata=(JPanel) filtraFatture.getContentPane();
       /*
       else
           //schermata=(JPanel) riepilogoFatture.getContentPane();
       */
       this.add(schermata, BorderLayout.CENTER);
       this.validate();
       this.repaint();
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestore Fatture");
        setLocation(new java.awt.Point(0, 0));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void temaSetUp() {
        IntelliJTheme.setup( Home.class.getResourceAsStream(PATH_TEMA+NOME_TEMA ) );
        UIManager.put( "Button.arc" , ROUND_BORDO );
        UIManager.put( "Component.arc" ,ROUND_BORDO );
        UIManager.put( "ProgressBar.arc" , ROUND_BORDO );
        UIManager.put( "TextComponent.arc" ,ROUND_BORDO );
        UIManager.put( "Component.arrowType" , "chevron" );
        UIManager.put( "Component.focusWidth" , BORDO_CECK );
        UIManager.put( "Button.background" , Color.decode("#E4E6EB"));
        UIManager.put( "Borders.color" ,Color.decode("#28A4C3"));
        UIManager.put( "Component.focusColor" ,Color.decode("#648DB9"));
        try {
            Image img=ImageIO.read(getClass().getResource("../res/icon.png"));
            this.setIconImage(img);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        
        
        
        
    }

  
        
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}