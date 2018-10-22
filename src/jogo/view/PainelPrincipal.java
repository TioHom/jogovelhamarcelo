package jogo.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import jogo.controler.IControladorJogoVelha;
import jogo.controler.FabricaControladorJogoVelha;

public class PainelPrincipal extends JPanel {

	private IControladorJogoVelha controlador;
	private JLabel labelvx;
	private JLabel labelvo;
	
	public PainelPrincipal(JLabel labelvx, JLabel labelvo) {
		this.labelvx = labelvx;
		this.labelvo = labelvo;
		controlador = FabricaControladorJogoVelha.create();
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				int indexLinha = x / calculaMenorDimensao();
				int indexColuna = y / calculaMenorDimensao();
				
				controlador.usuarioClicou(indexLinha, indexColuna);
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		int size = calculaMenorDimensao();
		
		// desenha linhas
		g2.setColor(Color.red);		
		for(int i = 1; i <= 2; i++)
			g2.drawLine(size * i, 0, size * i, size * 3);
		for(int j = 1; j <= 2; j++)
			g2.drawLine(0, size * j, size * 3, size * j);
		
		// desenha circulos e xizes
		g2.setColor(Color.black);
		for(int i = 0; i <= 2; i++)
			for(int j = 0; j <= 2; j++) {
				if(controlador.temCirculo(i, j)) {
					g2.drawOval(i * size + 10, j * size + 10, size - 20, size - 20);
				}
				if(controlador.temXis(i, j)) {
					g2.drawLine(i * size + 10, j * size + 10, 
							(i + 1) * size - 10, (j + 1) * size - 10);
					g2.drawLine((i + 1) * size - 10, j * size + 10, 
							i * size + 10, (j + 1) * size - 10);
				}
			}
		
		labelvx.setText("" + controlador.getVitoriasXis());
		labelvo.setText("" + controlador.getVitoriasCirculo());
	}
	
	private int calculaMenorDimensao() {
		int dimensao = getSize().height;
		
		if(dimensao > getSize().width)
			dimensao = getSize().width;
		
		return dimensao/3;
	}

	public void restart() {
		controlador.restart();
		repaint();
	}

}
