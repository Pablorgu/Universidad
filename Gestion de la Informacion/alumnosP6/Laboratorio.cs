using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BDLibrary;

namespace farmacia
{
    class Laboratorio
    {        
        private string cif;
        private string nombre;
        private string poblacion;
        private Provincia provincia;

        private static string BD_SERVER = Properties.Settings.Default.BD_SERVER;
        private static string BD_NAME = Properties.Settings.Default.BD_NAME;

        public static List<Laboratorio> ListaLaboratorios()
        {
            List<Laboratorio> lista = new List<Laboratorio>();
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            foreach (object[] tupla in miBD.Select("SELECT CIF FROM tLaboratorio;"))
            {
                string cif = (string)tupla[0];
                Laboratorio l = new Laboratorio(cif);
                lista.Add(l);
            }

            return lista;
        }

        public Laboratorio(string cif)
        {
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            object[] tupla = miBD.Select("SELECT * FROM tLaboratorio WHERE CIF='" + cif + "';")[0];

            this.cif = (string)tupla[0];
            this.nombre = (string)tupla[1];
            this.poblacion = (string)tupla[2];
            this.provincia = new Provincia((string)tupla[3]);
        }

        public Laboratorio(string cif, string nombre, string poblacion, Provincia provincia)
        {
            cif = cif.ToUpper(); // Siempre en Mayúsculas
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);            
            miBD.Insert("INSERT INTO tLaboratorio VALUES('" + cif + "', '" + nombre + "', '" + poblacion + "', '" + provincia.Codigo + "');");
            this.cif = cif;
            this.nombre = nombre;
            this.poblacion = poblacion;
            this.provincia = provincia;
        }

        public string CIF
        {
            get { return cif; }
            set
            {
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tLaboratorio SET CIF = '" + value
                    + "' WHERE CIF='" + this.cif + "';");
                cif = value;
            }
        }

        public string Nombre
        {
            get { return nombre; }
            set
            {
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tLaboratorio SET Nombre = '" + value
                    + "' WHERE CIF='" + this.cif + "';");
                nombre = value;
            }
        }

        public string Poblacion
        {
            get { return poblacion; }
            set
            {
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tLaboratorio SET Poblacion = '" + value
                    + "' WHERE CIF='" + this.cif + "';");
                poblacion = value;
            }
        }

        public Provincia Provincia
        {
            get { return provincia; }
            set
            {
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tLaboratorio SET Provincia = '" + value.Codigo
                    + "' WHERE CIF='" + this.cif + "';");
                provincia = value;
            }
        }
        public void BorrarLaboratorio()
        {
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            miBD.Delete("DELETE FROM tLaboratorio WHERE CIF='" + this.cif + "';");

            this.cif = null;
            this.nombre = null;
            this.poblacion = null;
            this.provincia = null;
        }

        public override string ToString()
        {
            return cif + " " + nombre;
        }

        public override bool Equals(object obj)
        {
            return obj is Laboratorio && (((Laboratorio)obj).CIF.CompareTo(this.CIF) == 0);
        }

        public override int GetHashCode()
        {
            return CIF.GetHashCode();
        }
    }
}
