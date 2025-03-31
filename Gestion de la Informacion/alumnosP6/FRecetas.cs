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


        public FRecetas(Usuario user)
        {
            InitializeComponent();
            this.user = user;

        }

        private void FRecetas_Load(object sender, EventArgs e)
        {


        }

    }
}
