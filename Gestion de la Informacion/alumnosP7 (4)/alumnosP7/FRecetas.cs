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
    public partial class FRecetas : Form
    {
        private Usuario user;
        private GI1920Entities contexto = new GI1920Entities();
        private tPaciente psel;
        private tReceta seleccionado;

        public FRecetas(Usuario user)
        {
            InitializeComponent();
            this.user = user;
            seleccionado = null;
            psel = null;
        }

        private void FRecetas_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'gI1920DataSet.tReceta' Puede moverla o quitarla según sea necesario.
            this.tRecetaTableAdapter.Fill(this.gI1920DataSet.tReceta);
            string pantalla = this.Name.Substring(1).ToUpper();
            if (!user.AccesoPantalla(pantalla)) this.Close();
            bIns.Enabled = user.InsertarPantalla(pantalla);
            bMod.Enabled = user.ModificarPantalla(pantalla);
            bDelete.Enabled = user.BorrarPantalla(pantalla);
            CargarPacientes();
            CargarLaboratorio();
            MostrarPaciente();
        }


        private void CargarPacientes()
        {
            lPaciente.Items.Clear();
            var listaPacientes = from p in contexto.tPaciente orderby p.NIF select p;
            
            foreach (tPaciente p in listaPacientes) lPaciente.Items.Add(p.NIF +  ";" + p.Nombre + ";" + p.Apellidos);
        }

        private void CargarLaboratorio()
        {
            lLaboratorios.Items.Clear();
            var listaLaboratorios = from l in contexto.tLaboratorio orderby l.CIF select l;
            foreach (tLaboratorio l in listaLaboratorios) lLaboratorios.Items.Add(l.CIF + " " +  l.Nombre);
        }
        private void bIns_Click(object sender, EventArgs e)
        {
            try
            {
                if (psel == null)
                {
                    MessageBox.Show("ERRROR: No ha seleccionado un paciente");
                }else{
                    tReceta receta = new tReceta();
                    receta.PRODUCTO = (string)lProducto.Text;
                    receta.NIF = psel.NIF;
                    receta.LABORATORIO = (string)lLaboratorios.SelectedItem.ToString().Split(' ')[0];
                    receta.UNIDADES = Int32.Parse(tUnidades.Text);
                    receta.ENTREGADA = cEntregado.Checked;
                    contexto.tReceta.Add(receta);
                    contexto.SaveChanges();
                    MostrarPaciente();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }

        private void MostrarPaciente()
        {
            if (psel == null)
            {
                tProducto.Text = "";
                lLaboratorios.SelectedItem = null;
                tUnidades.Text = "";
                cEntregado.Checked = false;
                dataGridView1.DataSource = null;
            }
            else
            {
                dataGridView1.DataSource = (from r in contexto.tReceta where r.NIF == psel.NIF select new { r.ID, r.PRODUCTO, r.LABORATORIO, r.UNIDADES, r.ENTREGADA }).ToArray();
                dataGridView1.Columns[1].AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
                dataGridView1.ClearSelection();
                tProducto.Text = "";
                lLaboratorios.SelectedItem = null;
                tUnidades.Text = "";
                cEntregado.Checked = false;
            }
        }

        private void MostrarSeleccionado()
        {
            if (seleccionado == null)
            {
                tProducto.Text = "";
                lLaboratorios.SelectedItem = null;
                tUnidades.Text = "";
                cEntregado.Checked = false;
                dataGridView1.DataSource = null;
            }
            else
            {
                tProducto.Text = seleccionado.PRODUCTO.ToString();
                var lab = from l in contexto.tLaboratorio where l.CIF == seleccionado.LABORATORIO select l;
                tLaboratorio labo= (tLaboratorio)lab.First();
                lLaboratorios.SelectedItem = (labo.CIF + " " + labo.Nombre);
                tUnidades.Text = seleccionado.UNIDADES.ToString();
                cEntregado.Checked = seleccionado.ENTREGADA;
            }
        }

        private void lPacientes_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                if (lPaciente.SelectedIndex != -1)
                {
                    string NIF = lPaciente.SelectedItem.ToString().Split(';')[0];
                    var paciente = from p in contexto.tPaciente where p.NIF == NIF select p;

                    psel = (tPaciente)paciente.First();
                    MostrarPaciente();
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
                    int id = (int)dataGridView1.SelectedRows[0].Cells[0].Value;
                    var receta = from r in contexto.tReceta where r.ID == id select r;
                    seleccionado = (tReceta)receta.First();
                    MostrarSeleccionado();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void bMod_Click(object sender, EventArgs e)
        {
            try
            {
                tReceta receta = contexto.tReceta.FirstOrDefault(x => x.ID == seleccionado.ID);
                if (!receta.PRODUCTO.Equals(tProducto.Text)) receta.PRODUCTO = tProducto.Text;
                if (!receta.LABORATORIO.Equals(lLaboratorios.Text)) receta.LABORATORIO=(string)lLaboratorios.SelectedItem.ToString().Split(' ')[0];
                if (!receta.UNIDADES.Equals(tUnidades.Text)) receta.UNIDADES = Int32.Parse(tUnidades.Text);
                receta.ENTREGADA = cEntregado.Checked;
                contexto.SaveChanges();
                MostrarPaciente();
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }

        private void bExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void bClean_Click(object sender, EventArgs e)
        {
            lPaciente.SelectedItem = null;
            psel = null;
            seleccionado = null;
            MostrarPaciente();
        }

        private void bDelete_Click(object sender, EventArgs e)
        {
            if (seleccionado != null)
            {
                var listaRecetas = contexto.tReceta;
                foreach (tReceta r in contexto.tReceta)
                {
                    if (seleccionado.ID == r.ID) listaRecetas.Remove(r);
                }
                contexto.SaveChanges();
                MostrarPaciente();
            }
        }


    }
}
