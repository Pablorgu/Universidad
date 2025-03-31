using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BDLibrary;

namespace farmacia
{
    public class Usuario
    {
        private static string BD_SERVER = Properties.Settings.Default.BD_SERVER;
        private static string BD_NAME = Properties.Settings.Default.BD_NAME;


        private string nif;
        private string password;
        private Rol rol;


	    public static List<Usuario> ListaUsuarios()
	    {
		    List<Usuario> lista = new List<Usuario>();

            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);

            foreach (object[] tupla in miBD.Select("SELECT nif, password FROM tUsuario;"))
            {
                string n = (string)tupla[0];
                string p = (string)tupla[1];
                lista.Add(new Usuario(n,p));
            }

		    return lista;
	    }

        public Usuario(string n, string p)
        {

            try
            {
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                object[] tupla = miBD.Select("SELECT * FROM tUsuario WHERE nif = '" + n + "';")[0];

                nif = (string)tupla[0];
                password = (string)tupla[1];

                if (!password.Equals(p))
                {
                    nif = password = null;
                    throw new Error("Usuario o Contraseña Incorrecta: ");
                }

                rol = new Rol((string)tupla[2]);
            }
            catch
            {
                throw new Error("Usuario o Contraseña Incorrecta: ");
            }
                
        }

        public Usuario(string n, string p, Rol r)
        {

            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);

            miBD.Insert("INSERT INTO tUsuario VALUES('" + n + "', '"
                + p + "', '" + r.RolName + "');");

            nif = n;
            password = p;
            rol = r;

        }

        public string NIF
        {
            get { return nif; }
            set {
                    SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                    miBD.Update("UPDATE tUsuario SET nif = '" + value
                            + "' WHERE nif = '" + nif + "';");
                    nif = value;
                }
        }

        public string Password
        {
            get { return password; }
            set {
                    SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                    miBD.Update("UPDATE tUsuario SET password = '" + value
                            + "' WHERE nif = '" + nif + "';");
                    password = value;
                }
        }

        public Rol MyRol
        {
            get { return rol; }
        }

        public void ModiRol(Usuario u, Rol r)
        {
            if (!this.rol.Admin)
                throw new Error("El usuario " + this.NIF
                    + " no puede cambiar el rol del usuario " + u.NIF);
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            miBD.Update("UPDATE tUsuario SET rolName = '" + r.RolName
                    + "' WHERE nif = '" + u.NIF + "';");
            u.rol = r;

        }

        public void BorrarUsuario()
        {
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            miBD.Delete("DELETE tUsuario WHERE nif = '" + nif + "';");
            nif = password = null;
            rol = null;
        }


        public bool AccesoPantalla(string p)
        {
            return rol.Acceso(p);
        }

        public bool InsertarPantalla(string p)
        {
            return rol.Insertar(p);
        }

        public bool ModificarPantalla(string p)
        {
            return rol.Modificar(p);
        }

        public bool BorrarPantalla(string p)
        {
            return rol.Borrar(p);
        }

        public override string ToString()
        {
            return nif + ";" + password + ";" + rol;
        }

        public override bool Equals(object obj)
        {
            return obj is Usuario && ((Usuario)obj).NIF.Equals(NIF);
        }

        public override int GetHashCode()
        {
            return NIF.GetHashCode();
        }
    }
}
