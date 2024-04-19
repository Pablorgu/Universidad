import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Expediente {
	private List<Acceso> acceso;
	private Paciente paciente;
	
	public Expediente(Paciente p) throws Exception {
		assert p != null;
		this.paciente = p;
		acceso = new ArrayList<Acceso>();
		this.paciente.abrirExpediente(this);
	}
	
	protected void addAcceso(Acceso a) {
		assert a != null;
		this.acceso.add(a);
	}

	public Enumeration<Acceso> getAcceso() {
		return java.util.Collections.enumeration(acceso);
	}
	
	public Paciente getPaciente() {
		return this.paciente;
	}
}
