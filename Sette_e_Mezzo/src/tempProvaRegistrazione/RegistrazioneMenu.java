package tempProvaRegistrazione;

import dominio.gui.Sfondo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistrazioneMenu extends JFrame {
    
    private Sfondo sfondo;
    private JButton fatto, riprova;
    private JTextField id, email;
    private JPasswordField password;
    private JLabel richiediReg, idLabel, passwordLabel, emailLabel, messRegFallita;
    private String idString = null, passwordString = null, emailString = null;
    private boolean regConfermata = false;
    
    public RegistrazioneMenu() {
        setTitle("Registrazione");
        setPreferredSize(new Dimension(1000, 800));
	setMinimumSize(new Dimension(1000, 800));		
	pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setLocationRelativeTo(null);       
        
        inizializzaGUI();
        
        setVisible(true);
    }
    
    private void inizializzaGUI() {
        sfondo = new Sfondo("dominio/immagini/sfondo.png", 995, 765);
        sfondo.setBounds(0, 0, 1000, 800);
        add(sfondo);
        
        fatto = new JButton(caricaImmagine("dominio/immagini/fatto.png"));
        riprova = new JButton(caricaImmagine("dominio/immagini/riprova.png"));
        id = new JTextField();
        password = new JPasswordField();
        email = new JTextField();
        richiediReg = new JLabel(caricaImmagine("dominio/immagini/richiediRegistrazione.png"));
        idLabel = new JLabel(caricaImmagine("dominio/immagini/idLogin.png"));
        passwordLabel = new JLabel(caricaImmagine("dominio/immagini/passwordLogin.png"));
        emailLabel = new JLabel(caricaImmagine("dominio/immagini/emailLogin.png"));
        
        Font font = new Font("Registrazione", 1, 40);
        id.setFont(font);
        password.setFont(font);
        email.setFont(font);
        
        fatto.setBounds(this.getWidth()/2 - 100, 600, 200, 80);
        riprova.setBounds(this.getWidth()/2 - 100, 600, 200, 80);
        id.setBounds(510, 250, 300, 80);
        password.setBounds(510, 350, 300, 80);
        email.setBounds(510, 450, 300, 80);
        richiediReg.setBounds(this.getWidth()/2 - 271, 30, 542, 119);
        idLabel.setBounds(211, 251, 120, 78);
        passwordLabel.setBounds(100, 338, 342, 105);
        emailLabel.setBounds(173, 458, 195, 75);
        
        fatto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                idString = id.getText();
                passwordString = Arrays.toString(password.getPassword());
                if(checkReg(idString, passwordString, emailString)) {
                    // registra e salva nel DB
                } else {
                    regFallita();
                }
            };
        });
        
        riprova.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                sfondo.remove(riprova);
                sfondo.remove(messRegFallita);
                sfondo.add(fatto);
                sfondo.add(id);
                sfondo.add(password);
                sfondo.add(email);
                sfondo.add(richiediReg);
                sfondo.add(idLabel);
                sfondo.add(passwordLabel);
                sfondo.add(emailLabel);
                sfondo.repaint();
            };
        });
        
        sfondo.add(fatto);
        sfondo.add(id);
        sfondo.add(password);
        sfondo.add(email);
        sfondo.add(richiediReg);
        sfondo.add(idLabel);
        sfondo.add(passwordLabel);
        sfondo.add(emailLabel);
    }
    
    private boolean checkReg(String id, String pass, String email) {
        // controlla da server e db se la reg è riuscita
        
        return false; // temporaneo
    }
    
    private void regFallita() {
        Font font = new Font("RegFallitaMsg", Font.BOLD, 60);
        messRegFallita = new JLabel("<html>Registrazione non riuscita,<br>"
                                + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp riprova per favore</html>");
        messRegFallita.setFont(font);
        messRegFallita.setForeground(Color.black);
        messRegFallita.setBounds(this.getWidth()/2 - 380, 150, 800, 400);
        
        id.setText("");
        password.setText("");
        
        sfondo.add(messRegFallita);
        sfondo.add(riprova);
        sfondo.remove(fatto);
        sfondo.remove(id);
        sfondo.remove(password);
        sfondo.remove(email);
        sfondo.remove(richiediReg);
        sfondo.remove(idLabel);
        sfondo.remove(passwordLabel);
        sfondo.remove(emailLabel);
        sfondo.repaint();
    }
    
    private ImageIcon caricaImmagine(String nome){
	ClassLoader loader = getClass().getClassLoader();
	URL percorso = loader.getResource(nome);
	return new ImageIcon(percorso);
    }
}