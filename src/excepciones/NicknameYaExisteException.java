package excepciones;

public class NicknameYaExisteException extends Exception {

	public NicknameYaExisteException(String nombre) {
		super("El jugador con el nombre " + nombre + " ya existe");
	}
}
