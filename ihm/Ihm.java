
package ihm;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author carre
 */
public class Ihm extends JFrame {

    static final int HTEXT = 10; // dimensions des zones de textes
    static final int WTEXT = 30;
    static final int HAUT = 600; // dimensions par defaut de de la frame
    static final int LARG = 800;
    static final String FORMAT = ".png"; // format (.png, .jpg, .tiff, ...)

    // L'application interfacee:
    // Classifieur classeur = ...
    // "en dur" pour le test:
    String[] caracteristiques = {"forme", "taille", "feuilles"};
    // Nom du fichier parametre de l'application:
    //   + ".bin": serialise
    //   + ".png" : image correspondante
    String nomFichier;

    // Variables d'etats de l'IHM
    // observation en cours de saisie:
    // Observation obs = ...
    // caracteristique selectionnee:
    String caracteristique;
    String valeurCaracteristique;

    // Composants d'interface
    ScrollPane vue = new ScrollPane(); // vue scrollable sur l'image
    ImageCanvas canvas = new ImageCanvas(); // affichage de l'image
    JButton raz = new JButton("RAZ");
    JComboBox selectCaracteristique; // liste de selection des caracteristiques
    JTextField saisieCaracteristique; // saisie de la valeur de la caracteristique selectionne
    JTextArea textObservation; // caracteristiques de l'observation en cours

    Ihm(String fileName) {
        this.nomFichier = fileName;

        setTitle("QUESACO?");

        // Chargement de l'image et dimensionnement de la vue
        vue.setSize(LARG, HAUT / 2);
        vue.add(canvas);
        canvas.setImage(nomFichier + FORMAT);

        // Caracteristiques: liste de selection
        // "en dur" pour le test
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

        // Ajout et positionnement des composants d'interface
        Container cp = getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(vue);
        cp.add(raz);
        cp.add(selectCaracteristique);
        cp.add(saisieCaracteristique);
        cp.add(textObservation);

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

        public void actionPerformed(ActionEvent e) {
            valeurCaracteristique = saisieCaracteristique.getText();
            update();
            saisieCaracteristique.setText("");
        }
    }

    public void update() {
        textObservation.append("\t- " + this.caracteristique + ": " + this.valeurCaracteristique);
        textObservation.append("\n");
    // ...
    }

    class RAZListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            selectCaracteristique.setSelectedIndex(0);
            caracteristique = (String) selectCaracteristique.getSelectedItem();
            valeurCaracteristique = "";
            saisieCaracteristique.setText("");
            textObservation.setText("OBSERVATION:\n");
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

    public static void main(String argv[]) {
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
