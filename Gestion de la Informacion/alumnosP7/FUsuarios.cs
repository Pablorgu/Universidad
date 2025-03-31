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
    public partial class FUsuarios : Form
    {
        private Usuario user;
        private Usuario seleccionado=null;

        public FUsuarios(Usuario u)
        {
            InitializeComponent();
            user = u;
        }

        private void FUsuarios_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'gI1920DataSet.tUsuario' Puede moverla o quitarla según sea necesario.
            this.tUsuarioTableAdapter.Fill(this.gI1920DataSet.tUsuario);
            string pantalla = this.Name.Substring(1).ToUpper();
            if (!user.AccesoPantalla(pantalla)) this.Close();
            bIns.Enabled = user.InsertarPantalla(pantalla);
            bUpd.Enabled = user.ModificarPantalla(pantalla);
            bDel.Enabled = user.BorrarPantalla(pantalla);

            // TODO: esta línea de código carga datos en la tabla 'gI1920DataSet.tUsuario' Puede moverla o quitarla según sea necesario.
            this.tUsuarioTableAdapter.Fill(this.gI1920DataSet.tUsuario);
            CargarRoles();
        }

        private void CargarRoles()
        {
            lRoles.Items.Clear();
            foreach (Rol r in Rol.ListaRoles()) lRoles.Items.Add(r);
        }

        private void dataGridView1_SelectionChanged(object sender, EventArgs e)
        {
            try
            {
                if (dataGridView1.SelectedRows.Count > 0)
                {
                    string nif = (string)dataGridView1.SelectedRows[0].Cells[0].Value;
                    string pwd = (string)dataGridView1.SelectedRows[0].Cells[1].Value;

                    seleccionado = new Usuario(nif, pwd);
                    MostrarSeleccionado();
                }
            }
            catch(Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }

        private void MostrarSeleccionado()
        {
            if (seleccionado==null)
            {
                tNIF.Text = "";
                tPwd.Text = "";
                lRoles.SelectedItem = null;
            }
            else
            {
                tNIF.Text = seleccionado.NIF;
                tPwd.Text = seleccionado.Password;
                lRoles.SelectedItem = seleccionado.MyRol;
            }
        }

        private void bSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void bClean_Click(object sender, EventArgs e)
        {
            seleccionado = null;
            MostrarSeleccionado();
        }

        private void bIns_Click(object sender, EventArgs e)
        {
            try
            {
                seleccionado = new Usuario(tNIF.Text, tPwd.Text, (Rol)lRoles.SelectedItem);
                this.tUsuarioTableAdapter.Fill(this.gI1920DataSet.tUsuario);
                seleccionado = null;
                MostrarSeleccionado();
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }

        private void bDel_Click(object sender, EventArgs e)
        {
            try
            {
                seleccionado.BorrarUsuario();
                this.tUsuarioTableAdapter.Fill(this.gI1920DataSet.tUsuario);
                seleccionado = null;
                MostrarSeleccionado();
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }

        private void bUpd_Click(object sender, EventArgs e)
        {
            try
            {
                if (!seleccionado.NIF.Equals(tNIF.Text)) seleccionado.NIF = tNIF.Text;
                if (!seleccionado.Password.Equals(tPwd.Text)) seleccionado.Password = tPwd.Text;
                if (!seleccionado.MyRol.Equals(lRoles.SelectedItem)) user.ModiRol(seleccionado, (Rol)lRoles.SelectedItem);
                this.tUsuarioTableAdapter.Fill(this.gI1920DataSet.tUsuario);
                seleccionado = null;
                MostrarSeleccionado();
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }

        private void bEditRol_Click(object sender, EventArgs e)
        {
            FRoles ventana = new FRoles(user);
            this.Visible = false;
            ventana.ShowDialog();
            this.Visible = true;
            CargarRoles();
            lRoles.SelectedItem = ventana.Seleccionado;
        }

    }
}
