import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Paciente {
	private List<Expediente> expedientes;
	private Expediente expedienteAbierto;
	
	public Paciente() {
		expedientes = new ArrayList<Expediente>();
		expedienteAbierto = null;
	}
	
	protected void addExpediente(Expediente e) {
		assert e != null;
		expedientes.add(e);
	}
	
	protected void abrirExpediente(Expediente e) throws Exception{
		assert e != null;
		if(expedienteAbierto == null) {
			expedienteAbierto = e;
			addExpediente(e);
		}else {
			throw new Exception("Ya hay un expediente abierto para este paciente");
		}
	}
	
	protected void cerrarExpediente() throws Exception{
		if(expedienteAbierto != null) {
			expedienteAbierto = null;
		}else {
			throw new Exception("No hay ning�n expediente abierto para este paciente");
		}
	}
	
	public Enumeration<Expediente> getExpedientes() {
		return java.util.Collections.enumeration(expedientes);
	}
	
	public Expediente getExpedienteAbierto() {
		return expedienteAbierto;
	}
}
