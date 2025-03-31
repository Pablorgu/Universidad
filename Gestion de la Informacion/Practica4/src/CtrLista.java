import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CtrLista implements ListSelectionListener 
{

	private Usuario user;
	private PanelUsuario panel;
	
	public CtrLista(Usuario u)
	{
		super();
		user = u;
		panel=null;
	}
	
	public void valueChanged(ListSelectionEvent e) 
	{
		if (panel==null)
		{			
			JList<Usuario> lista = (JList<Usuario>) e.getSource();
			Object o = lista.getSelectedValue();
			if (o.getClass().equals(Usuario.class))
			{
				Usuario u = (Usuario)o;
				JFrame ventana = new JFrame("Usuario");
				panel = new PanelUsuario(user);
				panel.MostrarUsuario(u);
				ventana.setContentPane(panel);
				ventana.pack();
				ventana.setVisible(true);
			}
		}
	}

}
