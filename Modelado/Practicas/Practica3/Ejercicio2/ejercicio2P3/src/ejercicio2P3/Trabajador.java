package ejercicio2P3;

public abstract class Trabajador{
	private String nombre;
	private String numeroSeguridadSocial;
	protected float salario;
	public Trabajador(String nombre, String numeroSeguridadSocial, float salario) {
		assert nombre != null;
		assert numeroSeguridadSocial != null;
		assert salario > 0;

		this.nombre = nombre;
		this.numeroSeguridadSocial = numeroSeguridadSocial;
		this.salario = salario;
	}
	public Trabajador(String nombre, String numeroSeguridadSocial) {
		this.nombre = nombre;
		this.numeroSeguridadSocial = numeroSeguridadSocial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumeroSeguridadSocial() {
		return numeroSeguridadSocial;
	}
	public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
		this.numeroSeguridadSocial = numeroSeguridadSocial;
	}
	public abstract float nomina();
	public abstract void incrementar();
	
	
	
	
}
