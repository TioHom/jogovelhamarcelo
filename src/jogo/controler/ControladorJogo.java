package jogo.controler;

import javax.swing.JOptionPane;

import jogo.model.FabricaModelJogoVelha;
import jogo.model.IModeloJogoVelha;
import jogo.model.IModeloJogoVelha.Jogador;

public class ControladorJogo implements IControladorJogoVelha {

	private IModeloJogoVelha model;
	
	private boolean stopGame = false;
	
	public ControladorJogo() {
		model = FabricaModelJogoVelha.create();
	}
	
	@Override
	public void restart() {
		stopGame = false;
		model.limparTabuleiro();
	}
	@Override
	public void usuarioClicou(int indexLinha, int indexColuna) {
		Jogador jogador = model.getRegistro(indexLinha, indexColuna);
		if(jogador.equals(Jogador.VAZIO) && !stopGame) {
			model.registreJogada(model.getVez(), indexLinha, indexColuna);
			if(model.verificaVitorias()) {
				model.registreGanhador(jogador);
				stopGame = true;
			}
			
		}
		
		model.registreVez(model.getVez() == Jogador.BOLINHA ?
				Jogador.XIS :
				Jogador.BOLINHA);
		
		if(stopGame) {
			model.getGanhador();
			model.getVitoriasBolinha();
			model.getVitoriasXis();
			restart();
		}
	}

	@Override
	public boolean temCirculo(int indexLinha, int indexColuna) {
		return model.getRegistro(indexLinha, indexColuna) == Jogador.BOLINHA;
	}

	@Override
	public boolean temXis(int indexLinha, int indexColuna) {
		return model.getRegistro(indexLinha, indexColuna) == Jogador.XIS;
	}

	@Override
	public int getVitoriasXis() {
		return model.getVitoriasXis();
	}

	@Override
	public int getVitoriasCirculo() {
		return model.getVitoriasBolinha();
	}

}
