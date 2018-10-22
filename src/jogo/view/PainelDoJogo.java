package jogo.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelDoJogo extends JPanel {

	private PainelPrincipal painelPrincipal;
	
	public PainelDoJogo() {
		setLayout(new BorderLayout());
		
		JLabel labelJogadas = new JLabel(" :X | O: ");
		
		JLabel labelvx = new JLabel("0");
		JLabel labelvo = new JLabel("0");
		
		JPanel painelVitorias = new JPanel();
		painelVitorias.add(labelvx);
		painelVitorias.add(labelJogadas);
		painelVitorias.add(labelvo);
		add(painelVitorias, BorderLayout.NORTH);
		
		painelPrincipal = new PainelPrincipal(labelvx, labelvo);
		add(painelPrincipal, BorderLayout.CENTER);
		
		JButton restart = new JButton("Restart");
		restart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painelPrincipal.restart();
			}
		});
		
		JPanel painelBotao = new JPanel();
		painelBotao.add(restart);
		add(painelBotao, BorderLayout.SOUTH);
	}
}
