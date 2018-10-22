package jogo.controler;

public class FabricaControladorJogoVelha {

	public static IControladorJogoVelha create() {
		return new ControladorJogo();
	}
}
