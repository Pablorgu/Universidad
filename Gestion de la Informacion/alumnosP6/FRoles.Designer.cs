namespace farmacia
{
    partial class FRoles
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FRoles));
            this.label1 = new System.Windows.Forms.Label();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.cAdmin = new System.Windows.Forms.CheckBox();
            this.tRolName = new System.Windows.Forms.TextBox();
            this.tRolDes = new System.Windows.Forms.TextBox();
            this.bExit = new System.Windows.Forms.Button();
            this.bINS = new System.Windows.Forms.Button();
            this.bMODI = new System.Windows.Forms.Button();
            this.bClean = new System.Windows.Forms.Button();
            this.bDEL = new System.Windows.Forms.Button();
            this.gI1920DataSet = new farmacia.GI1920DataSet();
            this.tRolBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.tRolTableAdapter = new farmacia.GI1920DataSetTableAdapters.tRolTableAdapter();
            this.rolNameDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.rolDesDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.adminDataGridViewCheckBoxColumn = new System.Windows.Forms.DataGridViewCheckBoxColumn();
            this.dataGridView2 = new System.Windows.Forms.DataGridView();
            this.cPantalla = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.cAcceso = new System.Windows.Forms.DataGridViewCheckBoxColumn();
            this.cInsertar = new System.Windows.Forms.DataGridViewCheckBoxColumn();
            this.cActualizar = new System.Windows.Forms.DataGridViewCheckBoxColumn();
            this.cBorrar = new System.Windows.Forms.DataGridViewCheckBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.gI1920DataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tRolBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Verdana", 36F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(222, 26);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(186, 59);
            this.label1.TabIndex = 0;
            this.label1.Text = "ROLES";
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AllowUserToDeleteRows = false;
            this.dataGridView1.AllowUserToOrderColumns = true;
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.rolNameDataGridViewTextBoxColumn,
            this.rolDesDataGridViewTextBoxColumn,
            this.adminDataGridViewCheckBoxColumn});
            this.dataGridView1.DataSource = this.tRolBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(41, 118);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.Size = new System.Drawing.Size(394, 150);
            this.dataGridView1.TabIndex = 1;
            this.dataGridView1.SelectionChanged += new System.EventHandler(this.dataGridView1_SelectionChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(41, 308);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(51, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "RolName";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(38, 359);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(42, 13);
            this.label3.TabIndex = 3;
            this.label3.Text = "RolDes";
            // 
            // cAdmin
            // 
            this.cAdmin.AutoSize = true;
            this.cAdmin.Location = new System.Drawing.Point(380, 307);
            this.cAdmin.Name = "cAdmin";
            this.cAdmin.Size = new System.Drawing.Size(55, 17);
            this.cAdmin.TabIndex = 4;
            this.cAdmin.Text = "Admin";
            this.cAdmin.UseVisualStyleBackColor = true;
            // 
            // tRolName
            // 
            this.tRolName.Location = new System.Drawing.Point(113, 308);
            this.tRolName.Name = "tRolName";
            this.tRolName.Size = new System.Drawing.Size(225, 20);
            this.tRolName.TabIndex = 5;
            // 
            // tRolDes
            // 
            this.tRolDes.Location = new System.Drawing.Point(113, 359);
            this.tRolDes.Name = "tRolDes";
            this.tRolDes.Size = new System.Drawing.Size(225, 20);
            this.tRolDes.TabIndex = 6;
            // 
            // bExit
            // 
            this.bExit.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bExit.BackgroundImage")));
            this.bExit.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bExit.Location = new System.Drawing.Point(44, 26);
            this.bExit.Name = "bExit";
            this.bExit.Size = new System.Drawing.Size(119, 59);
            this.bExit.TabIndex = 7;
            this.bExit.UseVisualStyleBackColor = true;
            this.bExit.Click += new System.EventHandler(this.bExit_Click);
            // 
            // bINS
            // 
            this.bINS.Location = new System.Drawing.Point(41, 417);
            this.bINS.Name = "bINS";
            this.bINS.Size = new System.Drawing.Size(75, 23);
            this.bINS.TabIndex = 8;
            this.bINS.Text = "Añadir";
            this.bINS.UseVisualStyleBackColor = true;
            this.bINS.Click += new System.EventHandler(this.bINS_Click);
            // 
            // bMODI
            // 
            this.bMODI.Location = new System.Drawing.Point(181, 417);
            this.bMODI.Name = "bMODI";
            this.bMODI.Size = new System.Drawing.Size(75, 23);
            this.bMODI.TabIndex = 9;
            this.bMODI.Text = "Modificar";
            this.bMODI.UseVisualStyleBackColor = true;
            this.bMODI.Click += new System.EventHandler(this.bMODI_Click);
            // 
            // bClean
            // 
            this.bClean.Location = new System.Drawing.Point(455, 417);
            this.bClean.Name = "bClean";
            this.bClean.Size = new System.Drawing.Size(75, 23);
            this.bClean.TabIndex = 11;
            this.bClean.Text = "Limpiar";
            this.bClean.UseVisualStyleBackColor = true;
            this.bClean.Click += new System.EventHandler(this.bClean_Click);
            // 
            // bDEL
            // 
            this.bDEL.Location = new System.Drawing.Point(315, 417);
            this.bDEL.Name = "bDEL";
            this.bDEL.Size = new System.Drawing.Size(75, 23);
            this.bDEL.TabIndex = 10;
            this.bDEL.Text = "Borrar";
            this.bDEL.UseVisualStyleBackColor = true;
            this.bDEL.Click += new System.EventHandler(this.bDEL_Click);
            // 
            // gI1920DataSet
            // 
            this.gI1920DataSet.DataSetName = "GI1920DataSet";
            this.gI1920DataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // tRolBindingSource
            // 
            this.tRolBindingSource.DataMember = "tRol";
            this.tRolBindingSource.DataSource = this.gI1920DataSet;
            // 
            // tRolTableAdapter
            // 
            this.tRolTableAdapter.ClearBeforeFill = true;
            // 
            // rolNameDataGridViewTextBoxColumn
            // 
            this.rolNameDataGridViewTextBoxColumn.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.DisplayedCells;
            this.rolNameDataGridViewTextBoxColumn.DataPropertyName = "rolName";
            this.rolNameDataGridViewTextBoxColumn.HeaderText = "rolName";
            this.rolNameDataGridViewTextBoxColumn.Name = "rolNameDataGridViewTextBoxColumn";
            this.rolNameDataGridViewTextBoxColumn.ReadOnly = true;
            this.rolNameDataGridViewTextBoxColumn.Width = 71;
            // 
            // rolDesDataGridViewTextBoxColumn
            // 
            this.rolDesDataGridViewTextBoxColumn.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            this.rolDesDataGridViewTextBoxColumn.DataPropertyName = "rolDes";
            this.rolDesDataGridViewTextBoxColumn.HeaderText = "rolDes";
            this.rolDesDataGridViewTextBoxColumn.Name = "rolDesDataGridViewTextBoxColumn";
            this.rolDesDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // adminDataGridViewCheckBoxColumn
            // 
            this.adminDataGridViewCheckBoxColumn.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.DisplayedCells;
            this.adminDataGridViewCheckBoxColumn.DataPropertyName = "admin";
            this.adminDataGridViewCheckBoxColumn.HeaderText = "admin";
            this.adminDataGridViewCheckBoxColumn.Name = "adminDataGridViewCheckBoxColumn";
            this.adminDataGridViewCheckBoxColumn.ReadOnly = true;
            this.adminDataGridViewCheckBoxColumn.Width = 41;
            // 
            // dataGridView2
            // 
            this.dataGridView2.AllowUserToOrderColumns = true;
            this.dataGridView2.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView2.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.cPantalla,
            this.cAcceso,
            this.cInsertar,
            this.cActualizar,
            this.cBorrar});
            this.dataGridView2.Location = new System.Drawing.Point(488, 118);
            this.dataGridView2.Name = "dataGridView2";
            this.dataGridView2.Size = new System.Drawing.Size(544, 150);
            this.dataGridView2.TabIndex = 12;
            // 
            // cPantalla
            // 
            this.cPantalla.HeaderText = "Pantalla";
            this.cPantalla.Name = "cPantalla";
            // 
            // cAcceso
            // 
            this.cAcceso.HeaderText = "Acceso";
            this.cAcceso.Name = "cAcceso";
            // 
            // cInsertar
            // 
            this.cInsertar.HeaderText = "Insertar";
            this.cInsertar.Name = "cInsertar";
            // 
            // cActualizar
            // 
            this.cActualizar.HeaderText = "Actualizar";
            this.cActualizar.Name = "cActualizar";
            // 
            // cBorrar
            // 
            this.cBorrar.HeaderText = "Borrar";
            this.cBorrar.Name = "cBorrar";
            // 
            // FRoles
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(1044, 471);
            this.Controls.Add(this.dataGridView2);
            this.Controls.Add(this.bClean);
            this.Controls.Add(this.bDEL);
            this.Controls.Add(this.bMODI);
            this.Controls.Add(this.bINS);
            this.Controls.Add(this.bExit);
            this.Controls.Add(this.tRolDes);
            this.Controls.Add(this.tRolName);
            this.Controls.Add(this.cAdmin);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.label1);
            this.Name = "FRoles";
            this.Text = "FRoles";
            this.Load += new System.EventHandler(this.FRoles_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.gI1920DataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tRolBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.CheckBox cAdmin;
        private System.Windows.Forms.TextBox tRolName;
        private System.Windows.Forms.TextBox tRolDes;
        private System.Windows.Forms.Button bExit;
        private System.Windows.Forms.Button bINS;
        private System.Windows.Forms.Button bMODI;
        private System.Windows.Forms.Button bClean;
        private System.Windows.Forms.Button bDEL;
        private GI1920DataSet gI1920DataSet;
        private System.Windows.Forms.BindingSource tRolBindingSource;
        private GI1920DataSetTableAdapters.tRolTableAdapter tRolTableAdapter;
        private System.Windows.Forms.DataGridViewTextBoxColumn rolNameDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn rolDesDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewCheckBoxColumn adminDataGridViewCheckBoxColumn;
        private System.Windows.Forms.DataGridView dataGridView2;
        private System.Windows.Forms.DataGridViewTextBoxColumn cPantalla;
        private System.Windows.Forms.DataGridViewCheckBoxColumn cAcceso;
        private System.Windows.Forms.DataGridViewCheckBoxColumn cInsertar;
        private System.Windows.Forms.DataGridViewCheckBoxColumn cActualizar;
        private System.Windows.Forms.DataGridViewCheckBoxColumn cBorrar;
    }
}