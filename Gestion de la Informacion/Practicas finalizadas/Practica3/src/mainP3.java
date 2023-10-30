import java.util.*;

public class mainP3 
{

	public static void main(String[] args) 
	{
		System.out.println("Lista de Todos los Laboratorios agrupados por Provincias");
		List<Provincia>   lp = Provincia.ListaProvincias();
		List<Laboratorio> ll = Laboratorio.ListaLaboratorios();
		for(Provincia p : lp )
		{
			System.out.println(p);
			for(Laboratorio lab : ll)
			{
				if (lab.getProvincia().equals(p))System.out.println("\t" + lab);
			}
		}

	}

}
