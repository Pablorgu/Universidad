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
            this.bSalir = new System.Windows.Forms.Button();
            this.tPacientes = new System.Windows.Forms.Label();
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
            this.tPacienteBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.gI1920DataSet = new farmacia.GI1920DataSet();
            this.gI1920DataSetBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.tPacienteTableAdapter = new farmacia.GI1920DataSetTableAdapters.tPacienteTableAdapter();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.label13 = new System.Windows.Forms.Label();
            this.tNumSS = new System.Windows.Forms.TextBox();
            this.tNombre = new System.Windows.Forms.TextBox();
            this.tNIF = new System.Windows.Forms.TextBox();
            this.tApellidos = new System.Windows.Forms.TextBox();
            this.tDireccion = new System.Windows.Forms.TextBox();
            this.tCodigo = new System.Windows.Forms.TextBox();
            this.tPoblacion = new System.Windows.Forms.TextBox();
            this.tTelefono = new System.Windows.Forms.TextBox();
            this.tEmail = new System.Windows.Forms.TextBox();
            this.bIns = new System.Windows.Forms.Button();
            this.bUpd = new System.Windows.Forms.Button();
            this.bDel = new System.Windows.Forms.Button();
            this.bClean = new System.Windows.Forms.Button();
            this.tFecha = new System.Windows.Forms.MonthCalendar();
            this.ListSexo = new System.Windows.Forms.ListBox();
            this.ListProvincia = new System.Windows.Forms.ListBox();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tPacienteBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.gI1920DataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.gI1920DataSetBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // bSalir
            // 
            this.bSalir.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bSalir.BackgroundImage")));
            this.bSalir.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bSalir.Location = new System.Drawing.Point(45, 32);
            this.bSalir.Margin = new System.Windows.Forms.Padding(4);
            this.bSalir.Name = "bSalir";
            this.bSalir.Size = new System.Drawing.Size(155, 60);
            this.bSalir.TabIndex = 13;
            this.bSalir.UseVisualStyleBackColor = true;
            this.bSalir.Click += new System.EventHandler(this.bSalir_Click);
            // 
            // tPacientes
            // 
            this.tPacientes.AutoSize = true;
            this.tPacientes.Font = new System.Drawing.Font("Verdana", 36F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tPacientes.Location = new System.Drawing.Point(249, 32);
            this.tPacientes.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.tPacientes.Name = "tPacientes";
            this.tPacientes.Size = new System.Drawing.Size(315, 73);
            this.tPacientes.TabIndex = 14;
            this.tPacientes.Text = "Pacientes";
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
            this.provinciaDataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.tPacienteBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(45, 128);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowTemplate.Height = 24;
            this.dataGridView1.Size = new System.Drawing.Size(944, 160);
            this.dataGridView1.TabIndex = 15;
            this.dataGridView1.SelectionChanged += new System.EventHandler(this.dataGridView1_SelectionChanged);
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
            // gI1920DataSetBindingSource
            // 
            this.gI1920DataSetBindingSource.DataSource = this.gI1920DataSet;
            this.gI1920DataSetBindingSource.Position = 0;
            // 
            // tPacienteTableAdapter
            // 
            this.tPacienteTableAdapter.ClearBeforeFill = true;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(42, 357);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(59, 17);
            this.label2.TabIndex = 16;
            this.label2.Text = "Num SS";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(42, 401);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(58, 17);
            this.label3.TabIndex = 17;
            this.label3.Text = "Nombre";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(42, 436);
            this.label4.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(39, 17);
            this.label4.TabIndex = 18;
            this.label4.Text = "Sexo";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(42, 507);
            this.label5.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(121, 17);
            this.label5.TabIndex = 19;
            this.label5.Text = "Fecha Nacimiento";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(529, 357);
            this.label6.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(55, 17);
            this.label6.TabIndex = 20;
            this.label6.Text = "NIF/NIE";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(529, 401);
            this.label7.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(65, 17);
            this.label7.TabIndex = 21;
            this.label7.Text = "Apellidos";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(230, 448);
            this.label8.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(67, 17);
            this.label8.TabIndex = 22;
            this.label8.Text = "Dirección";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(529, 507);
            this.label9.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(95, 17);
            this.label9.TabIndex = 23;
            this.label9.Text = "Código Postal";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(535, 573);
            this.label10.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(70, 17);
            this.label10.TabIndex = 24;
            this.label10.Text = "Poblacion";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(535, 635);
            this.label11.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(66, 17);
            this.label11.TabIndex = 25;
            this.label11.Text = "Provincia";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(535, 707);
            this.label12.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(64, 17);
            this.label12.TabIndex = 26;
            this.label12.Text = "Teléfono";
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(535, 782);
            this.label13.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(46, 17);
            this.label13.TabIndex = 27;
            this.label13.Text = "e-mail";
            // 
            // tNumSS
            // 
            this.tNumSS.Location = new System.Drawing.Point(122, 357);
            this.tNumSS.Margin = new System.Windows.Forms.Padding(4);
            this.tNumSS.Name = "tNumSS";
            this.tNumSS.Size = new System.Drawing.Size(266, 22);
            this.tNumSS.TabIndex = 28;
            // 
            // tNombre
            // 
            this.tNombre.Location = new System.Drawing.Point(122, 398);
            this.tNombre.Margin = new System.Windows.Forms.Padding(4);
            this.tNombre.Name = "tNombre";
            this.tNombre.Size = new System.Drawing.Size(266, 22);
            this.tNombre.TabIndex = 29;
            // 
            // tNIF
            // 
            this.tNIF.Location = new System.Drawing.Point(632, 357);
            this.tNIF.Margin = new System.Windows.Forms.Padding(4);
            this.tNIF.Name = "tNIF";
            this.tNIF.Size = new System.Drawing.Size(324, 22);
            this.tNIF.TabIndex = 30;
            // 
            // tApellidos
            // 
            this.tApellidos.Location = new System.Drawing.Point(632, 401);
            this.tApellidos.Margin = new System.Windows.Forms.Padding(4);
            this.tApellidos.Name = "tApellidos";
            this.tApellidos.Size = new System.Drawing.Size(324, 22);
            this.tApellidos.TabIndex = 31;
            // 
            // tDireccion
            // 
            this.tDireccion.Location = new System.Drawing.Point(318, 445);
            this.tDireccion.Margin = new System.Windows.Forms.Padding(4);
            this.tDireccion.Name = "tDireccion";
            this.tDireccion.Size = new System.Drawing.Size(638, 22);
            this.tDireccion.TabIndex = 32;
            // 
            // tCodigo
            // 
            this.tCodigo.Location = new System.Drawing.Point(632, 507);
            this.tCodigo.Margin = new System.Windows.Forms.Padding(4);
            this.tCodigo.Name = "tCodigo";
            this.tCodigo.Size = new System.Drawing.Size(324, 22);
            this.tCodigo.TabIndex = 33;
            // 
            // tPoblacion
            // 
            this.tPoblacion.Location = new System.Drawing.Point(632, 573);
            this.tPoblacion.Margin = new System.Windows.Forms.Padding(4);
            this.tPoblacion.Name = "tPoblacion";
            this.tPoblacion.Size = new System.Drawing.Size(324, 22);
            this.tPoblacion.TabIndex = 34;
            // 
            // tTelefono
            // 
            this.tTelefono.Location = new System.Drawing.Point(632, 707);
            this.tTelefono.Margin = new System.Windows.Forms.Padding(4);
            this.tTelefono.Name = "tTelefono";
            this.tTelefono.Size = new System.Drawing.Size(324, 22);
            this.tTelefono.TabIndex = 36;
            // 
            // tEmail
            // 
            this.tEmail.Location = new System.Drawing.Point(632, 782);
            this.tEmail.Margin = new System.Windows.Forms.Padding(4);
            this.tEmail.Name = "tEmail";
            this.tEmail.Size = new System.Drawing.Size(324, 22);
            this.tEmail.TabIndex = 37;
            // 
            // bIns
            // 
            this.bIns.Location = new System.Drawing.Point(197, 881);
            this.bIns.Margin = new System.Windows.Forms.Padding(4);
            this.bIns.Name = "bIns";
            this.bIns.Size = new System.Drawing.Size(100, 28);
            this.bIns.TabIndex = 38;
            this.bIns.Text = "Añadir";
            this.bIns.UseVisualStyleBackColor = true;
            this.bIns.Click += new System.EventHandler(this.bIns_Click);
            // 
            // bUpd
            // 
            this.bUpd.Location = new System.Drawing.Point(376, 881);
            this.bUpd.Margin = new System.Windows.Forms.Padding(4);
            this.bUpd.Name = "bUpd";
            this.bUpd.Size = new System.Drawing.Size(100, 28);
            this.bUpd.TabIndex = 39;
            this.bUpd.Text = "Modificar";
            this.bUpd.UseVisualStyleBackColor = true;
            this.bUpd.Click += new System.EventHandler(this.bUpd_Click);
            // 
            // bDel
            // 
            this.bDel.Location = new System.Drawing.Point(499, 881);
            this.bDel.Margin = new System.Windows.Forms.Padding(4);
            this.bDel.Name = "bDel";
            this.bDel.Size = new System.Drawing.Size(100, 28);
            this.bDel.TabIndex = 40;
            this.bDel.Text = "Borrar";
            this.bDel.UseVisualStyleBackColor = true;
            this.bDel.Click += new System.EventHandler(this.bDel_Click);
            // 
            // bClean
            // 
            this.bClean.Location = new System.Drawing.Point(622, 881);
            this.bClean.Margin = new System.Windows.Forms.Padding(4);
            this.bClean.Name = "bClean";
            this.bClean.Size = new System.Drawing.Size(100, 28);
            this.bClean.TabIndex = 41;
            this.bClean.Text = "Limpiar";
            this.bClean.UseVisualStyleBackColor = true;
            this.bClean.Click += new System.EventHandler(this.bClean_Click_1);
            // 
            // tFecha
            // 
            this.tFecha.Location = new System.Drawing.Point(210, 507);
            this.tFecha.Name = "tFecha";
            this.tFecha.TabIndex = 42;
            // 
            // ListSexo
            // 
            this.ListSexo.FormattingEnabled = true;
            this.ListSexo.ItemHeight = 16;
            this.ListSexo.Location = new System.Drawing.Point(88, 436);
            this.ListSexo.Name = "ListSexo";
            this.ListSexo.Size = new System.Drawing.Size(112, 52);
            this.ListSexo.TabIndex = 44;
            // 
            // ListProvincia
            // 
            this.ListProvincia.FormattingEnabled = true;
            this.ListProvincia.ItemHeight = 16;
            this.ListProvincia.Location = new System.Drawing.Point(632, 635);
            this.ListProvincia.Name = "ListProvincia";
            this.ListProvincia.Size = new System.Drawing.Size(324, 52);
            this.ListProvincia.TabIndex = 45;
            // 
            // FPacientes
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(1321, 922);
            this.Controls.Add(this.ListProvincia);
            this.Controls.Add(this.ListSexo);
            this.Controls.Add(this.tFecha);
            this.Controls.Add(this.bClean);
            this.Controls.Add(this.bDel);
            this.Controls.Add(this.bUpd);
            this.Controls.Add(this.bIns);
            this.Controls.Add(this.tEmail);
            this.Controls.Add(this.tTelefono);
            this.Controls.Add(this.tPoblacion);
            this.Controls.Add(this.tCodigo);
            this.Controls.Add(this.tDireccion);
            this.Controls.Add(this.tApellidos);
            this.Controls.Add(this.tNIF);
            this.Controls.Add(this.tNombre);
            this.Controls.Add(this.tNumSS);
            this.Controls.Add(this.label13);
            this.Controls.Add(this.label12);
            this.Controls.Add(this.label11);
            this.Controls.Add(this.label10);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.tPacientes);
            this.Controls.Add(this.bSalir);
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "FPacientes";
            this.Text = "FPacientes";
            this.Load += new System.EventHandler(this.FPacientes_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tPacienteBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.gI1920DataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.gI1920DataSetBindingSource)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button bSalir;
        private System.Windows.Forms.Label tPacientes;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.BindingSource gI1920DataSetBindingSource;
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
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.TextBox tNumSS;
        private System.Windows.Forms.TextBox tNombre;
        private System.Windows.Forms.TextBox tNIF;
        private System.Windows.Forms.TextBox tApellidos;
        private System.Windows.Forms.TextBox tDireccion;
        private System.Windows.Forms.TextBox tCodigo;
        private System.Windows.Forms.TextBox tPoblacion;
        private System.Windows.Forms.TextBox tTelefono;
        private System.Windows.Forms.TextBox tEmail;
        private System.Windows.Forms.Button bIns;
        private System.Windows.Forms.Button bUpd;
        private System.Windows.Forms.Button bDel;
        private System.Windows.Forms.Button bClean;
        private System.Windows.Forms.MonthCalendar tFecha;
        private System.Windows.Forms.ListBox ListSexo;
        private System.Windows.Forms.ListBox ListProvincia;

    }
}