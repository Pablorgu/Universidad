namespace farmacia
{
    partial class FRecetas
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FRecetas));
            this.gI1920DataSet = new farmacia.GI1920DataSet();
            this.tRecetaBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.tRecetaTableAdapter = new farmacia.GI1920DataSetTableAdapters.tRecetaTableAdapter();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.tRecetaBindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            this.lPaciente = new System.Windows.Forms.ListBox();
            this.lPacientes = new System.Windows.Forms.Label();
            this.lProducto = new System.Windows.Forms.Label();
            this.lLaboratorio = new System.Windows.Forms.Label();
            this.lUnidades = new System.Windows.Forms.Label();
            this.cEntregado = new System.Windows.Forms.CheckBox();
            this.tUnidades = new System.Windows.Forms.TextBox();
            this.tProducto = new System.Windows.Forms.TextBox();
            this.lLaboratorios = new System.Windows.Forms.ListBox();
            this.bClean = new System.Windows.Forms.Button();
            this.bDelete = new System.Windows.Forms.Button();
            this.bMod = new System.Windows.Forms.Button();
            this.bIns = new System.Windows.Forms.Button();
            this.bExit = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.gI1920DataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tRecetaBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tRecetaBindingSource1)).BeginInit();
            this.SuspendLayout();
            // 
            // gI1920DataSet
            // 
            this.gI1920DataSet.DataSetName = "GI1920DataSet";
            this.gI1920DataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // tRecetaBindingSource
            // 
            this.tRecetaBindingSource.DataMember = "tReceta";
            this.tRecetaBindingSource.DataSource = this.gI1920DataSet;
            // 
            // tRecetaTableAdapter
            // 
            this.tRecetaTableAdapter.ClearBeforeFill = true;
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(617, 63);
            this.dataGridView1.Margin = new System.Windows.Forms.Padding(4);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(1007, 253);
            this.dataGridView1.TabIndex = 0;
            this.dataGridView1.SelectionChanged += new System.EventHandler(this.dataGridView1_SelectionChanged);
            // 
            // tRecetaBindingSource1
            // 
            this.tRecetaBindingSource1.DataMember = "tReceta";
            this.tRecetaBindingSource1.DataSource = this.gI1920DataSet;
            // 
            // lPaciente
            // 
            this.lPaciente.FormattingEnabled = true;
            this.lPaciente.ItemHeight = 16;
            this.lPaciente.Location = new System.Drawing.Point(43, 81);
            this.lPaciente.Margin = new System.Windows.Forms.Padding(4);
            this.lPaciente.Name = "lPaciente";
            this.lPaciente.Size = new System.Drawing.Size(415, 164);
            this.lPaciente.TabIndex = 1;
            this.lPaciente.SelectedIndexChanged += new System.EventHandler(this.lPacientes_SelectedIndexChanged);
            // 
            // lPacientes
            // 
            this.lPacientes.AutoSize = true;
            this.lPacientes.Location = new System.Drawing.Point(40, 41);
            this.lPacientes.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lPacientes.Name = "lPacientes";
            this.lPacientes.Size = new System.Drawing.Size(70, 17);
            this.lPacientes.TabIndex = 2;
            this.lPacientes.Text = "Pacientes";
            // 
            // lProducto
            // 
            this.lProducto.AutoSize = true;
            this.lProducto.Location = new System.Drawing.Point(491, 378);
            this.lProducto.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lProducto.Name = "lProducto";
            this.lProducto.Size = new System.Drawing.Size(65, 17);
            this.lProducto.TabIndex = 3;
            this.lProducto.Text = "Producto";
            // 
            // lLaboratorio
            // 
            this.lLaboratorio.AutoSize = true;
            this.lLaboratorio.Location = new System.Drawing.Point(491, 427);
            this.lLaboratorio.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lLaboratorio.Name = "lLaboratorio";
            this.lLaboratorio.Size = new System.Drawing.Size(81, 17);
            this.lLaboratorio.TabIndex = 4;
            this.lLaboratorio.Text = "Laboratorio";
            // 
            // lUnidades
            // 
            this.lUnidades.AutoSize = true;
            this.lUnidades.Location = new System.Drawing.Point(488, 546);
            this.lUnidades.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lUnidades.Name = "lUnidades";
            this.lUnidades.Size = new System.Drawing.Size(68, 17);
            this.lUnidades.TabIndex = 5;
            this.lUnidades.Text = "Unidades";
            // 
            // cEntregado
            // 
            this.cEntregado.AutoSize = true;
            this.cEntregado.Location = new System.Drawing.Point(806, 545);
            this.cEntregado.Margin = new System.Windows.Forms.Padding(4);
            this.cEntregado.Name = "cEntregado";
            this.cEntregado.Size = new System.Drawing.Size(96, 21);
            this.cEntregado.TabIndex = 6;
            this.cEntregado.Text = "Entregada";
            this.cEntregado.UseVisualStyleBackColor = true;
            // 
            // tUnidades
            // 
            this.tUnidades.Location = new System.Drawing.Point(625, 541);
            this.tUnidades.Margin = new System.Windows.Forms.Padding(4);
            this.tUnidades.Name = "tUnidades";
            this.tUnidades.Size = new System.Drawing.Size(132, 22);
            this.tUnidades.TabIndex = 7;
            // 
            // tProducto
            // 
            this.tProducto.Location = new System.Drawing.Point(625, 378);
            this.tProducto.Margin = new System.Windows.Forms.Padding(4);
            this.tProducto.Name = "tProducto";
            this.tProducto.Size = new System.Drawing.Size(277, 22);
            this.tProducto.TabIndex = 8;
            // 
            // lLaboratorios
            // 
            this.lLaboratorios.FormattingEnabled = true;
            this.lLaboratorios.ItemHeight = 16;
            this.lLaboratorios.Location = new System.Drawing.Point(625, 427);
            this.lLaboratorios.Margin = new System.Windows.Forms.Padding(4);
            this.lLaboratorios.Name = "lLaboratorios";
            this.lLaboratorios.Size = new System.Drawing.Size(277, 84);
            this.lLaboratorios.TabIndex = 9;
            // 
            // bClean
            // 
            this.bClean.Location = new System.Drawing.Point(909, 618);
            this.bClean.Margin = new System.Windows.Forms.Padding(4);
            this.bClean.Name = "bClean";
            this.bClean.Size = new System.Drawing.Size(100, 28);
            this.bClean.TabIndex = 13;
            this.bClean.Text = "Limpiar";
            this.bClean.UseVisualStyleBackColor = true;
            this.bClean.Click += new System.EventHandler(this.bClean_Click);
            // 
            // bDelete
            // 
            this.bDelete.Location = new System.Drawing.Point(743, 618);
            this.bDelete.Margin = new System.Windows.Forms.Padding(4);
            this.bDelete.Name = "bDelete";
            this.bDelete.Size = new System.Drawing.Size(100, 28);
            this.bDelete.TabIndex = 12;
            this.bDelete.Text = "Borrar";
            this.bDelete.UseVisualStyleBackColor = true;
            this.bDelete.Click += new System.EventHandler(this.bDelete_Click);
            // 
            // bMod
            // 
            this.bMod.Location = new System.Drawing.Point(580, 618);
            this.bMod.Margin = new System.Windows.Forms.Padding(4);
            this.bMod.Name = "bMod";
            this.bMod.Size = new System.Drawing.Size(100, 28);
            this.bMod.TabIndex = 11;
            this.bMod.Text = "Modificar";
            this.bMod.UseVisualStyleBackColor = true;
            this.bMod.Click += new System.EventHandler(this.bMod_Click);
            // 
            // bIns
            // 
            this.bIns.Location = new System.Drawing.Point(384, 618);
            this.bIns.Margin = new System.Windows.Forms.Padding(4);
            this.bIns.Name = "bIns";
            this.bIns.Size = new System.Drawing.Size(100, 28);
            this.bIns.TabIndex = 10;
            this.bIns.Text = "Insertar";
            this.bIns.UseVisualStyleBackColor = true;
            this.bIns.Click += new System.EventHandler(this.bIns_Click);
            // 
            // bExit
            // 
            this.bExit.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bExit.BackgroundImage")));
            this.bExit.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bExit.Location = new System.Drawing.Point(1152, 556);
            this.bExit.Margin = new System.Windows.Forms.Padding(4);
            this.bExit.Name = "bExit";
            this.bExit.Size = new System.Drawing.Size(147, 90);
            this.bExit.TabIndex = 14;
            this.bExit.UseVisualStyleBackColor = true;
            this.bExit.Click += new System.EventHandler(this.bExit_Click);
            // 
            // FRecetas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(1712, 746);
            this.Controls.Add(this.bExit);
            this.Controls.Add(this.bClean);
            this.Controls.Add(this.bDelete);
            this.Controls.Add(this.bMod);
            this.Controls.Add(this.bIns);
            this.Controls.Add(this.lLaboratorios);
            this.Controls.Add(this.tProducto);
            this.Controls.Add(this.tUnidades);
            this.Controls.Add(this.cEntregado);
            this.Controls.Add(this.lUnidades);
            this.Controls.Add(this.lLaboratorio);
            this.Controls.Add(this.lProducto);
            this.Controls.Add(this.lPacientes);
            this.Controls.Add(this.lPaciente);
            this.Controls.Add(this.dataGridView1);
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "FRecetas";
            this.Text = "FRecetas";
            this.Load += new System.EventHandler(this.FRecetas_Load);
            ((System.ComponentModel.ISupportInitialize)(this.gI1920DataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tRecetaBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tRecetaBindingSource1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private GI1920DataSet gI1920DataSet;
        private System.Windows.Forms.BindingSource tRecetaBindingSource;
        private GI1920DataSetTableAdapters.tRecetaTableAdapter tRecetaTableAdapter;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.BindingSource tRecetaBindingSource1;
        private System.Windows.Forms.ListBox lPaciente;
        private System.Windows.Forms.Label lPacientes;
        private System.Windows.Forms.Label lProducto;
        private System.Windows.Forms.Label lLaboratorio;
        private System.Windows.Forms.Label lUnidades;
        private System.Windows.Forms.CheckBox cEntregado;
        private System.Windows.Forms.TextBox tUnidades;
        private System.Windows.Forms.TextBox tProducto;
        private System.Windows.Forms.ListBox lLaboratorios;
        private System.Windows.Forms.Button bClean;
        private System.Windows.Forms.Button bDelete;
        private System.Windows.Forms.Button bMod;
        private System.Windows.Forms.Button bIns;
        private System.Windows.Forms.Button bExit;

    }
}