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
    public partial class FRoles : Form
    {
        private Usuario user;
        private Rol seleccionado;

        public FRoles(Usuario u)
        {
            InitializeComponent();
            user = u;
        }

        public Rol Seleccionado
        {
            get
            {
                return seleccionado;
            }
        }

        private void FRoles_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'gI1920DataSet.tRol' Puede moverla o quitarla según sea necesario.
            this.tRolTableAdapter.Fill(this.gI1920DataSet.tRol);

        }

        private void MostrarSeleccionado()
        {
            if (seleccionado==null)
            {
                tRolName.Text = "";
                tRolDes.Text = "";
                cAdmin.Checked = false;
                CargarPermisos();
            }
            else
            {
                tRolName.Text = seleccionado.RolName;
                tRolDes.Text = seleccionado.RolDes;
                cAdmin.Checked = seleccionado.Admin;
                CargarPermisos();
            }
        }

        private void CargarPermisos()
        {
            try
            {
                dataGridView2.Rows.Clear();
                foreach (Permiso p in Permiso.ListaPermisosRol(seleccionado.RolName))
                {
                    dataGridView2.Rows.Add(p.Pantalla, p.Acceso, p.Insertar, p.Modificar, p.Borrar);
                }                
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }
        private void dataGridView1_SelectionChanged(object sender, EventArgs e)
        {
            try
            {
                if (dataGridView1.SelectedRows.Count > 0)
                {
                    string rolName = (string)dataGridView1.SelectedRows[0].Cells[0].Value;
                    seleccionado = new Rol(rolName);
                    MostrarSeleccionado();
                    CargarPermisos();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }

        private void bINS_Click(object sender, EventArgs e)
        {
            try
            {
                seleccionado = new Rol(tRolName.Text, tRolDes.Text, cAdmin.Checked);
                InsertarPermisos();
                this.tRolTableAdapter.Fill(this.gI1920DataSet.tRol);
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }

        private void InsertarPermisos()
        {
            if (seleccionado!=null)
            {
                for(int i=0;i<dataGridView2.Rows.Count-1;++i)
                {
                    string pantalla = (string)dataGridView2.Rows[i].Cells[0].Value;
                    bool acceso = (bool)dataGridView2.Rows[i].Cells[1].Value;
                    bool insertar = (bool)dataGridView2.Rows[i].Cells[2].Value;
                    bool modificar = (bool)dataGridView2.Rows[i].Cells[3].Value;
                    bool borrar = (bool)dataGridView2.Rows[i].Cells[4].Value;

                    Permiso p = new Permiso(seleccionado.RolName,pantalla,acceso,insertar,modificar,borrar);
                    seleccionado.AddPermiso(p);
                }
            }
        }

        private void bMODI_Click(object sender, EventArgs e)
        {
            try
            {
                if (!seleccionado.RolName.Equals(tRolName.Text)) seleccionado.RolName = tRolName.Text;
                if (!seleccionado.RolDes.Equals(tRolDes.Text)) seleccionado.RolDes = tRolDes.Text;
                if (seleccionado.Admin != cAdmin.Checked) user.MyRol.setAdmin(seleccionado, cAdmin.Checked);
                this.tRolTableAdapter.Fill(this.gI1920DataSet.tRol);
                ModificaPermisos();
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }

        private void ModificaPermisos()
        {
            for (int i = 0; i < dataGridView2.Rows.Count-1; ++i)
            {
                string pantalla = (string)dataGridView2.Rows[i].Cells[0].Value;                                    
                bool acceso = (bool)dataGridView2.Rows[i].Cells[1].Value;
                bool insertar = (bool)dataGridView2.Rows[i].Cells[2].Value;
                bool modificar = (bool)dataGridView2.Rows[i].Cells[3].Value;
                bool borrar = (bool)dataGridView2.Rows[i].Cells[4].Value;

                if (seleccionado.Acceso(pantalla) != acceso) seleccionado.setAcceso(pantalla, acceso);
                if (seleccionado.Insertar(pantalla) != insertar) seleccionado.setInsertar(pantalla, insertar);
                if (seleccionado.Modificar(pantalla) != modificar) seleccionado.setModificar(pantalla, modificar);
                if (seleccionado.Borrar(pantalla) != borrar) seleccionado.setBorrar(pantalla, borrar);

            }
        }

        private void bDEL_Click(object sender, EventArgs e)
        {
            try
            {
                seleccionado.BorrarRol();
                this.tRolTableAdapter.Fill(this.gI1920DataSet.tRol);
                seleccionado = null;
                MostrarSeleccionado();
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }

        private void bClean_Click(object sender, EventArgs e)
        {
            seleccionado = null;
            MostrarSeleccionado();
        }

        private void bExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
