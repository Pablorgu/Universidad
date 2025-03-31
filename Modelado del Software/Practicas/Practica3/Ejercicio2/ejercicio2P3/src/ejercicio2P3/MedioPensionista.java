package ejercicio2P3;

public class MedioPensionista extends Trabajador{
	
	
	private Activo perfilActivo;
	private Pensionista perfilPensionista;
	
	

	public MedioPensionista(String nombre, String numeroSeguridadSocial, float salarioActivo, float salarioPensionista) {
		super(nombre, numeroSeguridadSocial,(salarioActivo + salarioPensionista));
		this.perfilActivo = new Activo(nombre,numeroSeguridadSocial, salarioActivo);
		this.perfilPensionista = new Pensionista(nombre,numeroSeguridadSocial, salarioPensionista);
	}



	@Override
	public void incrementar() {
		perfilActivo.incrementar();
		perfilPensionista.incrementar();
		this.salario = nomina();
		
	}
	@Override
	public float nomina() {
		return (perfilPensionista.nomina() + perfilActivo.nomina());
	}
	
	
}
