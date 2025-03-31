import java.util.*;

public class Laboratorio 
{
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "GI1920";

    private String cif;
    private String nombre;
    private String poblacion;
    private Provincia provincia;

    public static List<Laboratorio> ListaLaboratorios()
    {
    	 
        List<Laboratorio> lista = new ArrayList<Laboratorio>();
        // COMPLETAR    
        BD bd = new BD(BD_SERVER, BD_NAME);
        List<Object[]> labos = bd.Select("SELECT cif, nombre, poblacion, provincia from tLaboratorio");
        bd.finalize();
        List<Laboratorio> listaLaboratorios = new ArrayList<>();
        
        for(Object[] row : labos) {
        	String cif = (String) row[0];
        	String nombre = (String) row[1];
        	String poblacion = (String) row[2];
        	Provincia provincia = new Provincia((String)row[3]);
        	
        	Laboratorio laboratorio = new Laboratorio(cif, nombre, poblacion, provincia);
        	listaLaboratorios.add(laboratorio);
        }
        
        return listaLaboratorios;
    }

    public Laboratorio(String cif)
    {
        // COMPLETAR
    	BD bd = new BD(BD_SERVER, BD_NAME);
    	List<Object[]> lab = bd.Select("SELECT nombre, poblacion, provincia from tlaboratorio l where l.cif ='" + cif + "';");
    	bd.finalize();
    	this.cif = cif;
    	this.nombre= lab.get(0).toString();
    	this.poblacion = lab.get(1).toString();
    	this.provincia = new Provincia(lab.get(2).toString());
    }

    public Laboratorio(String cif, String nombre, String poblacion, Provincia provincia)
    {
        // COMPLETAR
    	BD bd = new BD(BD_SERVER, BD_NAME);
    	List<Object[]> lab = bd.Select("SELECT nombre from tlaboratorio l where l.cif ='" + cif + "';");
    	if(lab.isEmpty()) {
        	bd.Insert("INSERT INTO tlaboratorio values ('"+cif+"','"+nombre+"','"+poblacion+", '"+provincia+";)");
    	}
    	bd.finalize();
    	this.cif = cif;
    	this.nombre = nombre;
    	this.poblacion = poblacion;
    	this.provincia = provincia;
    }

    public String getCIF()
    {
    	return cif; 
    }
    
    public void setCIF(String value)       
    {
        // COMPLETAR
    	this.cif = value;
    	BD bd = new BD(BD_SERVER, BD_NAME);
    	bd.Update("UPDATE tlaboratorio set cif='"+this.cif+"';");
    	bd.finalize();
    }

    public String getNombre()
    {
    	return nombre; 
    }
         
    public void setNombre(String value)
    {
        // COMPLETAR
    	this.nombre = value;
    	BD bd = new BD(BD_SERVER, BD_NAME);
    	bd.Update("UPDATE tlaboratorio set nombre='"+this.nombre+"';");
    	bd.finalize();
    }

    public String getPoblacion()
    {
    	return poblacion; 
    }

    public void setPoblacion(String value)
    {
        // COMPLETAR
    	this.poblacion = value;
    	BD bd = new BD(BD_SERVER, BD_NAME);
    	bd.Update("UPDATE tlaboratorio set poblacion='"+this.poblacion+"';");
    	bd.finalize();
    }

    public Provincia getProvincia()
    {
        return provincia;
    }
        
    public void setProvincia (Provincia value)      
    {
        // COMPLETAR
    	this.provincia = value;
    	BD bd = new BD(BD_SERVER, BD_NAME);
    	bd.Update("UPDATE tlaboratorio set provincia='"+this.provincia+"';");
    	bd.finalize();
    	
    }
    
    public void BorrarLaboratorio()
    {
        // COMPLETAR
    	BD bd = new BD(BD_SERVER, BD_NAME);
    	bd.Delete("DELETE FROM tlaboratorio WHERE cif='"+this.cif+"');");
    	bd.finalize();
    	this.cif = null;
    	
    }

    public String toString()
    {
        return cif + " " + nombre;
    }

    public boolean equals(Object obj)
    {
        return obj instanceof Laboratorio 
        		&& (((Laboratorio)obj).cif.compareToIgnoreCase(this.cif) == 0);
    }

    public int hashCode()
    {
        return cif.hashCode();
    }
}
