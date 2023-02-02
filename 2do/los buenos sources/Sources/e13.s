.include "inter.inc"
.include "notas.inc"

.text
  mrs r0, cpsr
  mov r0, #0b11010011 @Modo SVC, FIQ&IRQ desact
  msr spsr_cxsf, r0
  add r0, pc, #4
  msr ELR_hyp, r0
  eret
	
/* INTERRUPCIONES Y SVC */	
mov r0, #0
ADDEXC 0x18, irq_handler
mov r0, #0b11010010 
msr cpsr_c, r0
mov sp, #0x8000 @modo  IRQ
mov r0, #0b11010011 
msr cpsr_c, r0
mov sp, #0x8000000 @modo supervisor SVC

/* LEDS Y GPIO4 COMO SALIDA */
ldr     r0, =GPBASE
/* guia bits              xx999888777666555444333222111000*/
ldr r1, 	 =0b00001000000000000001000000000000
str     r1, [r0, #GPFSEL0]
/* guia bits           xx999888777666555444333222111000*/
ldr r1,     =0b00000000001000000000000000001001
str r1, [r0, #GPFSEL1]
/* guia bits          xx999888777666555444333222111000*/
ldr r1,    =0b00000000001000000000000001000000
str r1, [r0, #GPFSEL2]
mov r9, #0 @est· a 0 porque el sonido est· apagado, uso r9 como contador de GPIO4

		
	/*  Primera iteraci√≥n
        r5 = (Direcci√≥n) elemento previamente encendido
        r6 = (Direcci√≥n) Siguiente elemento a encender
        r7 = (Contador) M√≥dulo de elementos encendidos hasta ahora.
            Posici√≥n de puntero
*/


ldr r4, = 200000 @tiempo para interrupciÛn canal 1
ldr r8, = LA
mov r5 , #0 @punteros
ldr r6 , =vector
mov r7 , #0
	
/* INTERRUPCIONES Y LAS HABILITAMOS  */
ldr r0, = STBASE
ldr r1, [r0, #STCLO]
add r1, r1, r4
str     r1, [r0, #STC1] @canal 1 a los milisegundos de r4

ldr r0, = STBASE
ldr r1, [r0, #STCLO]
add r1, r1, r8
str     r1, [r0, #STC3] @canal 1 a la frec de r8

ldr     r0, =INTBASE
mov     r1, #0b1010
str     r1, [r0, #INTENIRQ1]
mov     r0, #0b01010011   @ Modo SVC, IRQ activo para canal 1 y 3
msr     cpsr_c, r0

infi:		b infi

irq_handler:

/*BUSCAMOS SI LA INTERRUPCION ES DE C1 O C3 */
push {r0,r1}

ldr	r0,	=STBASE		
ldr	r1,	[r0,	#STCS]	
ands r1 , #0b0010 @si no es igual sera C1, si lo es sera C3

pop {r0,r1}

bne leds
beq GPIO4


leds:


push   {r0, r1, r2}

ldr r0, = GPBASE
ldr r1, [r6] @valor de la posiciÛn del array
str    r1, [r0, #GPSET0]	@ encendemos nuevo led
ldr    r1 , [r5]            @ Cargamos el valor anterior led
str    r1, [r0, #GPCLR0]	@ Apagamos anterior

@ preparamos anterior
mov r5, r6 
    
    
@ preparamos siguiente. Si hemos llegado al final hay que volverlo a repetir
add r7, r7, #1
ldr r0, = longitud
ldr r0, [r0]
cmp r7, r0
moveq r7, #0
ldreq r6 , = vector @desde el principio
addne r6 , r6 , #4 @ 4 bytes @sig posicion

@temporizador
		ldr r0, =STBASE
mov r1, #0b1010 @1 y 3
str r1, [r0, #STCS]
	/*		Reiniciar el timer		*/
        ldr     r1, [r0, #STCLO]
       add    r1, r1, r4
        str     r1, [r0, #STC1]		
pop   {r0, r1, r2}
subs    pc, lr, #4

GPIO4:
push   {r0, r1, r2}
ldr r0, = GPBASE
mov    r1, #0b00000000000000000000000000010000
 cmp r9, #0 @vemos si est· apagado(0) o encendido(1) GPIO4
        streq  r1, [r0, #GPSET0] 
        moveq r9, #1
        strne r1, [r0, #GPCLR0]
        movne r9, #0

@ temporizador
		ldr r0, =STBASE
mov r1, #0b1010 @1 y 3
str r1, [r0, #STCS]
	/*		Reiniciar el timer		*/
        ldr     r1, [r0, #STCLO]
       add    r1, r1, r8
        str     r1, [r0, #STC3]
pop   {r0, r1, r2}
subs    pc, lr, #4



vector:   .word 0b00000000000000000000001000000000 , 0b00000000000000000000010000000000 , 0b00000000000000000000100000000000 , 0b00000000000000100000000000000000 , 0b00000000010000000000000000000000 , 0b00001000000000000000000000000000				
longitud: .word 6