package ejercicio3P3;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class Bandeja {
	private int capacidad;
	public List<Pieza> piezas;
	private Estado estado;
	public Bandeja(int capacidad) {
		assert (capacidad > 0);
		this.capacidad = capacidad;
		piezas = new LinkedList<>();
		estado = new Empty(this);
	}
	public int getCapacidad() {

		return capacidad;
	}
	public void put(Pieza p) {
		estado.put(p);
	}
	public Pieza get() {

		return estado.get();
	}
	public int size() {
		return (piezas.size());
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Enumeration<Pieza> getPiezas() {
		return java.util.Collections.enumeration(piezas);
	}
}
