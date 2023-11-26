namespace farmacia
{
    partial class FLogin
    {
        /// <summary>
        /// Variable del diseñador requerida.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén utilizando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido del método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FLogin));
            this.tPwd = new System.Windows.Forms.TextBox();
            this.lpwd = new System.Windows.Forms.Label();
            this.bLogin = new System.Windows.Forms.Button();
            this.tUser = new System.Windows.Forms.TextBox();
            this.lUser = new System.Windows.Forms.Label();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.usuariosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.pacientesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.recetasToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.cerrarSesionToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.salirToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.bAuditoria = new System.Windows.Forms.Button();
            this.bExit = new System.Windows.Forms.Button();
            this.bRecetas = new System.Windows.Forms.Button();
            this.bPACIENTES = new System.Windows.Forms.Button();
            this.bUSUARIOS = new System.Windows.Forms.Button();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // tPwd
            // 
            this.tPwd.Location = new System.Drawing.Point(348, 56);
            this.tPwd.Margin = new System.Windows.Forms.Padding(2);
            this.tPwd.Name = "tPwd";
            this.tPwd.PasswordChar = '*';
            this.tPwd.Size = new System.Drawing.Size(126, 20);
            this.tPwd.TabIndex = 11;
            // 
            // lpwd
            // 
            this.lpwd.AutoSize = true;
            this.lpwd.Font = new System.Drawing.Font("Verdana", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lpwd.Location = new System.Drawing.Point(264, 58);
            this.lpwd.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lpwd.Name = "lpwd";
            this.lpwd.Size = new System.Drawing.Size(83, 16);
            this.lpwd.TabIndex = 12;
            this.lpwd.Text = "Contraseña";
            // 
            // bLogin
            // 
            this.bLogin.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bLogin.BackgroundImage")));
            this.bLogin.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bLogin.Location = new System.Drawing.Point(483, 48);
            this.bLogin.Margin = new System.Windows.Forms.Padding(2);
            this.bLogin.Name = "bLogin";
            this.bLogin.Size = new System.Drawing.Size(89, 35);
            this.bLogin.TabIndex = 13;
            this.bLogin.UseVisualStyleBackColor = true;
            this.bLogin.Click += new System.EventHandler(this.bLogin_Click);
            // 
            // tUser
            // 
            this.tUser.Location = new System.Drawing.Point(129, 56);
            this.tUser.Margin = new System.Windows.Forms.Padding(2);
            this.tUser.Name = "tUser";
            this.tUser.Size = new System.Drawing.Size(126, 20);
            this.tUser.TabIndex = 10;
            // 
            // lUser
            // 
            this.lUser.AutoSize = true;
            this.lUser.Font = new System.Drawing.Font("Verdana", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lUser.Location = new System.Drawing.Point(62, 58);
            this.lUser.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lUser.Name = "lUser";
            this.lUser.Size = new System.Drawing.Size(56, 16);
            this.lUser.TabIndex = 9;
            this.lUser.Text = "Usuario";
            // 
            // menuStrip1
            // 
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.usuariosToolStripMenuItem,
            this.pacientesToolStripMenuItem,
            this.recetasToolStripMenuItem,
            this.cerrarSesionToolStripMenuItem,
            this.salirToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Padding = new System.Windows.Forms.Padding(4, 2, 0, 2);
            this.menuStrip1.Size = new System.Drawing.Size(604, 24);
            this.menuStrip1.TabIndex = 16;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // usuariosToolStripMenuItem
            // 
            this.usuariosToolStripMenuItem.Name = "usuariosToolStripMenuItem";
            this.usuariosToolStripMenuItem.Size = new System.Drawing.Size(64, 20);
            this.usuariosToolStripMenuItem.Text = "Usuarios";
            this.usuariosToolStripMenuItem.Click += new System.EventHandler(this.usuariosToolStripMenuItem_Click);
            // 
            // pacientesToolStripMenuItem
            // 
            this.pacientesToolStripMenuItem.Name = "pacientesToolStripMenuItem";
            this.pacientesToolStripMenuItem.Size = new System.Drawing.Size(69, 20);
            this.pacientesToolStripMenuItem.Text = "Pacientes";
            this.pacientesToolStripMenuItem.Click += new System.EventHandler(this.pacientesToolStripMenuItem_Click);
            // 
            // recetasToolStripMenuItem
            // 
            this.recetasToolStripMenuItem.Name = "recetasToolStripMenuItem";
            this.recetasToolStripMenuItem.Size = new System.Drawing.Size(59, 20);
            this.recetasToolStripMenuItem.Text = "Recetas";
            this.recetasToolStripMenuItem.Click += new System.EventHandler(this.recetasToolStripMenuItem_Click);
            // 
            // cerrarSesionToolStripMenuItem
            // 
            this.cerrarSesionToolStripMenuItem.Name = "cerrarSesionToolStripMenuItem";
            this.cerrarSesionToolStripMenuItem.Size = new System.Drawing.Size(88, 20);
            this.cerrarSesionToolStripMenuItem.Text = "Cerrar Sesion";
            this.cerrarSesionToolStripMenuItem.Click += new System.EventHandler(this.cerrarSesionToolStripMenuItem_Click);
            // 
            // salirToolStripMenuItem
            // 
            this.salirToolStripMenuItem.Name = "salirToolStripMenuItem";
            this.salirToolStripMenuItem.Size = new System.Drawing.Size(41, 20);
            this.salirToolStripMenuItem.Text = "Salir";
            this.salirToolStripMenuItem.Click += new System.EventHandler(this.salirToolStripMenuItem_Click);
            // 
            // bAuditoria
            // 
            this.bAuditoria.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bAuditoria.BackgroundImage")));
            this.bAuditoria.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bAuditoria.Location = new System.Drawing.Point(60, 344);
            this.bAuditoria.Margin = new System.Windows.Forms.Padding(2);
            this.bAuditoria.Name = "bAuditoria";
            this.bAuditoria.Size = new System.Drawing.Size(142, 90);
            this.bAuditoria.TabIndex = 19;
            this.bAuditoria.UseVisualStyleBackColor = true;
            // 
            // bExit
            // 
            this.bExit.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bExit.BackgroundImage")));
            this.bExit.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bExit.Location = new System.Drawing.Point(274, 344);
            this.bExit.Margin = new System.Windows.Forms.Padding(2);
            this.bExit.Name = "bExit";
            this.bExit.Size = new System.Drawing.Size(142, 90);
            this.bExit.TabIndex = 18;
            this.bExit.UseVisualStyleBackColor = true;
            this.bExit.Click += new System.EventHandler(this.bExit_Click);
            // 
            // bRecetas
            // 
            this.bRecetas.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bRecetas.BackgroundImage")));
            this.bRecetas.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bRecetas.Location = new System.Drawing.Point(60, 221);
            this.bRecetas.Margin = new System.Windows.Forms.Padding(2);
            this.bRecetas.Name = "bRecetas";
            this.bRecetas.Size = new System.Drawing.Size(142, 90);
            this.bRecetas.TabIndex = 17;
            this.bRecetas.UseVisualStyleBackColor = true;
            this.bRecetas.Click += new System.EventHandler(this.bRecetas_Click);
            // 
            // bPACIENTES
            // 
            this.bPACIENTES.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bPACIENTES.BackgroundImage")));
            this.bPACIENTES.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bPACIENTES.Location = new System.Drawing.Point(274, 221);
            this.bPACIENTES.Margin = new System.Windows.Forms.Padding(2);
            this.bPACIENTES.Name = "bPACIENTES";
            this.bPACIENTES.Size = new System.Drawing.Size(142, 90);
            this.bPACIENTES.TabIndex = 15;
            this.bPACIENTES.UseVisualStyleBackColor = true;
            this.bPACIENTES.Click += new System.EventHandler(this.bPACIENTES_Click);
            // 
            // bUSUARIOS
            // 
            this.bUSUARIOS.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bUSUARIOS.BackgroundImage")));
            this.bUSUARIOS.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bUSUARIOS.Location = new System.Drawing.Point(60, 96);
            this.bUSUARIOS.Margin = new System.Windows.Forms.Padding(2);
            this.bUSUARIOS.Name = "bUSUARIOS";
            this.bUSUARIOS.Size = new System.Drawing.Size(142, 90);
            this.bUSUARIOS.TabIndex = 14;
            this.bUSUARIOS.UseVisualStyleBackColor = true;
            this.bUSUARIOS.Click += new System.EventHandler(this.bUSUARIOS_Click);
            // 
            // FLogin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(604, 467);
            this.Controls.Add(this.tPwd);
            this.Controls.Add(this.lpwd);
            this.Controls.Add(this.bLogin);
            this.Controls.Add(this.tUser);
            this.Controls.Add(this.lUser);
            this.Controls.Add(this.menuStrip1);
            this.Controls.Add(this.bAuditoria);
            this.Controls.Add(this.bExit);
            this.Controls.Add(this.bRecetas);
            this.Controls.Add(this.bPACIENTES);
            this.Controls.Add(this.bUSUARIOS);
            this.Name = "FLogin";
            this.Text = "LOGIN";
            this.Load += new System.EventHandler(this.FLogin_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox tPwd;
        private System.Windows.Forms.Label lpwd;
        private System.Windows.Forms.Button bLogin;
        private System.Windows.Forms.TextBox tUser;
        private System.Windows.Forms.Label lUser;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem usuariosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem pacientesToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem recetasToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem cerrarSesionToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem salirToolStripMenuItem;
        private System.Windows.Forms.Button bAuditoria;
        private System.Windows.Forms.Button bExit;
        private System.Windows.Forms.Button bRecetas;
        private System.Windows.Forms.Button bPACIENTES;
        private System.Windows.Forms.Button bUSUARIOS;
    }
}

