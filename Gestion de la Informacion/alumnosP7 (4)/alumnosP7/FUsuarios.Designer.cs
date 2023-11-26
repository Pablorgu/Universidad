namespace farmacia
{
    partial class FUsuarios
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FUsuarios));
            this.label1 = new System.Windows.Forms.Label();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.label2 = new System.Windows.Forms.Label();
            this.tNIF = new System.Windows.Forms.TextBox();
            this.tPwd = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.lRoles = new System.Windows.Forms.ListBox();
            this.bIns = new System.Windows.Forms.Button();
            this.bUpd = new System.Windows.Forms.Button();
            this.bClean = new System.Windows.Forms.Button();
            this.bDel = new System.Windows.Forms.Button();
            this.bSalir = new System.Windows.Forms.Button();
            this.bEditRol = new System.Windows.Forms.Button();
            this.gI1920DataSet = new farmacia.GI1920DataSet();
            this.tUsuarioBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.tUsuarioTableAdapter = new farmacia.GI1920DataSetTableAdapters.tUsuarioTableAdapter();
            this.nifDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.passwordDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.rolNameDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.gI1920DataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tUsuarioBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Font = new System.Drawing.Font("Verdana", 36F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.Gold;
            this.label1.Location = new System.Drawing.Point(182, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(286, 59);
            this.label1.TabIndex = 0;
            this.label1.Text = "USUARIOS";
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AllowUserToDeleteRows = false;
            this.dataGridView1.AllowUserToOrderColumns = true;
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.nifDataGridViewTextBoxColumn,
            this.passwordDataGridViewTextBoxColumn,
            this.rolNameDataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.tUsuarioBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(12, 94);
            this.dataGridView1.MultiSelect = false;
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.Size = new System.Drawing.Size(396, 227);
            this.dataGridView1.TabIndex = 1;
            this.dataGridView1.SelectionChanged += new System.EventHandler(this.dataGridView1_SelectionChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 348);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(24, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "NIF";
            // 
            // tNIF
            // 
            this.tNIF.Location = new System.Drawing.Point(87, 344);
            this.tNIF.Name = "tNIF";
            this.tNIF.Size = new System.Drawing.Size(321, 20);
            this.tNIF.TabIndex = 3;
            // 
            // tPwd
            // 
            this.tPwd.Location = new System.Drawing.Point(87, 387);
            this.tPwd.Name = "tPwd";
            this.tPwd.Size = new System.Drawing.Size(321, 20);
            this.tPwd.TabIndex = 5;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 391);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(70, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "PASSWORD";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(9, 438);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(29, 13);
            this.label4.TabIndex = 6;
            this.label4.Text = "ROL";
            // 
            // lRoles
            // 
            this.lRoles.FormattingEnabled = true;
            this.lRoles.Location = new System.Drawing.Point(96, 438);
            this.lRoles.Name = "lRoles";
            this.lRoles.Size = new System.Drawing.Size(312, 56);
            this.lRoles.TabIndex = 7;
            // 
            // bIns
            // 
            this.bIns.Location = new System.Drawing.Point(15, 567);
            this.bIns.Name = "bIns";
            this.bIns.Size = new System.Drawing.Size(75, 23);
            this.bIns.TabIndex = 8;
            this.bIns.Text = "Insertar";
            this.bIns.UseVisualStyleBackColor = true;
            this.bIns.Click += new System.EventHandler(this.bIns_Click);
            // 
            // bUpd
            // 
            this.bUpd.Location = new System.Drawing.Point(135, 567);
            this.bUpd.Name = "bUpd";
            this.bUpd.Size = new System.Drawing.Size(75, 23);
            this.bUpd.TabIndex = 9;
            this.bUpd.Text = "Modificar";
            this.bUpd.UseVisualStyleBackColor = true;
            this.bUpd.Click += new System.EventHandler(this.bUpd_Click);
            // 
            // bClean
            // 
            this.bClean.Location = new System.Drawing.Point(370, 567);
            this.bClean.Name = "bClean";
            this.bClean.Size = new System.Drawing.Size(75, 23);
            this.bClean.TabIndex = 11;
            this.bClean.Text = "Limpiar";
            this.bClean.UseVisualStyleBackColor = true;
            this.bClean.Click += new System.EventHandler(this.bClean_Click);
            // 
            // bDel
            // 
            this.bDel.Location = new System.Drawing.Point(250, 567);
            this.bDel.Name = "bDel";
            this.bDel.Size = new System.Drawing.Size(75, 23);
            this.bDel.TabIndex = 10;
            this.bDel.Text = "Borrar";
            this.bDel.UseVisualStyleBackColor = true;
            this.bDel.Click += new System.EventHandler(this.bDel_Click);
            // 
            // bSalir
            // 
            this.bSalir.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bSalir.BackgroundImage")));
            this.bSalir.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bSalir.Location = new System.Drawing.Point(483, 567);
            this.bSalir.Name = "bSalir";
            this.bSalir.Size = new System.Drawing.Size(116, 59);
            this.bSalir.TabIndex = 12;
            this.bSalir.UseVisualStyleBackColor = true;
            this.bSalir.Click += new System.EventHandler(this.bSalir_Click);
            // 
            // bEditRol
            // 
            this.bEditRol.Location = new System.Drawing.Point(430, 438);
            this.bEditRol.Name = "bEditRol";
            this.bEditRol.Size = new System.Drawing.Size(75, 23);
            this.bEditRol.TabIndex = 13;
            this.bEditRol.Text = "Editar";
            this.bEditRol.UseVisualStyleBackColor = true;
            this.bEditRol.Click += new System.EventHandler(this.bEditRol_Click);
            // 
            // gI1920DataSet
            // 
            this.gI1920DataSet.DataSetName = "GI1920DataSet";
            this.gI1920DataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // tUsuarioBindingSource
            // 
            this.tUsuarioBindingSource.DataMember = "tUsuario";
            this.tUsuarioBindingSource.DataSource = this.gI1920DataSet;
            // 
            // tUsuarioTableAdapter
            // 
            this.tUsuarioTableAdapter.ClearBeforeFill = true;
            // 
            // nifDataGridViewTextBoxColumn
            // 
            this.nifDataGridViewTextBoxColumn.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.DisplayedCells;
            this.nifDataGridViewTextBoxColumn.DataPropertyName = "nif";
            this.nifDataGridViewTextBoxColumn.HeaderText = "nif";
            this.nifDataGridViewTextBoxColumn.Name = "nifDataGridViewTextBoxColumn";
            this.nifDataGridViewTextBoxColumn.ReadOnly = true;
            this.nifDataGridViewTextBoxColumn.Width = 43;
            // 
            // passwordDataGridViewTextBoxColumn
            // 
            this.passwordDataGridViewTextBoxColumn.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.DisplayedCells;
            this.passwordDataGridViewTextBoxColumn.DataPropertyName = "password";
            this.passwordDataGridViewTextBoxColumn.HeaderText = "password";
            this.passwordDataGridViewTextBoxColumn.Name = "passwordDataGridViewTextBoxColumn";
            this.passwordDataGridViewTextBoxColumn.ReadOnly = true;
            this.passwordDataGridViewTextBoxColumn.Width = 77;
            // 
            // rolNameDataGridViewTextBoxColumn
            // 
            this.rolNameDataGridViewTextBoxColumn.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            this.rolNameDataGridViewTextBoxColumn.DataPropertyName = "rolName";
            this.rolNameDataGridViewTextBoxColumn.HeaderText = "rolName";
            this.rolNameDataGridViewTextBoxColumn.Name = "rolNameDataGridViewTextBoxColumn";
            this.rolNameDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // FUsuarios
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(647, 651);
            this.Controls.Add(this.bEditRol);
            this.Controls.Add(this.bSalir);
            this.Controls.Add(this.bClean);
            this.Controls.Add(this.bDel);
            this.Controls.Add(this.bUpd);
            this.Controls.Add(this.bIns);
            this.Controls.Add(this.lRoles);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.tPwd);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.tNIF);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.label1);
            this.Name = "FUsuarios";
            this.Text = "FUsuarios";
            this.Load += new System.EventHandler(this.FUsuarios_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.gI1920DataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tUsuarioBindingSource)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox tNIF;
        private System.Windows.Forms.TextBox tPwd;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ListBox lRoles;
        private System.Windows.Forms.Button bIns;
        private System.Windows.Forms.Button bUpd;
        private System.Windows.Forms.Button bClean;
        private System.Windows.Forms.Button bDel;
        private System.Windows.Forms.Button bSalir;
        private System.Windows.Forms.Button bEditRol;
        private GI1920DataSet gI1920DataSet;
        private System.Windows.Forms.BindingSource tUsuarioBindingSource;
        private GI1920DataSetTableAdapters.tUsuarioTableAdapter tUsuarioTableAdapter;
        private System.Windows.Forms.DataGridViewTextBoxColumn nifDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn passwordDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn rolNameDataGridViewTextBoxColumn;
    }
}