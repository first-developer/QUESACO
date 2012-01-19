//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package ihm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import tools.Msg;

import classifieur.Categorie;
import classifieur.Classifieur;
import classifieur.Observation;
import classifieur.ObservationString;

//Class: Ihm
//========================================================
public class Ihm extends JFrame {

	private static final long serialVersionUID = 1L;
	
	static final int HTEXT = 10; // dimensions des zones de textes
    static final int WTEXT = 30;
    static final int HAUT = 600; // dimensions par defaut de de la frame
    static final int LARG = 800;
    static final String FORMAT = ".png"; // format (.png, .jpg, .tiff, ...)

    // L'application interface:
    String[] caracteristiques ;
    // Nom du fichier parametre de l'application:
    //   + ".bin": serialise
    //   + ".png" : image correspondante
    
    String nomFichier;
    ArrayList<Categorie> categorieList;
    Classifieur classeur;
    
    
    
    // Variables d'etats de l'IHM
    // observation en cours de saisie:
    Observation obs ;
    // caracteristique selectionnee
    String caracteristique;
    String valeurCaracteristique;

    // Composants d'interface
    ScrollPane vue = new ScrollPane(); // vue scrollable sur l'image
    ImageCanvas canvas = new ImageCanvas(); // affichage de l'image
    JButton raz = new JButton("RAZ");
    JComboBox selectCaracteristique; // liste de selection des caracteristiques
    JTextField saisieCaracteristique; // saisie de la valeur de la caracteristique selectionne
    JTextArea textObservation; // caracteristiques de l'observation en cours
    JTextArea CatListOnObservation; // categories se classant sous une observation

    Ihm(String fileName) throws ParserConfigurationException, SAXException, FileNotFoundException, IOException, ClassNotFoundException, InterruptedException {
        this.nomFichier = fileName;
        classeur = new Classifieur();
        classeur.load(nomFichier+".bin");
        
        setTitle("QUESACO?");

        // Chargement de l'image et dimensionnement de la vue
        vue.setSize(LARG, HAUT / 2);
        vue.add(canvas);
        classeur.show(nomFichier, FORMAT);
        canvas.setImage(nomFichier + FORMAT);

        // Caracteristiques: liste de selection
        // "en dur" pour le test
        
        // remplir le tableau de caractéristiques
        int length = classeur.getListIntituleTypo().size();
        Msg.puts(Integer.toString(length));
        Iterator<String> it  = classeur.getListIntituleTypo().iterator();
        caracteristiques = new String[length];
        int i=0;
        while(it.hasNext()) {
        	this.caracteristiques[i] = it.next();
        	Msg.puts(caracteristiques[i]);
        	i++;
        }
        selectCaracteristique = new JComboBox(this.caracteristiques);
        // selection intiale par defaut
        selectCaracteristique.setSelectedIndex(0);
        caracteristique = (String) selectCaracteristique.getSelectedItem();

        // Zone de saisie des valeurs
        saisieCaracteristique = new JTextField(WTEXT);
        saisieCaracteristique.setBorder(BorderFactory.createLineBorder(Color.black));

        // Zone d'affichage de l'observation en cours
        this.textObservation = new JTextArea(HTEXT, WTEXT);
        textObservation.setEditable(false);
        textObservation.setBorder(BorderFactory.createLineBorder(Color.black));
        textObservation.setText("OBSERVATION:\n");
        
        // Zone d'affichage des categories se classant sous une observation
        this.CatListOnObservation = new JTextArea(HTEXT, WTEXT);
        CatListOnObservation.setEditable(false);
        CatListOnObservation.setBorder(BorderFactory.createLineBorder(Color.black));
        CatListOnObservation.setText("CATEGORIES OBERSERVEES:\n");
        
        // Ajout et positionnement des composants d'interface
        Container cp = getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(vue);
        cp.add(raz);
        cp.add(selectCaracteristique);
        cp.add(saisieCaracteristique);
        cp.add(textObservation);
        cp.add(CatListOnObservation);

        // Ecouteurs d'evenements
        selectCaracteristique.addActionListener(new SelectListener());
        saisieCaracteristique.addActionListener(new InputListener());
        raz.addActionListener(new RAZListener());
        this.addWindowListener(new QuesacoListener());

    }

    class SelectListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            caracteristique = (String) selectCaracteristique.getSelectedItem();
        }
    }

    class InputListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            valeurCaracteristique = saisieCaracteristique.getText();
            try {
            	update();
            }catch (Exception e) {
				Msg.puts("Ihm::InputListener.actionPerformed.update: erreur" + e.getMessage());
			}
            
            saisieCaracteristique.setText("");
        }
    }

    public void update() throws IOException, InterruptedException {
    	
    	// Update observations
        textObservation.append("\t- " + this.caracteristique + ": " + this.valeurCaracteristique);
        textObservation.append("\n");
        ObservationString ob = new ObservationString( this.caracteristique, this.valeurCaracteristique);
        obs.addObservationItem(ob);
        CatListOnObservation.setText("CATEGORIES OBERSERVEES:\n");
        
        // update categories
        String obsFileName = nomFichier + "_obs";
        classeur.showClassification(obs, obsFileName, FORMAT);
        canvas.setImage(obsFileName+FORMAT);
        
        // show categories classify under obs
        ArrayList<Categorie> cat_list = classeur.classer(obs);
        if (!cat_list.isEmpty()) {
        	for ( Categorie cat : cat_list) {
            	CatListOnObservation.append("\t- " + cat.getNom());
            	CatListOnObservation.append("\n");
            }	
        }
        else {
        	CatListOnObservation.append("Aucune catégorie pour cette observation");
        }
        
    // ...
    }

    class RAZListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            selectCaracteristique.setSelectedIndex(0);
            caracteristique = (String) selectCaracteristique.getSelectedItem();
            valeurCaracteristique = "";
            saisieCaracteristique.setText("");
            textObservation.setText("OBSERVATION:\n");
            CatListOnObservation.setText("CATEGORIES OBERSERVEES:\n");
            obs = new Observation();
        }
    }

    class ImageCanvas extends Canvas {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		java.awt.Image image;

        void setImage(String fileName) {
            image = this.getToolkit().createImage(fileName);
            repaint(0);
        }

        @Override
        public synchronized void paint(Graphics g) {
            if (image != null) {
                g.drawImage(image, 0, 0, this);
            }
        }
    }

    class QuesacoListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    public static void main(String argv[]) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException, ClassNotFoundException, InterruptedException {
        if (argv.length != 1) {
            System.err.println("usage: java ihm.TestQuesaco <fichier> (sans suffixe)");
        } else {

            Ihm ihm = new Ihm(argv[0]);
            ihm.pack();
            ihm.setSize(LARG, HAUT);
            ihm.setVisible(true);
        }
    }
  
}