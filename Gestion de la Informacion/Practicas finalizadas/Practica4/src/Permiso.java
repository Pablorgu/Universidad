import java.util.*;


public class Permiso implements Comparable<Permiso>
{
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "GI1920";
    
	private String rolName;
	private String pantalla;
    private boolean acceso;
    private boolean insertar;
    private boolean modificar;
    private boolean borrar;


    public static List<Permiso> ListaPermisosRol(String rolName)
    {

		ArrayList<Permiso> lista = new ArrayList<Permiso>(); 		
		// Retorna una lista con todos los obejtos de la clase almacenados en la base de datos
		BD miBD = new BD(BD_SERVER,BD_NAME);
		
		for(Object[] tupla: miBD.Select("SELECT pantalla FROM tPermiso WHERE rolName = '" + rolName + "';"))
		{
			String pantalla = (String)tupla[0];
			lista.add(new Permiso(rolName, pantalla));
		}
		return lista;
    }
    
    public Permiso(String r, String p)
    {
		// Crea el objeto cargando sus valores de la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
		
    	Object[] tupla = miBD.Select("SELECT * FROM tPermiso WHERE " 
    			+ "rolName = '" + r + "' AND "
    			+ "pantalla= '" + p + "';").get(0);
    	

    	rolName = (String)tupla[0];
    	pantalla  = (String)tupla[1];
        acceso = (Boolean)tupla[2];
        insertar = (Boolean)tupla[3];
        modificar = (Boolean)tupla[4];
        borrar = (Boolean)tupla[5];
    }

    public Permiso(String r, String p, boolean a, boolean i, boolean m, boolean b)
    {
		// Crea el objeto y lo inserta en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
		
    	miBD.Insert("INSERT INTO tPermiso VALUESS('" + r + "','" + p + "'," 
                + (a ? 1 : 0) + "," + (i ? 1 : 0) + "," + (m ? 1 : 0) + "," + (b ? 1 : 0) + ");");
    	rolName = r;
    	pantalla = p;
    	acceso = a;
    	insertar = i;
    	modificar = m;
    	borrar = b;
    }
    
	public void setRolName(String value) 
	{
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Update("UPDATE tPermiso SET rolName = '" + value + "' WHERE " 
    			+ "rolName = '" + rolName + "' AND "
    			+ "pantalla= '" + pantalla + "';");
    	
    	rolName = value;
	}

	public String getRolName() 
	{
		return rolName;
	}
    
    public String getPantalla() 
    {
    	return pantalla; 
    }
    
    public void setPantalla(String value) 
    {
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Update("UPDATE tPermiso SET pantalla = '" + value + "' WHERE " 
    			+ "rolName = '" + rolName + "' AND "
    			+ "pantalla= '" + pantalla + "';");
    	
    	pantalla = value;
    }
    

    public boolean getAcceso() 
    { 
    	return acceso; 
    }
        
    public void setAcceso(boolean value) 
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Update("UPDATE tPermiso SET acceso = " + (value?1:0) + " WHERE " 
    			+ "rolName = '" + rolName + "' AND "
    			+ "pantalla= '" + pantalla + "';");
    	
    	acceso = value;
    }

    public boolean getInsertar() 
    { 
    	return insertar; 
    }
    
    public void setInsertar(boolean value) 
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Update("UPDATE tPermiso SET insertar = " + (value?1:0) + " WHERE " 
    			+ "rolName = '" + rolName + "' AND "
    			+ "pantalla= '" + pantalla + "';");
    	
    	insertar = value;
    }

    public boolean getModificar() 
    { 
    	return modificar; 
    }
    
    public void setModificar(boolean value) 
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Update("UPDATE tPermiso SET modificar = " + (value?1:0) + " WHERE " 
    			+ "rolName = '" + rolName + "' AND "
    			+ "pantalla= '" + pantalla + "';");
    	
    	modificar = value;
    }
    public boolean getBorrar() 
    { 
    	return borrar; 
    }
    
    public void setBorrar(boolean value) 
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Update("UPDATE tPermiso SET borrar = " + (value?1:0) + " WHERE " 
    			+ "rolName = '" + rolName + "' AND "
    			+ "pantalla= '" + pantalla + "';");
    	
    	borrar = value;
    }

    @Override
	public boolean equals(Object o) 
	{
		boolean res = false;
		if (o instanceof Permiso) 
		{
			Permiso p = (Permiso) o;
			res = this.pantalla.equalsIgnoreCase(p.pantalla) 
				&& this.rolName.equalsIgnoreCase(p.rolName);
		}
		return res;
	}
	
	public int hashCode() 
	{
		return pantalla.toLowerCase().hashCode() 
				+ rolName.toLowerCase().hashCode();
	}

	public String toString() 
	{
		return rolName+";"+pantalla+";"+acceso+";"+insertar+";"+modificar+";"+borrar;
	}

	@Override
	public int compareTo(Permiso p) 
	{
		int res = this.rolName.compareToIgnoreCase(p.rolName);
		if (res == 0) res = this.pantalla.compareToIgnoreCase(p.pantalla);
		return res;
	}
}
