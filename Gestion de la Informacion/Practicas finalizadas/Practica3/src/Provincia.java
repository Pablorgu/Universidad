import java.util.*;

public class Provincia 
{
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "GI1920";
    
	private String codigo;
	private String nombre;
	
	public static List<Provincia> ListaProvincias()
	{
        		// COMPLETAR
		BD bd = new BD(BD_SERVER, BD_NAME);
		List<Object[]> lista =  bd.Select("SELECT codigo, nombre FROM tProvincia;");
		bd.finalize();
		List<Provincia> listaProvincias = new ArrayList<>();
		
		for(Object[] row : lista) {
			String codigo = (String) row[0];
			String nombre = (String) row[1];
			
			Provincia provincia = new Provincia(codigo, nombre);
			listaProvincias.add(provincia);
		}
		
		return listaProvincias;
	}

	
	public Provincia(String codigo)
	{
        		// COMPLETAR
		BD bd = new BD(BD_SERVER, BD_NAME);
		List<Object[]> Provs= bd.Select("SELECT nombre FROM tProvincia t WHERE t.codigo = '" + codigo + "';");
		this.codigo= codigo;
		this.nombre = Provs.get(0).toString();
		bd.finalize();
	}
	
	public Provincia(String codigo, String provincia)
	{
        		// COMPLETAR
		
		BD bd = new BD(BD_SERVER, BD_NAME);
		List<Object[]> Provs= bd.Select("SELECT * FROM tProvincia t WHERE t.codigo = '" + codigo + "';");
		if(Provs.isEmpty()) {
			bd.Insert("INSERT INTO tProvincia VALUES('"+codigo+ "','"+provincia+"');");
		}
		bd.finalize();
		this.codigo = codigo;
		this.nombre = provincia;
	}
	
	public String getCodigo() 
	{
		// Devuelve el valor del atributo
		return this.codigo;
	}
	
	public void setCodigo(String value) 
	{
		// Establece el valor del atributo y actualiza la tabla
        		// COMPLETAR
		this.codigo = value;
		BD bd = new BD(BD_SERVER, BD_NAME);
    	bd.Update("UPDATE tprovincia set codigo='"+this.codigo+"';");
    	bd.finalize();
	}
	public String getProvincia() 
	{
		// Devuelve el valor del atributo
		return this.nombre;
	}
	
	public void setProvincia(String value) 
	{
		// Establece el valor del atributo y actualiza la tabla
        // COMPLETAR
		this.nombre=value;
		BD bd = new BD(BD_SERVER, BD_NAME);
    	bd.Update("UPDATE tprovincia set nombre='"+this.nombre+"';");
    	bd.finalize();
	}
	
	public void borrarProvincia()
	{
        // COMPLETAR
		BD bd = new BD(BD_SERVER, BD_NAME);
    	bd.Delete("DELETE FROM tProvincia WHERE codigo='"+this.codigo+"');");
    	bd.finalize();
	}
		   
	public String toString()	
	{	        
		return nombre;
	}
	   
	public boolean equals(Object obj)	   
	{	       
		return obj instanceof Provincia 
	       		&& (((Provincia)obj).codigo.compareToIgnoreCase(this.codigo) == 0);	   
	}

	public int hashCode()	   
	{	        
		return codigo.hashCode();	    
	}
}
