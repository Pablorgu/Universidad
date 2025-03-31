using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BDLibrary;

namespace farmacia
{
    public class Provincia
    {
        private string cod;
        private string nombre;

        private static string BD_SERVER = Properties.Settings.Default.BD_SERVER;
        private static string BD_NAME = Properties.Settings.Default.BD_NAME;

        public static List<Provincia> ListaProvincias()
        {
            List<Provincia> lista = new List<Provincia>();
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            foreach (object[] tupla in miBD.Select("SELECT Codigo FROM tProvincia;"))
            {
                string id = (string)tupla[0];
                Provincia p = new Provincia(id);
                lista.Add(p);
            }

            return lista;
        }

        public Provincia(string cod)
        {
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            object[] tupla = miBD.Select("SELECT * FROM tProvincia WHERE Codigo='" + cod + "';")[0];

            this.cod = (string)tupla[0];
            this.nombre = (string)tupla[1];
        }

        public Provincia(string cod, string des)
        {
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            miBD.Insert("INSERT INTO tProvincia VALUES('" + cod + "', '" + des + "');");
            this.cod = cod;
            this.nombre = des;
        }

        public string Codigo
        {
            get { return cod; }
            set
            {
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tProvincia SET Codigo = '" + value
                    + "' WHERE Codigo='" + this.cod + "';");
                cod = value;
            }
        }

        public string Nombre
        {
            get { return nombre; }
            set
            {
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tProvincia SET Nombre = '" + value
                    + "' WHERE Codigo='" + this.cod + "';");
                nombre = value;
            }
        }

        public void BorrarProvincia()
        {
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            miBD.Delete("DELETE FROM tProvincia WHERE Codigo='" + this.cod + "';");

            this.cod = null;
            this.nombre = null;
        }

        public override string ToString()
        {
            return nombre;
        }

        public override bool Equals(object obj)
        {
            return obj is Provincia && (((Provincia)obj).Codigo.ToUpper().CompareTo(this.Codigo.ToUpper()) == 0);
        }

        public override int GetHashCode()
        {
            return Codigo.GetHashCode();
        }
    }
}
