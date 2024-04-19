import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Profesional {
	private List<Acceso> acceso;
	
	public Profesional() {
		acceso = new ArrayList<Acceso>();
	}
	
	protected void addAcceso(Acceso a) {
		assert a != null;
		this.acceso.add(a);
	}
	
	public Enumeration<Acceso> getAcceso() {
		return java.util.Collections.enumeration(acceso);
	}
}
