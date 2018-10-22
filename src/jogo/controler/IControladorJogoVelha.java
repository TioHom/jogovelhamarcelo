package jogo.controler;

public interface IControladorJogoVelha {

	public void restart();

	public void usuarioClicou(int indexLinha, int indexColuna);
	
	public boolean temCirculo(int indexLinha, int indexColuna);
	
	public boolean temXis(int indexLinha, int indexColuna);

	public int getVitoriasXis();

	public int getVitoriasCirculo();

}
