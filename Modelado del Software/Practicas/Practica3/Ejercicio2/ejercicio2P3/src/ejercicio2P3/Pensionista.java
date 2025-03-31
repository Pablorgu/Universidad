package ejercicio2P3;

public class Pensionista extends Trabajador{
	
	public Pensionista(String nombre, String numeroSeguridadSocial, float salario) {
		super(nombre, numeroSeguridadSocial, salario);
        }

		// Implementación del incremento del salario para un trabajador activo
		@Override
	    public void incrementar() {
	        salario = (float) (salario * 1.04);
	    }
		@Override
		public float nomina() {
			return this.salario;
		}
}
