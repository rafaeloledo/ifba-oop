package genius.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import genius.Entity.Jogo;
import genius.Entity.ParameterException;

public class InnerButton implements ActionListener{
    
    private Jogo jogo;
    private Botao botao;
    private String btnName;

    public InnerButton(Jogo jogo, Botao botao, String btnName) {
        this.jogo = jogo;
        this.botao = botao;
        this.btnName = btnName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try
        {
            jogo.botaoApertado(botao, btnName);
        }
        catch (ParameterException ex)
        {
            ex.getMessage();
        }
        
    }

}
