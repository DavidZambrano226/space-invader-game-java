package excepciones;

public class PartidaYaExisteException extends Exception {

	public PartidaYaExisteException(String nombrePartida) {
		super("La partida con el nombre: " + nombrePartida + " ya existe");

	}

}
