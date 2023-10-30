import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class CtrlPanelMantenimientoUsuarios implements ActionListener  
{
	private I_PanelMantenimientoUsuarios vista;	
	private Usuario u=null;

	public CtrlPanelMantenimientoUsuarios(I_PanelMantenimientoUsuarios vista)
	{
		this.vista = vista;
	}

	public void actionPerformed(ActionEvent e) 
	{
		String cmd = e.getActionCommand();
		
		try
		{
			
			if (cmd.equals(I_PanelMantenimientoUsuarios.LOGIN))
			{								
				//COMPLETAR

				// Objetivo: Dar acceso al panel de usuario y permitir modificar si el usuario está autorizado.
				// Pasos:
				//   A) limpia todos los controles y desactiva los botones de la ventana
				//   B) Comprueba que el usuario y la contraseña es correcto
				//   C)   Usuario correcto:
				//   C.1) Mostrar mensaje de "Usuario Identificado"
				//   C.2) Si tiene acceso a la pantalla de "USUARIOS" invocar ActivarUsuarios en vista
				//   C.3) Si tiene permiso para modificar "USUARIOS" activa el controladorLista de vista:
				//        En este paso debéis crear un objeto CtrlLista (pasando el usuario que está accediendo en el constructor)
				//        Y seguidamente invocar a controladorLista de vista con el objeto CtrlLista anteriormente creado.
				//   D)   Usuario Incorrecto:
				//   D.1) Mostrar alerta en la vista de "Usuario Desconocido"
				vista.limpiar();
				vista.desactivaBotones();
				try {
					u=new Usuario(vista.getUser(), vista.getPwd());
					vista.mensaje("Usuario Identificado");
					if(u.AccesoPantalla("USUARIOS")) {
						vista.ActivarUsuarios();
					}
					if(u.ModificarPantalla("USUARIOS")) {
						CtrLista ctrl = new CtrLista(u);
						vista.controladorLista(ctrl);
					}
				}catch(Exception e1){
					vista.alerta("Usuario Desconocido");
				}
			}
			else if (cmd.equals(I_PanelMantenimientoUsuarios.USUARIOS))
			{				
				//COMPLETAR

				// Objetivo: Preparar y cargar la lista de usuarios.
				// Pasos:
				//   A) limpiar la vista
				//   B) obtener la lista de usuarios
				//   C) pasar la lista MostrarUsuarios de vista
				vista.limpiar();
				List<Usuario> usuarios = Usuario.ListaUsuarios();
				vista.MostrarUsuarios(usuarios);
			}
		}	
		catch (Exception ex)
		{
			vista.alerta(ex.getMessage());
		}

	}

}
