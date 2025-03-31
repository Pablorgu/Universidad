
//Pablo Ruiz Galianez
/**UNIX Shell Project

Sistemas Operativos
Grados I. Informatica, Computadores & Software
Dept. Arquitectura de Computadores - UMA

Some code adapted from "Fundamentos de Sistemas Operativos", Silberschatz et al.

To compile and run the program:
   $ gcc Shell_project.c job_control.c -o Shell
   $ ./Shell          
	(then type ^D to exit program)

**/

#include "job_control.h"   // remember to compile with module job_control.c 
#include <string.h>

#define MAX_LINE 256 /* 256 chars per line, per command, should be enough. */

job *tareas;
int contadorfinal=0;
int contadorpp=0;

void manejador(int senial) {
	block_SIGCHLD();
	job *item;
	int status;
	int info;
	int pid_wait = 0;
	enum status status_res;

	for (int i = list_size(tareas); i > 0; i--){
		
		item = get_item_bypos(tareas, i);
		if(item->state != FOREGROUND){
			pid_wait = waitpid(item->pgid, &status, WUNTRACED |  WNOHANG | WCONTINUED);
			if (pid_wait == item->pgid){ //por que?
				status_res = analyze_status(status, &info);
				if (status_res == SUSPENDED){ //Si el proceso esta suspendido lo paro
					printf("Background pid: %d, command %s, has been suspended \n", 
					item->pgid, item->command);
					item->state = STOPPED;
				}else if (status_res == EXITED){ //Si el proceso ha salido se finaliza
					printf("He terminado\n");
					printf("Background pid: %d, command %s has finished.\n",
					item->pgid, item->command);
					delete_job(tareas, item);
				}else if (status_res == SIGNALED){ //Si el proceso esta signaled se finaliza
					printf("Background pid: %d, command %s has finished.\n",
					item->pgid, item->command);
					delete_job(tareas, item);
				}else if (status_res == CONTINUED){ //Si el proceso quiere continuar se ejecuta en segundo plano
					printf("Background pid: %d, command %s, has been continued\n", 
					item->pgid, item->command);
					item->state = BACKGROUND;
				}
			}
		}
	}	
	unblock_SIGCHLD();
}


// -----------------------------------------------------------------------
//                            MAIN          
// -----------------------------------------------------------------------

int main(void)
{
	char inputBuffer[MAX_LINE]; /* buffer to hold the command entered */
	int background;             /* equals 1 if a command is followed by '&' */
	char *args[MAX_LINE/2];     /* command line (of 256) has max of 128 arguments */
	// probably useful variables:
	int pid_fork, pid_wait; /* pid for created and waited process */
	int status;             /* status returned by wait */
	enum status status_res; /* status processed by analyze_status() */
	int info;				/* info processed by analyze_status() */

	job *item;
	int primerplano = 0;


	ignore_terminal_signals();
	signal(SIGCHLD, manejador);
	tareas = new_list("Tareas");

	while (1)   /* Program terminates normally inside get_command() after ^D is typed*/
	{   		
		printf("COMMAND->");
		fflush(stdout);
		get_command(inputBuffer, MAX_LINE, args, &background);  /* get next command */
		
		if(args[0]==NULL) continue;   // if empty command

		if(!strcmp(args[0], "cd")) { //Mueve al directorio indicado
			int err = chdir(args[1]);
			if(!err) printf("ERROR: Directorio erroneo");
			continue;
		}

		if (!strcmp(args[0], "jobs")) { //Muestra la lista de procesos
			block_SIGCHLD();
			print_job_list(tareas);
			unblock_SIGCHLD();
			continue;
		}

		if(!strcmp(args[0], "bg")){ //Envia un proceso a segundo plano
			block_SIGCHLD();
			int pos = 1;
			if(args[1] != NULL) {
				pos = atoi(args[1]);
			}
			item = get_item_bypos(tareas, pos);
			if((item != NULL) && (item->state == STOPPED)) {
				item->state = BACKGROUND;
				killpg(item->pgid, SIGCONT);
			}
			unblock_SIGCHLD();
			continue;
		}
		
		if(!strcmp(args[0], "fg")) { //Envia a primer plano un proceso en segundo plano
			block_SIGCHLD();
			int pos = 1;
			if(args[1] != NULL) {
				pos = atoi(args[1]);
			}
			item = get_item_bypos(tareas, pos);
			if(item!=NULL) {
				set_terminal(item->pgid);
				if(item->state == STOPPED) {
					killpg(item->pgid, SIGCONT);
					item->state = FOREGROUND;
				}
				waitpid(item->pgid, &status, WUNTRACED);
				status_res = analyze_status(status, &info);
				set_terminal(getpid());
				printf("Foreground pid: %d, command: %s, status: %s, info %d \n"
				,item->pgid, item->command, status_strings[status_res], info);
				if(status_res == EXITED || status_res == SIGNALED) {
					if(status_res==SIGNALED){
						contadorpp++;
					}
					delete_job(tareas, item);
				}
				else if(status_res == SUSPENDED){ 
					item -> state = STOPPED;
				}
			}
			unblock_SIGCHLD();
			continue;
		}

		if(!strcmp(args[0], "killbg")) {
			block_SIGCHLD();
			job *aux;
			FILE * f = fopen("putlog.log", "a");
			for (int i = list_size(tareas); i > 0; i--){
				aux = get_item_bypos(tareas, i);
				if(aux->state != STOPPED){
					fprintf(f, "El comando %s ha sido eliminado\n", aux->command);
					killpg(aux->pgid, SIGINT);
				}
			}
			fclose(f);
			
			unblock_SIGCHLD();
			continue;
		}

		if(!primerplano) pid_fork = fork();
		if (pid_fork > 0) {
			if(background == 0) { //Proceso en primer plano
				waitpid(pid_fork, &status, WUNTRACED);
				set_terminal(getpid());
				status_res =analyze_status(status, &info);
				if (status_res == SUSPENDED) {
						block_SIGCHLD();
						item=new_job(pid_fork, args[0], STOPPED);
						add_job(tareas, item);
						printf("\nForeground pid: %d, command %s, %s, info: %d \n",
						 pid_fork, args[0],status_strings[status_res], info);
						unblock_SIGCHLD();
				} else if(status_res == EXITED || status_res== SIGNALED) {
					if(status_res == SIGNALED) {
						++contadorpp;
						printf("Contador de procesos terminados por SIGNALED: %i\n", contadorpp);
					}
					if(info!=255) {
						printf("Foreground pid: %d, command %s, %s, info: %d \n", pid_fork, args[0],status_strings[status_res], info);
					}
				}
			primerplano = 0;
			} else { //Proceso en segundo plano
				block_SIGCHLD();
				item = new_job(pid_fork, args[0], BACKGROUND);
				add_job(tareas, item);
				printf("Background job running... pid: %d, command: %s \n", pid_fork, args[0]);
				unblock_SIGCHLD();
			} 
		} else { //Hijo
			new_process_group(getpid());
			if(background == 0 ) {	
				set_terminal(getpid());
			}
			restore_terminal_signals();
			execvp(args[0], args);
			printf("\nError, command %s not found\n", args[0]);
			exit(-1);
		}
	} // end while
}
