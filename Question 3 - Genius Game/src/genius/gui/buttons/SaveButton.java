package genius.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import genius.Entity.Jogo;

public class SaveButton implements ActionListener{

    private Botao botao;
    private Jogo jogo;

    
    public SaveButton(Botao botao, Jogo jogo) {
        this.botao = botao;
        this.jogo = jogo;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        botao.getSom().play();
        JFileChooser jfc = new JFileChooser();
        jfc.showSaveDialog(botao);
        File archive = jfc.getSelectedFile();
        
        ObjectOutputStream oos = null;
        try
        {
            FileOutputStream fos = new FileOutputStream(archive);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(jogo);
            oos.flush();
            JOptionPane.showMessageDialog(botao, "Salvo com sucesso.");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(botao, "Erro ao salvar."); 
        }
        
    }
    
}
