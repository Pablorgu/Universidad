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
            
            
            this.tPacienteTableAdapter.Fill(this.gI1920DataSet.tPaciente);
            CargarProvincias();
            CargarSexos();
        }
        private void CargarProvincias()
        {
            lProvincias.Items.Clear();
            foreach (Provincia p in Provincia.ListaProvincias()) lProvincias.Items.Add(p);
        }
        private void CargarSexos()
        {
            lSexos.Items.Clear();
            lSexos.Items.Add("HOMBRE");
            lSexos.Items.Add("MUJER");
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
                tCodPost.Text = "";
                tPoblacion.Text = "";
                tTelefono.Text = "";
                tMail.Text = "";
                lProvincias.SelectedItem = null;
                lSexos.SelectedItem = null;
                FechaNac.SetDate(DateTime.Now);
            }
            else
            {
                tNumSS.Text = seleccionado.NumeroSS_Paciente.ToString();
                tNIF.Text = seleccionado.DNI_NIE_Paciente;
                tNombre.Text = seleccionado.Nombre_Paciente;
                tApellidos.Text = seleccionado.Apellidos_Paciente;
                tDireccion.Text = seleccionado.Direccion_Paciente;
                tCodPost.Text = seleccionado.CodigoPostal_Paciente;
                tPoblacion.Text = seleccionado.Poblacion_Paciente;
                tTelefono.Text = seleccionado.Telefono_Paciente;
                tMail.Text = seleccionado.e_mail_Paciente;
                lProvincias.SelectedItem = seleccionado.Provincia_Paciente;
                lSexos.SelectedItem = seleccionado.Sexo_Paciente;
                FechaNac.SetDate(seleccionado.FechaNacimiento_Paciente);
            }
        }
        
        private void bExit_Click(object sender, EventArgs e)
        {
            this.Close();    
        }

        private void bDelete_Click(object sender, EventArgs e)
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

        private void bMod_Click(object sender, EventArgs e)
        {
            try
            {
                if (!seleccionado.DNI_NIE_Paciente.Equals(tNIF.Text)) seleccionado.DNI_NIE_Paciente = tNIF.Text;
                if (!seleccionado.Nombre_Paciente.Equals(tNombre.Text)) seleccionado.Nombre_Paciente = tNombre.Text;
                if (!seleccionado.NumeroSS_Paciente.Equals(Int32.Parse(tNumSS.Text))) seleccionado.NumeroSS_Paciente = Int32.Parse(tNumSS.Text);
                if (!seleccionado.Apellidos_Paciente.Equals(tApellidos.Text)) seleccionado.Apellidos_Paciente = tApellidos.Text;
                if (!seleccionado.Direccion_Paciente.Equals(tDireccion.Text)) seleccionado.Direccion_Paciente = tDireccion.Text;
                if (!seleccionado.CodigoPostal_Paciente.Equals(tCodPost.Text)) seleccionado.CodigoPostal_Paciente = tCodPost.Text;
                if (!seleccionado.Poblacion_Paciente.Equals(tPoblacion.Text)) seleccionado.Poblacion_Paciente = tPoblacion.Text;
                if (!seleccionado.Telefono_Paciente.Equals(tTelefono.Text)) seleccionado.Telefono_Paciente = tTelefono.Text;
                if (!seleccionado.e_mail_Paciente.Equals(tMail.Text)) seleccionado.e_mail_Paciente = tMail.Text;
                if (!seleccionado.Provincia_Paciente.Equals(lProvincias.SelectedItem)) seleccionado.Provincia_Paciente = (Provincia)lProvincias.SelectedItem;
                if (!seleccionado.Sexo_Paciente.Equals(lSexos.SelectedItem)) seleccionado.Sexo_Paciente = lSexos.SelectedItem.ToString();
                if (!seleccionado.FechaNacimiento_Paciente.Equals(FechaNac.SelectionRange.Start.Date)) seleccionado.FechaNacimiento_Paciente = FechaNac.SelectionRange.Start;

                this.tPacienteTableAdapter.Fill(this.gI1920DataSet.tPaciente);
                seleccionado = null;
                MostrarSeleccionado();
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR: " + ex.Message);
            }
        }

        private void bAdd_Click(object sender, EventArgs e)
        {
            try
            {

                seleccionado = new Paciente(tNIF.Text, Int32.Parse(tNumSS.Text), tNombre.Text, tApellidos.Text, lSexos.SelectedItem.ToString(),
                FechaNac.SelectionRange.Start.Date, tDireccion.Text, tPoblacion.Text, (Provincia)lProvincias.SelectedItem,
                tCodPost.Text, tTelefono.Text, tMail.Text);
                this.tPacienteTableAdapter.Fill(this.gI1920DataSet.tPaciente);
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
        
    }
}
