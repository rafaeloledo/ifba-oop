package genius.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import genius.Entity.Jogo;

public class PauseButton implements ActionListener{

    private Botao botao;
    private Jogo jogo;

    public PauseButton(Botao botao, Jogo jogo) {
        this.botao = botao;
        this.jogo = jogo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        botao.getSom().play();

        if(jogo.isPause()) 
        {
            jogo.setPause(false);
        }
        else 
        {
            jogo.setPause(true);
        }           		
        
    }
    
}
