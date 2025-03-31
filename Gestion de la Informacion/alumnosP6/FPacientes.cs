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
    public partial class FPacientes : Form
    {
        private Usuario user;
        private Paciente seleccionado;

        public FPacientes(Usuario user)
        {
            InitializeComponent();
            this.user = user;
            seleccionado = null;
        }

        private void FPacientes_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'gI1920DataSet.tPaciente' Puede moverla o quitarla según sea necesario.
            this.tPacienteTableAdapter.Fill(this.gI1920DataSet.tPaciente);
            string pantalla = this.Name.Substring(1).ToUpper();
            if (!user.AccesoPantalla(pantalla)) this.Close();
            bIns.Enabled = user.InsertarPantalla(pantalla);
            bUpd.Enabled = user.ModificarPantalla(pantalla);
            bDel.Enabled = user.BorrarPantalla(pantalla);
            
            this.tPacienteTableAdapter.Fill(this.gI1920DataSet.tPaciente);
            CargarProvincias();
            CargarSexos();
            MostrarSeleccionado();
        }
        private void CargarProvincias()
        {
            ListProvincia.Items.Clear();
            foreach (Provincia p in Provincia.ListaProvincias()) ListProvincia.Items.Add(p);
        }
        private void CargarSexos()
        {
            ListSexo.Items.Clear();
            ListSexo.Items.Add("HOMBRE");
            ListSexo.Items.Add("MUJER");
        }

        private void MostrarSeleccionado()
        {
            if (seleccionado == null)
            {
                tNumSS.Text = "";
                tNIF.Text = "";
                tNombre.Text = "";
                tApellidos.Text = "";
                tDireccion.Text = "";
                tCodigo.Text = "";
                tPoblacion.Text = "";
                tTelefono.Text = "";
                tEmail.Text = "";
                ListProvincia.SelectedItem = null;
                ListSexo.SelectedItem = null;
                tFecha.SetDate(DateTime.Now);
            }
            else
            {
                tNumSS.Text = seleccionado.NumeroSS_Paciente.ToString();
                tNIF.Text = seleccionado.DNI_NIE_Paciente;
                tNombre.Text = seleccionado.Nombre_Paciente;
                tApellidos.Text = seleccionado.Apellidos_Paciente;
                tDireccion.Text = seleccionado.Direccion_Paciente;
                tCodigo.Text = seleccionado.CodigoPostal_Paciente;
                tPoblacion.Text = seleccionado.Poblacion_Paciente;
                tTelefono.Text = seleccionado.Telefono_Paciente;
                tEmail.Text = seleccionado.e_mail_Paciente;
                ListProvincia.SelectedItem = seleccionado.Provincia_Paciente;
                ListSexo.SelectedItem = seleccionado.Sexo_Paciente;
                tFecha.SetDate(seleccionado.FechaNacimiento_Paciente);
            }
        }

        private void dataGridView1_SelectionChanged(object sender, EventArgs e)
        {
            try
            {
                if (dataGridView1.SelectedRows.Count > 0)
                {
                    string nif = (string)dataGridView1.SelectedRows[0].Cells[0].Value;

                    seleccionado = new Paciente(nif);
                    MostrarSeleccionado();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }

        private void bIns_Click(object sender, EventArgs e)
        {
            try
            {

                seleccionado = new Paciente(tNIF.Text, Int32.Parse(tNumSS.Text), tNombre.Text, tApellidos.Text, ListSexo.SelectedItem.ToString(),
                tFecha.SelectionRange.Start.Date, tDireccion.Text, tPoblacion.Text, (Provincia)ListProvincia.SelectedItem,
                tCodigo.Text, tTelefono.Text, tEmail.Text);
                this.tPacienteTableAdapter.Fill(this.gI1920DataSet.tPaciente);
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
                if (!seleccionado.DNI_NIE_Paciente.Equals(tNIF.Text)) seleccionado.DNI_NIE_Paciente = tNIF.Text;
                if (!seleccionado.Nombre_Paciente.Equals(tNombre.Text)) seleccionado.Nombre_Paciente = tNombre.Text;
                if (!seleccionado.NumeroSS_Paciente.Equals(Int32.Parse(tNumSS.Text))) seleccionado.NumeroSS_Paciente = Int32.Parse(tNumSS.Text);
                if (!seleccionado.Apellidos_Paciente.Equals(tApellidos.Text)) seleccionado.Apellidos_Paciente = tApellidos.Text;
                if (!seleccionado.Direccion_Paciente.Equals(tDireccion.Text)) seleccionado.Direccion_Paciente = tDireccion.Text;
                if (!seleccionado.CodigoPostal_Paciente.Equals(tCodigo.Text)) seleccionado.CodigoPostal_Paciente = tCodigo.Text;
                if (!seleccionado.Poblacion_Paciente.Equals(tPoblacion.Text)) seleccionado.Poblacion_Paciente = tPoblacion.Text;
                if (!seleccionado.Telefono_Paciente.Equals(tTelefono.Text)) seleccionado.Telefono_Paciente = tTelefono.Text;
                if (!seleccionado.e_mail_Paciente.Equals(tEmail.Text)) seleccionado.e_mail_Paciente = tEmail.Text;
                if (!seleccionado.Provincia_Paciente.Equals(ListProvincia.SelectedItem)) seleccionado.Provincia_Paciente = (Provincia)ListProvincia.SelectedItem;
                if (!seleccionado.Sexo_Paciente.Equals(ListSexo.SelectedItem)) seleccionado.Sexo_Paciente = ListSexo.SelectedItem.ToString();
                if (!seleccionado.FechaNacimiento_Paciente.Equals(tFecha.SelectionRange.Start.Date)) seleccionado.FechaNacimiento_Paciente = tFecha.SelectionRange.Start;

                this.tPacienteTableAdapter.Fill(this.gI1920DataSet.tPaciente);
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
                seleccionado.BorrarPaciente();
                this.tPacienteTableAdapter.Fill(this.gI1920DataSet.tPaciente);
                seleccionado = null;
                MostrarSeleccionado();
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }

        private void bClean_Click_1(object sender, EventArgs e)
        {
            seleccionado = null;
            MostrarSeleccionado();
        }

        private void bSalir_Click(object sender, EventArgs e)
        {
            this.Close();    
        }
    }
}
