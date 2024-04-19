import java.util.Date;

public class Acceso {
	private Date fecha;
	private TipoAcceso tipo;
	private Profesional p;
	private Expediente e;
	
	public Acceso(Date fecha, TipoAcceso tipo, Profesional p, Expediente e) {
		assert fecha != null;
		assert tipo != null;
		assert p != null;
		assert e != null;

		this.fecha = fecha;
		this.tipo = tipo;
		this.p = p;
		this.e = e;
		p.addAcceso(this);
		e.addAcceso(this);
	}

	public Date getFecha() {
		return fecha;
	}

	public TipoAcceso getTipo() {
		return tipo;
	}

	public Profesional getP() {
		return p;
	}

	public Expediente getE() {
		return e;
	}
	
	
	
}
