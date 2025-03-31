using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BDLibrary;

namespace farmacia
{
    public class Permiso
    {
        private static string BD_SERVER = Properties.Settings.Default.BD_SERVER;
        private static string BD_NAME = Properties.Settings.Default.BD_NAME;

        private string rolName;
        private string pantalla;
        private bool acceso;
        private bool insertar;
        private bool modificar;
        private bool borrar;


        public static List<Permiso> ListaPermisosRol(string rolName)
        {
		    List<Permiso> lista = new List<Permiso>();
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);

            foreach (object[] tupla in miBD.Select("SELECT pantalla FROM tPermiso WHERE rolName = '"+ rolName+"';"))
            {
                string pantalla = (string)tupla[0];
                lista.Add(new Permiso(rolName,pantalla));
            }
		    return lista;
        }

        public Permiso(String r, String p)
        {
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);

            object[] tupla = miBD.Select("SELECT * FROM tPermiso WHERE rolName = '" + r + "' AND pantalla = '" + p + "';")[0];
            rolName = (string)tupla[0];
            pantalla = (string)tupla[1];
            acceso = (bool)tupla[2];
            insertar = (bool)tupla[3];
            modificar = (bool)tupla[4];
            borrar = (bool)tupla[5];
        }

        public Permiso(string r, string p, bool a, bool i, bool m, bool b)
        {
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);

            miBD.Insert("INSERT INTO tPermiso VALUESS('" + r + "','" + p + "'," 
                        + (a ? 1 : 0) + "," + (i ? 1 : 0) + "," + (m ? 1 : 0) + "," + (b ? 1 : 0) + ");");
            rolName = r;
            pantalla = p;
            acceso = a;
            insertar = i;
            modificar = m;
            borrar = b;
        }

        public string RolName
        {
            get { return rolName; }
            set
            {
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPermiso SET rolName = '" + value + "' "
                        + "WHERE rolName = '" + rolName + "' AND pantalla = '" + pantalla + "';");
                rolName = value;
            }
        }

        public string Pantalla
        {
            get { return pantalla; }
            set
            {
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPermiso SET pantalla = '" + value + "' "
                        + "WHERE rolName = '" + rolName + "' AND pantalla = '" + pantalla + "';");

                pantalla = value;
            }
        }

        public bool Acceso
        {
            get { return acceso; }
            set 
            {
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPermiso SET acceso = " + (value?1:0) + " "
                        + "WHERE rolName = '" + rolName + "' AND pantalla = '" + pantalla + "';");
                           
                acceso = value;                 
            }
        }

        public bool Insertar
        {
            get { return insertar; }
            set
            {
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPermiso SET insertar = " + (value ? 1 : 0) + " "
                        + "WHERE rolName = '" + rolName + "' AND pantalla = '" + pantalla + "';");

                insertar = value;
            }
        }

        public bool Modificar
        {
            get { return modificar; }
            set
            {
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPermiso SET modificar = " + (value ? 1 : 0) + " "
                        + "WHERE rolName = '" + rolName + "' AND pantalla = '" + pantalla + "';");

                modificar = value;
            }
        }

        public bool Borrar
        {
            get { return borrar; }
            set 
            {
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPermiso SET borrar = " + (value ? 1 : 0) + " "
                        + "WHERE rolName = '" + rolName + "' AND pantalla = '" + pantalla + "';");

                borrar = value;                 
            }
        }

        public void BorrarPermiso()
        {
            //DELETE
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            miBD.Delete("DELETE FROM tPermiso WHERE rolName = '" + rolName + "' AND pantalla = '" + pantalla + "';");

            rolName = null;
            pantalla = null;
            acceso = false;
            insertar = false;
            modificar = false;
            borrar = false;

        }

        public override string ToString()
        {
            return rolName+";"+pantalla+";"+acceso+";"+insertar+";"+modificar+";"+borrar;
        }

        public override bool Equals(object obj)
        {
            return (obj is Permiso)
                && (((Permiso)obj).RolName.Equals(this.RolName))
                && (((Permiso)obj).Pantalla.Equals(this.Pantalla));
        }

        public override int GetHashCode()
        {
            return RolName.GetHashCode() * 10000 + Pantalla.GetHashCode();
        }
    }
}
