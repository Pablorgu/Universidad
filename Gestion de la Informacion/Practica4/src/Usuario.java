import java.util.*;

public class Usuario implements Comparable<Usuario>
{
    private static String BD_SERVER = "localhost";
    private static String BD_NAME = "GI1920";
    
    private String nif;
    private String password;
    private Rol rol;

	public static List<Usuario> ListaUsuarios()
	{
		// Retorna una lista con todos los obejtos de la clase almacenados en la base de datos
		BD miBD = new BD(BD_SERVER,BD_NAME);
		ArrayList<Usuario> lista = new ArrayList<Usuario>(); 
					
		for(Object[] tupla: miBD.Select("SELECT nif,password FROM tUsuario;"))
		{
			String nif = (String)tupla[0];
			String p = (String)tupla[1];
			Usuario u = new Usuario(nif,p);
			lista.add(u);
		}
		return lista;
	}
	
    public Usuario(String n, String p)
    {
		// Crea el objeto cargando sus valores de la base de datos
    	try
    	{
	    	BD miBD = new BD(BD_SERVER,BD_NAME);			
	  
			Object[] tupla = miBD.Select("SELECT * FROM tUsuario " 
					+ "WHERE nif='"+n+ "';").get(0);
			
	        nif = (String)tupla[0];
	        password = (String)tupla[1];
	        
	        if (!password.equals(p))
	        {
	        	nif = password = null;
	        	throw new BDException("Error: Usuario o Contraseña incorrecto");
	        }
	        rol = new Rol((String)tupla[2]);        
    	}
    	catch (Exception ex)
    	{
    		throw new BDException("Error: Usuario o Contraseña incorrecto");
    	}
    }
    
    public Usuario(String n, String p, Rol r)
    {
		// Crea el objeto y lo inserta en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);		
    	
    	miBD.Insert("INSERT INTO tUsuario VALUES("
				+ "'" + n + "', '" + p + "', '" + r.getRolName() + "');" );			
	
        nif = n;
        password = p;
        rol = r;
    }

    public String getNIF() 
    { 
    	return nif; 
    }

    public void setNIF(String value) 
    { 
    	
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Update("UPDATE tUsuario SET nif = '" + value 
    			+ "' WHERE nif ='"+ this.nif + "';");
    	
    	nif = value; 
    }

    public void borraUsuario() 
    {     	
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Delete("DELETE FROM  tUsuario WHERE nif ='"+ this.nif + "';");    	
    	nif = password = null;
    	rol = null;
    }
    public String getPassword() 
    { 
    	return password; 
    }
        
    public void setPassword (String value)
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD(BD_SERVER,BD_NAME);
    	miBD.Update("UPDATE tUsuario SET password = '" + value 
    			+ "' WHERE nif ='"+ this.nif + "';");
    	
    	password = value; 
    }

    public Rol getRol()
    {
        return rol;
    }
    
    public void setRol()
    {
    	throw new BDException("Error: Un usuario no puede cambiar el rol de si mismo.");     
    }

    public void ModiRol(Usuario u, Rol r)
    {
        if (this.rol.getAdmin()) 
        {
		// Actualiza el atributo rol de u en memoria y en la base de datos
        	BD miBD = new BD(BD_SERVER,BD_NAME);
        	miBD.Update("UPDATE tUsuario SET rolName = '" + r.getRolName() 
        			+ "' WHERE nif ='"+ u.getNIF() + "';");
        	
        	 u.rol = r;
        	 
        }
        else throw new Error("El usuario " + this.getNIF() 
        		+ " no puede cambiar el rol del usuario " 
        		+ u.getNIF());
    }


    public boolean AccesoPantalla(String p)
    {
        return rol.Acceso(p);
    }

    public boolean InsertarPantalla(String p)
    {
        return rol.Insertar(p);
    }

    public boolean ModificarPantalla(String p)
    {
        return rol.Modificar(p);
    }

    public boolean BorrarPantalla(String p)
    {
        return rol.Borrar(p);
    }

    public String toString()
    {
        return nif + ";" + password + ";" + rol;
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof Usuario) && ((Usuario)obj).nif.equals(this.nif);
    }

    public int hashCode()
    {
        return this.nif.hashCode();
    }

	public int compareTo(Usuario u) 
	{
		return this.nif.compareToIgnoreCase(u.nif);	
	}
}
