using System;
namespace farmacia
{
    partial class FPacientes
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FPacientes));
            this.bAdd = new System.Windows.Forms.Button();
            this.bMod = new System.Windows.Forms.Button();
            this.bDelete = new System.Windows.Forms.Button();
            this.bClean = new System.Windows.Forms.Button();
            this.bExit = new System.Windows.Forms.Button();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.nIFDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.numSeguroDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nombreDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.apellidosDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.sexoDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.fechaNacimientoDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.direccionDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.poblacionDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.provinciaDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.codigoPostalDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.telefonoDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.emailDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.tPacienteBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.gI1920DataSet = new farmacia.GI1920DataSet();
            this.tPacienteTableAdapter = new farmacia.GI1920DataSetTableAdapters.tPacienteTableAdapter();
            this.lNumSS = new System.Windows.Forms.Label();
            this.lNombre = new System.Windows.Forms.Label();
            this.lSexo = new System.Windows.Forms.Label();
            this.lFechaNac = new System.Windows.Forms.Label();
            this.lNIF = new System.Windows.Forms.Label();
            this.lApellidos = new System.Windows.Forms.Label();
            this.lDireccion = new System.Windows.Forms.Label();
            this.lCodPost = new System.Windows.Forms.Label();
            this.lPoblacion = new System.Windows.Forms.Label();
            this.lProvincia = new System.Windows.Forms.Label();
            this.lTelefono = new System.Windows.Forms.Label();
            this.lMail = new System.Windows.Forms.Label();
            this.tNumSS = new System.Windows.Forms.TextBox();
            this.tNombre = new System.Windows.Forms.TextBox();
            this.tNIF = new System.Windows.Forms.TextBox();
            this.tApellidos = new System.Windows.Forms.TextBox();
            this.tDireccion = new System.Windows.Forms.TextBox();
            this.tCodPost = new System.Windows.Forms.TextBox();
            this.tPoblacion = new System.Windows.Forms.TextBox();
            this.tTelefono = new System.Windows.Forms.TextBox();
            this.tMail = new System.Windows.Forms.TextBox();
            this.FechaNac = new System.Windows.Forms.MonthCalendar();
            this.lProvincias = new System.Windows.Forms.ListBox();
            this.lSexos = new System.Windows.Forms.ListBox();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tPacienteBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.gI1920DataSet)).BeginInit();
            this.SuspendLayout();
            // 
            // bAdd
            // 
            this.bAdd.Location = new System.Drawing.Point(105, 704);
            this.bAdd.Name = "bAdd";
            this.bAdd.Size = new System.Drawing.Size(75, 23);
            this.bAdd.TabIndex = 0;
            this.bAdd.Text = "Añadir";
            this.bAdd.UseVisualStyleBackColor = true;
            this.bAdd.Click += new System.EventHandler(this.bAdd_Click);
            // 
            // bMod
            // 
            this.bMod.Location = new System.Drawing.Point(261, 704);
            this.bMod.Name = "bMod";
            this.bMod.Size = new System.Drawing.Size(75, 23);
            this.bMod.TabIndex = 1;
            this.bMod.Text = "Modificar";
            this.bMod.UseVisualStyleBackColor = true;
            this.bMod.Click += new System.EventHandler(this.bMod_Click);
            // 
            // bDelete
            // 
            this.bDelete.Location = new System.Drawing.Point(421, 704);
            this.bDelete.Name = "bDelete";
            this.bDelete.Size = new System.Drawing.Size(75, 23);
            this.bDelete.TabIndex = 2;
            this.bDelete.Text = "Borrar";
            this.bDelete.UseVisualStyleBackColor = true;
            this.bDelete.Click += new System.EventHandler(this.bDelete_Click);
            // 
            // bClean
            // 
            this.bClean.Location = new System.Drawing.Point(571, 704);
            this.bClean.Name = "bClean";
            this.bClean.Size = new System.Drawing.Size(75, 23);
            this.bClean.TabIndex = 3;
            this.bClean.Text = "Limpiar";
            this.bClean.UseVisualStyleBackColor = true;
            this.bClean.Click += new System.EventHandler(this.bClean_Click);
            // 
            // bExit
            // 
            this.bExit.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bExit.BackgroundImage")));
            this.bExit.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bExit.Location = new System.Drawing.Point(53, 23);
            this.bExit.Name = "bExit";
            this.bExit.Size = new System.Drawing.Size(110, 73);
            this.bExit.TabIndex = 12;
            this.bExit.UseVisualStyleBackColor = true;
            this.bExit.Click += new System.EventHandler(this.bExit_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.nIFDataGridViewTextBoxColumn,
            this.numSeguroDataGridViewTextBoxColumn,
            this.nombreDataGridViewTextBoxColumn,
            this.apellidosDataGridViewTextBoxColumn,
            this.sexoDataGridViewTextBoxColumn,
            this.fechaNacimientoDataGridViewTextBoxColumn,
            this.direccionDataGridViewTextBoxColumn,
            this.poblacionDataGridViewTextBoxColumn,
            this.provinciaDataGridViewTextBoxColumn,
            this.codigoPostalDataGridViewTextBoxColumn,
            this.telefonoDataGridViewTextBoxColumn,
            this.emailDataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.tPacienteBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(24, 117);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(847, 184);
            this.dataGridView1.TabIndex = 5;
            this.dataGridView1.SelectionChanged += new EventHandler(this.dataGridView1_SelectionChanged);
            // 
            // nIFDataGridViewTextBoxColumn
            // 
            this.nIFDataGridViewTextBoxColumn.DataPropertyName = "NIF";
            this.nIFDataGridViewTextBoxColumn.HeaderText = "NIF";
            this.nIFDataGridViewTextBoxColumn.Name = "nIFDataGridViewTextBoxColumn";
            // 
            // numSeguroDataGridViewTextBoxColumn
            // 
            this.numSeguroDataGridViewTextBoxColumn.DataPropertyName = "NumSeguro";
            this.numSeguroDataGridViewTextBoxColumn.HeaderText = "NumSeguro";
            this.numSeguroDataGridViewTextBoxColumn.Name = "numSeguroDataGridViewTextBoxColumn";
            // 
            // nombreDataGridViewTextBoxColumn
            // 
            this.nombreDataGridViewTextBoxColumn.DataPropertyName = "Nombre";
            this.nombreDataGridViewTextBoxColumn.HeaderText = "Nombre";
            this.nombreDataGridViewTextBoxColumn.Name = "nombreDataGridViewTextBoxColumn";
            // 
            // apellidosDataGridViewTextBoxColumn
            // 
            this.apellidosDataGridViewTextBoxColumn.DataPropertyName = "Apellidos";
            this.apellidosDataGridViewTextBoxColumn.HeaderText = "Apellidos";
            this.apellidosDataGridViewTextBoxColumn.Name = "apellidosDataGridViewTextBoxColumn";
            // 
            // sexoDataGridViewTextBoxColumn
            // 
            this.sexoDataGridViewTextBoxColumn.DataPropertyName = "Sexo";
            this.sexoDataGridViewTextBoxColumn.HeaderText = "Sexo";
            this.sexoDataGridViewTextBoxColumn.Name = "sexoDataGridViewTextBoxColumn";
            // 
            // fechaNacimientoDataGridViewTextBoxColumn
            // 
            this.fechaNacimientoDataGridViewTextBoxColumn.DataPropertyName = "FechaNacimiento";
            this.fechaNacimientoDataGridViewTextBoxColumn.HeaderText = "FechaNacimiento";
            this.fechaNacimientoDataGridViewTextBoxColumn.Name = "fechaNacimientoDataGridViewTextBoxColumn";
            // 
            // direccionDataGridViewTextBoxColumn
            // 
            this.direccionDataGridViewTextBoxColumn.DataPropertyName = "Direccion";
            this.direccionDataGridViewTextBoxColumn.HeaderText = "Direccion";
            this.direccionDataGridViewTextBoxColumn.Name = "direccionDataGridViewTextBoxColumn";
            // 
            // poblacionDataGridViewTextBoxColumn
            // 
            this.poblacionDataGridViewTextBoxColumn.DataPropertyName = "Poblacion";
            this.poblacionDataGridViewTextBoxColumn.HeaderText = "Poblacion";
            this.poblacionDataGridViewTextBoxColumn.Name = "poblacionDataGridViewTextBoxColumn";
            // 
            // provinciaDataGridViewTextBoxColumn
            // 
            this.provinciaDataGridViewTextBoxColumn.DataPropertyName = "Provincia";
            this.provinciaDataGridViewTextBoxColumn.HeaderText = "Provincia";
            this.provinciaDataGridViewTextBoxColumn.Name = "provinciaDataGridViewTextBoxColumn";
            // 
            // codigoPostalDataGridViewTextBoxColumn
            // 
            this.codigoPostalDataGridViewTextBoxColumn.DataPropertyName = "CodigoPostal";
            this.codigoPostalDataGridViewTextBoxColumn.HeaderText = "CodigoPostal";
            this.codigoPostalDataGridViewTextBoxColumn.Name = "codigoPostalDataGridViewTextBoxColumn";
            // 
            // telefonoDataGridViewTextBoxColumn
            // 
            this.telefonoDataGridViewTextBoxColumn.DataPropertyName = "Telefono";
            this.telefonoDataGridViewTextBoxColumn.HeaderText = "Telefono";
            this.telefonoDataGridViewTextBoxColumn.Name = "telefonoDataGridViewTextBoxColumn";
            // 
            // emailDataGridViewTextBoxColumn
            // 
            this.emailDataGridViewTextBoxColumn.DataPropertyName = "e_mail";
            this.emailDataGridViewTextBoxColumn.HeaderText = "e_mail";
            this.emailDataGridViewTextBoxColumn.Name = "emailDataGridViewTextBoxColumn";
            // 
            // tPacienteBindingSource
            // 
            this.tPacienteBindingSource.DataMember = "tPaciente";
            this.tPacienteBindingSource.DataSource = this.gI1920DataSet;
            // 
            // gI1920DataSet
            // 
            this.gI1920DataSet.DataSetName = "GI1920DataSet";
            this.gI1920DataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // tPacienteTableAdapter
            // 
            this.tPacienteTableAdapter.ClearBeforeFill = true;
            // 
            // lNumSS
            // 
            this.lNumSS.AutoSize = true;
            this.lNumSS.Location = new System.Drawing.Point(80, 346);
            this.lNumSS.Name = "lNumSS";
            this.lNumSS.Size = new System.Drawing.Size(43, 13);
            this.lNumSS.TabIndex = 6;
            this.lNumSS.Text = "NumSS";
            // 
            // lNombre
            // 
            this.lNombre.AutoSize = true;
            this.lNombre.Location = new System.Drawing.Point(80, 382);
            this.lNombre.Name = "lNombre";
            this.lNombre.Size = new System.Drawing.Size(44, 13);
            this.lNombre.TabIndex = 7;
            this.lNombre.Text = "Nombre";
            // 
            // lSexo
            // 
            this.lSexo.AutoSize = true;
            this.lSexo.Location = new System.Drawing.Point(80, 426);
            this.lSexo.Name = "lSexo";
            this.lSexo.Size = new System.Drawing.Size(31, 13);
            this.lSexo.TabIndex = 8;
            this.lSexo.Text = "Sexo";
            // 
            // lFechaNac
            // 
            this.lFechaNac.AutoSize = true;
            this.lFechaNac.Location = new System.Drawing.Point(80, 474);
            this.lFechaNac.Name = "lFechaNac";
            this.lFechaNac.Size = new System.Drawing.Size(93, 13);
            this.lFechaNac.TabIndex = 9;
            this.lFechaNac.Text = "Fecha Nacimiento";
            // 
            // lNIF
            // 
            this.lNIF.AutoSize = true;
            this.lNIF.Location = new System.Drawing.Point(504, 346);
            this.lNIF.Name = "lNIF";
            this.lNIF.Size = new System.Drawing.Size(47, 13);
            this.lNIF.TabIndex = 10;
            this.lNIF.Text = "NIF/NIE";
            // 
            // lApellidos
            // 
            this.lApellidos.AutoSize = true;
            this.lApellidos.Location = new System.Drawing.Point(504, 382);
            this.lApellidos.Name = "lApellidos";
            this.lApellidos.Size = new System.Drawing.Size(49, 13);
            this.lApellidos.TabIndex = 11;
            this.lApellidos.Text = "Apellidos";
            // 
            // lDireccion
            // 
            this.lDireccion.AutoSize = true;
            this.lDireccion.Location = new System.Drawing.Point(268, 426);
            this.lDireccion.Name = "lDireccion";
            this.lDireccion.Size = new System.Drawing.Size(52, 13);
            this.lDireccion.TabIndex = 12;
            this.lDireccion.Text = "Direccion";
            // 
            // lCodPost
            // 
            this.lCodPost.AutoSize = true;
            this.lCodPost.Location = new System.Drawing.Point(504, 474);
            this.lCodPost.Name = "lCodPost";
            this.lCodPost.Size = new System.Drawing.Size(72, 13);
            this.lCodPost.TabIndex = 13;
            this.lCodPost.Text = "Codigo Postal";
            // 
            // lPoblacion
            // 
            this.lPoblacion.AutoSize = true;
            this.lPoblacion.Location = new System.Drawing.Point(504, 515);
            this.lPoblacion.Name = "lPoblacion";
            this.lPoblacion.Size = new System.Drawing.Size(54, 13);
            this.lPoblacion.TabIndex = 14;
            this.lPoblacion.Text = "Poblacion";
            // 
            // lProvincia
            // 
            this.lProvincia.AutoSize = true;
            this.lProvincia.Location = new System.Drawing.Point(504, 549);
            this.lProvincia.Name = "lProvincia";
            this.lProvincia.Size = new System.Drawing.Size(51, 13);
            this.lProvincia.TabIndex = 15;
            this.lProvincia.Text = "Provincia";
            // 
            // lTelefono
            // 
            this.lTelefono.AutoSize = true;
            this.lTelefono.Location = new System.Drawing.Point(504, 623);
            this.lTelefono.Name = "lTelefono";
            this.lTelefono.Size = new System.Drawing.Size(49, 13);
            this.lTelefono.TabIndex = 16;
            this.lTelefono.Text = "Telefono";
            // 
            // lMail
            // 
            this.lMail.AutoSize = true;
            this.lMail.Location = new System.Drawing.Point(504, 661);
            this.lMail.Name = "lMail";
            this.lMail.Size = new System.Drawing.Size(34, 13);
            this.lMail.TabIndex = 17;
            this.lMail.Text = "e-mail";
            // 
            // tNumSS
            // 
            this.tNumSS.Location = new System.Drawing.Point(147, 343);
            this.tNumSS.Name = "tNumSS";
            this.tNumSS.Size = new System.Drawing.Size(100, 20);
            this.tNumSS.TabIndex = 18;
            // 
            // tNombre
            // 
            this.tNombre.Location = new System.Drawing.Point(147, 379);
            this.tNombre.Name = "tNombre";
            this.tNombre.Size = new System.Drawing.Size(100, 20);
            this.tNombre.TabIndex = 19;
            // 
            // tNIF
            // 
            this.tNIF.Location = new System.Drawing.Point(584, 343);
            this.tNIF.Name = "tNIF";
            this.tNIF.Size = new System.Drawing.Size(100, 20);
            this.tNIF.TabIndex = 20;
            // 
            // tApellidos
            // 
            this.tApellidos.Location = new System.Drawing.Point(584, 379);
            this.tApellidos.Name = "tApellidos";
            this.tApellidos.Size = new System.Drawing.Size(100, 20);
            this.tApellidos.TabIndex = 21;
            // 
            // tDireccion
            // 
            this.tDireccion.Location = new System.Drawing.Point(347, 423);
            this.tDireccion.Name = "tDireccion";
            this.tDireccion.Size = new System.Drawing.Size(337, 20);
            this.tDireccion.TabIndex = 22;
            // 
            // tCodPost
            // 
            this.tCodPost.Location = new System.Drawing.Point(584, 471);
            this.tCodPost.Name = "tCodPost";
            this.tCodPost.Size = new System.Drawing.Size(100, 20);
            this.tCodPost.TabIndex = 23;
            // 
            // tPoblacion
            // 
            this.tPoblacion.Location = new System.Drawing.Point(584, 512);
            this.tPoblacion.Name = "tPoblacion";
            this.tPoblacion.Size = new System.Drawing.Size(100, 20);
            this.tPoblacion.TabIndex = 24;
            // 
            // tTelefono
            // 
            this.tTelefono.Location = new System.Drawing.Point(584, 620);
            this.tTelefono.Name = "tTelefono";
            this.tTelefono.Size = new System.Drawing.Size(100, 20);
            this.tTelefono.TabIndex = 25;
            // 
            // tMail
            // 
            this.tMail.Location = new System.Drawing.Point(584, 658);
            this.tMail.Name = "tMail";
            this.tMail.Size = new System.Drawing.Size(100, 20);
            this.tMail.TabIndex = 26;
            // 
            // FechaNac
            // 
            this.FechaNac.Location = new System.Drawing.Point(199, 474);
            this.FechaNac.MaxSelectionCount = 1;
            this.FechaNac.Name = "FechaNac";
            this.FechaNac.TabIndex = 27;
            // 
            // lProvincias
            // 
            this.lProvincias.FormattingEnabled = true;
            this.lProvincias.Location = new System.Drawing.Point(584, 549);
            this.lProvincias.Name = "lProvincias";
            this.lProvincias.Size = new System.Drawing.Size(144, 56);
            this.lProvincias.TabIndex = 28;
            // 
            // lSexos
            // 
            this.lSexos.FormattingEnabled = true;
            this.lSexos.Location = new System.Drawing.Point(147, 423);
            this.lSexos.Name = "lSexos";
            this.lSexos.Size = new System.Drawing.Size(100, 30);
            this.lSexos.TabIndex = 29;
            // 
            // FPacientes
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(1333, 798);
            this.Controls.Add(this.lSexos);
            this.Controls.Add(this.lProvincias);
            this.Controls.Add(this.FechaNac);
            this.Controls.Add(this.tMail);
            this.Controls.Add(this.tTelefono);
            this.Controls.Add(this.tPoblacion);
            this.Controls.Add(this.tCodPost);
            this.Controls.Add(this.tDireccion);
            this.Controls.Add(this.tApellidos);
            this.Controls.Add(this.tNIF);
            this.Controls.Add(this.tNombre);
            this.Controls.Add(this.tNumSS);
            this.Controls.Add(this.lMail);
            this.Controls.Add(this.lTelefono);
            this.Controls.Add(this.lProvincia);
            this.Controls.Add(this.lPoblacion);
            this.Controls.Add(this.lCodPost);
            this.Controls.Add(this.lDireccion);
            this.Controls.Add(this.lApellidos);
            this.Controls.Add(this.lNIF);
            this.Controls.Add(this.lFechaNac);
            this.Controls.Add(this.lSexo);
            this.Controls.Add(this.lNombre);
            this.Controls.Add(this.lNumSS);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.bExit);
            this.Controls.Add(this.bClean);
            this.Controls.Add(this.bDelete);
            this.Controls.Add(this.bMod);
            this.Controls.Add(this.bAdd);
            this.Name = "FPacientes";
            this.Text = "FPacientes";
            this.Load += new System.EventHandler(this.FPacientes_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tPacienteBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.gI1920DataSet)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button bAdd;
        private System.Windows.Forms.Button bMod;
        private System.Windows.Forms.Button bDelete;
        private System.Windows.Forms.Button bClean;
        private System.Windows.Forms.Button bExit;
        private System.Windows.Forms.DataGridView dataGridView1;
        private GI1920DataSet gI1920DataSet;
        private System.Windows.Forms.BindingSource tPacienteBindingSource;
        private GI1920DataSetTableAdapters.tPacienteTableAdapter tPacienteTableAdapter;
        private System.Windows.Forms.DataGridViewTextBoxColumn nIFDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn numSeguroDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn nombreDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn apellidosDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn sexoDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn fechaNacimientoDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn direccionDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn poblacionDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn provinciaDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn codigoPostalDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn telefonoDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn emailDataGridViewTextBoxColumn;
        private System.Windows.Forms.Label lNumSS;
        private System.Windows.Forms.Label lNombre;
        private System.Windows.Forms.Label lSexo;
        private System.Windows.Forms.Label lFechaNac;
        private System.Windows.Forms.Label lNIF;
        private System.Windows.Forms.Label lApellidos;
        private System.Windows.Forms.Label lDireccion;
        private System.Windows.Forms.Label lCodPost;
        private System.Windows.Forms.Label lPoblacion;
        private System.Windows.Forms.Label lProvincia;
        private System.Windows.Forms.Label lTelefono;
        private System.Windows.Forms.Label lMail;
        private System.Windows.Forms.TextBox tNumSS;
        private System.Windows.Forms.TextBox tNombre;
        private System.Windows.Forms.TextBox tNIF;
        private System.Windows.Forms.TextBox tApellidos;
        private System.Windows.Forms.TextBox tDireccion;
        private System.Windows.Forms.TextBox tCodPost;
        private System.Windows.Forms.TextBox tPoblacion;
        private System.Windows.Forms.TextBox tTelefono;
        private System.Windows.Forms.TextBox tMail;
        private System.Windows.Forms.MonthCalendar FechaNac;
        private System.Windows.Forms.ListBox lProvincias;
        private System.Windows.Forms.ListBox lSexos;

    }
}