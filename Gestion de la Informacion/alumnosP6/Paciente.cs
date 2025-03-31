using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BDLibrary;

namespace farmacia
{
    public class Paciente
    {
        private static string BD_SERVER = Properties.Settings.Default.BD_SERVER;
        private static string BD_NAME = Properties.Settings.Default.BD_NAME;

        private string DNI_NIE;
        private int NumSS;
        private string Nombre;
        private string Apellidos;
        private string Sexo;
        private DateTime FechaNacimiento;
        private string Direccion;
        private string Poblacion;
        private Provincia Provincia;
        private string CodigoPostal;
        private string Telefono;
        private string e_mail;

        public static List<Paciente> ListaPacientes()
        {
            List<Paciente> lista = new List<Paciente>();
            //COMPLETAR
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            foreach (object[] tupla in miBD.Select("SELECT NIF FROM tPaciente;"))
            {
                string DNI = (string)tupla[0];
                Paciente p = new Paciente(DNI);
                lista.Add(p);
            }
            return lista;
        }

        public Paciente(string nif)
        {
            //COMPLETAR
            // Ayuda para la fecha
            // string[] fecha = tupla[5].ToString().Split('-');
            // FechaNacimiento = new DateTime(int.Parse(fecha[0]), 
            //    int.Parse(fecha[1]), 
            //    int.Parse(fecha[2]));
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            object[] tupla = miBD.Select("SELECT * FROM tPaciente WHERE NIF='" + nif + "';")[0];
            this.DNI_NIE = (string)tupla[0];
            this.NumSS = (int)tupla[1];
            this.Nombre = (string)tupla[2];
            this.Apellidos = (string)tupla[3];
            this.Sexo = (string)tupla[4];
            string[] fecha = tupla[5].ToString().Split('-');
            this.FechaNacimiento = new DateTime(int.Parse(fecha[0]), int.Parse(fecha[1]), int.Parse(fecha[2]));
            this.Direccion = (string)tupla[6];
            this.Poblacion = (string)tupla[7];
            this.Provincia = new Provincia((string) tupla[8]);
            this.CodigoPostal = (string)tupla[9];
            this.Telefono = (string)tupla[10];
            this.e_mail = (string)tupla[11];
        }

        public Paciente(string DNI_NIE, int NumSS, string Nombre, string Apellidos, string Sexo,
            DateTime FechaNacimiento, string Direccion, string Poblacion, Provincia Provincia,
            string CodigoPostal, string Telefono, string e_mail)
        {
            //COMPLETAR
            // Nota. La fecha hay que escribirla como FechaNacimiento.ToShortDateString()
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            miBD.Insert("INSERT INTO tPaciente VALUES('" + DNI_NIE + "', " + NumSS + ", '" + Nombre + "', '" + Apellidos + "', '" + Sexo + "', '" + FechaNacimiento.ToShortDateString() + "', '"
                + Direccion + "', '" + Poblacion + "', '" + Provincia.Codigo + "', '" + CodigoPostal + "', '" + Telefono + "', '" + e_mail + "');");
            this.DNI_NIE = DNI_NIE;
            this.NumSS = NumSS;
            this.Nombre = Nombre;
            this.Apellidos = Apellidos;
            this.Sexo = Sexo;
            this.FechaNacimiento = FechaNacimiento;
            this.Direccion = Direccion;
            this.Poblacion = Poblacion;
            this.Provincia = Provincia;
            this.CodigoPostal = CodigoPostal;
            this.Telefono = Telefono;
            this.e_mail = e_mail;
        }

        public void BorrarPaciente()
        {
            //COMPLETAR
            SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
            miBD.Delete("DELETE from tPaciente WHERE NIF = '" + this.DNI_NIE + "';");
            this.DNI_NIE = null;
            this.NumSS = 0;
            this.Nombre = null;
            this.Apellidos = null;
            this.Sexo = null;
            this.FechaNacimiento = new DateTime();
            this.Direccion = null;
            this.Poblacion = null;
            this.Provincia = null;
            this.CodigoPostal = null;
            this.Telefono = null;
            this.e_mail=null;
        }

        public int NumeroSS_Paciente
        {
            get { return NumSS; }
            set
            {
            //COMPLETAR
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPaciente set NumSeguro = '" + value + "' WHERE NIF ='" + this.DNI_NIE + "';");
                NumSS = value;
            }
        }


        public string DNI_NIE_Paciente
        {
            get
            {
                return DNI_NIE;
            }
            set
            {
                //COMPLETAR
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPaciente set NumSeguro = '" + value + "' WHERE NIF ='" + this.DNI_NIE + "';");
                DNI_NIE = value;
            }
        }

        public string Nombre_Paciente
        {
            get
            {
                return Nombre;
            }
            set
            {
                //COMPLETAR
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPaciente set Nombre = '" + value + "' WHERE NIF ='" + this.DNI_NIE + "';");
                Nombre = value;
            }
        }

        public string Apellidos_Paciente
        {
            get
            {
                return Apellidos;
            }
            set
            {
                //COMPLETAR
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPaciente set Apellidos = '" + value + "' WHERE NIF ='" + this.DNI_NIE + "';");
                Apellidos = value;
            }
        }

        public string Sexo_Paciente
        {
            get
            {
                return Sexo;
            }
            set
            {
                //COMPLETAR
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPaciente set Sexo = '" + value + "' WHERE NIF ='" + this.DNI_NIE + "';");
                Sexo = value;
            }
        }

        public DateTime FechaNacimiento_Paciente
        {
            get
            {
                return FechaNacimiento;
            }
            set
            {
                //COMPLETAR
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPaciente set FechaNacimiento = '" + value + "' WHERE NIF ='" + this.DNI_NIE + "';");
                FechaNacimiento = value;
            }
        }

        public string Direccion_Paciente
        {
            get
            {
                return Direccion;
            }
            set
            {
                //COMPLETAR
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPaciente set Direccion = '" + value + "' WHERE NIF ='" + this.DNI_NIE + "';");
                Direccion = value;
            }
        }

        public string Poblacion_Paciente
        {
            get
            {
                return Poblacion;
            }
            set
            {
                //COMPLETAR
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPaciente set Poblacion = '" + value + "' WHERE NIF ='" + this.DNI_NIE + "';");
                Poblacion = value;
            }
        }

        public Provincia Provincia_Paciente
        {
            get
            {
                return Provincia;
            }
            set
            {
                //COMPLETAR
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPaciente set Provincia = '" + value + "' WHERE NIF ='" + this.DNI_NIE + "';");
                Provincia = value;
            }
        }

        public string CodigoPostal_Paciente
        {
            get
            {
                return CodigoPostal;
            }
            set
            {
                //COMPLETAR
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPaciente set CodigoPostal = '" + value + "' WHERE NIF ='" + this.DNI_NIE + "';");
                CodigoPostal = value;
            }
        }

        public string Telefono_Paciente
        {
            get
            {
                return Telefono;
            }
            set
            {
                //COMPLETAR
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPaciente set Telefono = '" + value + "' WHERE NIF ='" + this.DNI_NIE + "';");
                Telefono = value;
            }
        }

        public string e_mail_Paciente
        {
            get
            {
                return e_mail;
            }
            set
            {
                //COMPLETAR
                SQLSERVERDB miBD = new SQLSERVERDB(BD_SERVER, BD_NAME);
                miBD.Update("UPDATE tPaciente set e_mail = '" + value + "' WHERE NIF ='" + this.DNI_NIE + "';");
                e_mail = value;
            }
        }

        public override string ToString()
        {
            return DNI_NIE + ";" + Nombre + ";" + Apellidos;
        }

        public override bool Equals(object obj)
        {
            return obj is Paciente && ((Paciente)obj).DNI_NIE.Equals(DNI_NIE);
        }

        public override int GetHashCode()
        {
            return DNI_NIE.GetHashCode();
        }
    }
}
