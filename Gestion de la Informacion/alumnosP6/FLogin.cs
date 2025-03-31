using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace farmacia
{
    public partial class FLogin : Form
    {
        private Usuario user;

        public FLogin()
        {
            InitializeComponent();
            user = null;
        }

        private void FLogin_Load(object sender, EventArgs e)
        {
            ocultar_botones();
        }

        private void ocultar_botones()
        {
            lUser.Visible = true;
            tUser.Visible = true;
            lpwd.Visible = true;
            tPwd.Visible = true;
            bLogin.Visible = true;
            usuariosToolStripMenuItem.Visible = false;
            pacientesToolStripMenuItem.Visible = false;
            recetasToolStripMenuItem.Visible = false;
            cerrarSesionToolStripMenuItem.Visible = false;
            bAuditoria.Visible = false;
            bRecetas.Visible = false;
            bPACIENTES.Visible = false;
            bUSUARIOS.Visible = false;        
        }

        private void mostrar_botones()
        {
            lUser.Visible = false;
            tUser.Visible = false;
            lpwd.Visible = false;
            tPwd.Visible = false;
            bLogin.Visible = false;

            if (user!=null && user.AccesoPantalla("USUARIOS"))
            {
                usuariosToolStripMenuItem.Visible = true;
                bUSUARIOS.Visible = true;   
            }

            if (user != null && user.AccesoPantalla("PACIENTES"))
            {
                pacientesToolStripMenuItem.Visible = true;
                bPACIENTES.Visible = true;
            }

            if (user != null && user.AccesoPantalla("RECETAS"))
            {
                recetasToolStripMenuItem.Visible = true;
                bRecetas.Visible = true;
            }

            if (user != null && user.MyRol.Admin)
            {
                bAuditoria.Visible = true;
            }

            cerrarSesionToolStripMenuItem.Visible = true;                                                
        }

        private void bLogin_Click(object sender, EventArgs e)
        {
            try
            {
                user = new Usuario(tUser.Text, tPwd.Text);
                mostrar_botones();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void cerrarSesionToolStripMenuItem_Click(object sender, EventArgs e)
        {
            tUser.Text = "";
            tPwd.Text = "";
            user = null;
            ocultar_botones();
        }

        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void bExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void bUSUARIOS_Click(object sender, EventArgs e)
        {
            manjea_usuarios();
        }

        private void usuariosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            manjea_usuarios();
        }

        private void manjea_usuarios()
        {
            FUsuarios ventanta = new FUsuarios(user);
            this.Visible = false;
            ventanta.ShowDialog();
            this.Visible = true;
        }

        private void bPACIENTES_Click(object sender, EventArgs e)
        {
            manjea_pacientes();
        }

        private void pacientesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            manjea_pacientes();
        }

        private void manjea_pacientes()
        {
            FPacientes ventanta = new FPacientes(user);
            this.Visible = false;
            ventanta.ShowDialog();
            this.Visible = true;
        }

        private void bRecetas_Click(object sender, EventArgs e)
        {
            manjea_recetas();
        }

        private void recetasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            manjea_recetas();
        }

        private void manjea_recetas()
        {
            FRecetas ventanta = new FRecetas(user);
            this.Visible = false;
            ventanta.ShowDialog();
            this.Visible = true;
        }

    }
}
