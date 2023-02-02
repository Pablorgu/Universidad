.include  "inter.inc"
.text
  mrs r0, cpsr
  mov r0, #0b11010011 @Modo SVC, FIQ&IRQ desact
  msr spsr_cxsf, r0
  add r0, pc, #4
  msr ELR_hyp, r0
  eret

mov r0, #0							@ en la RP2 ya est� puesto el 0 por defecto
ADDEXC 0x18, irq_handler @manipulador de excepciones fiq

ldr r4 , =1000000@ un segundo

mov r0, #0b11010010 
msr cpsr_c, r0
mov sp, #0x8000 @modo  IRQ
mov r0, #0b11010011 
msr cpsr_c, r0
mov sp, #0x8000000 @modo supervisor SVC

/*  PONEMOS LOS LEDS COMO SALIDA */
        ldr     r0, =GPBASE
/* guia bits              xx999888777666555444333222111000*/
	ldr r1, 	 =0b00001000000000000000000000000000
        str     r1, [r0, #GPFSEL0]
/* guia bits           xx999888777666555444333222111000*/
        ldr r1,     =0b00000000001000000000000000001001
        str r1, [r0, #GPFSEL1]
/* guia bits          xx999888777666555444333222111000*/
        ldr r1,    =0b00000000001000000000000001000000
        str r1, [r0, #GPFSEL2]
		
/*  Primera iteración
        r5 = (Dirección) elemento previamente encendido
        r6 = (Dirección) Siguiente elemento a encender
        r7 = (Contador) Módulo de elementos encendidos hasta ahora.
            Posición de puntero
*/
    mov r5 , #0 @punteros
    ldr r6 , =vector
    mov r7 , #0
    
/*    Canal 1 a un segundo y habilitar instrucciones  */
	 ldr r0, = STBASE
ldr r1, [r0, #STCLO]
add r1, r1, r4
str     r1, [r0, #STC1]
ldr     r0, =INTBASE
        mov     r1, #0b0010
        str     r1, [r0, #INTENIRQ1]
        mov     r0, #0b01010011   @ Modo SVC, IRQ activo
        msr     cpsr_c, r0
	


infi:           b infi


/* Tratamiento de interrupcion */
irq_handler:


ldr r0, = GPBASE
ldr r1, [r6] @valor de la posici�n del array
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


@ temporizador
	
	ldr r0, =STBASE
mov r1, #0b0010
str r1, [r0, #STCS]
	/*		Reiniciar el timer		*/
        ldr     r1, [r0, #STCLO]
       add    r1, r1, r4
        str     r1, [r0, #STC1]
        pop {r0, r1}
	subs pc, lr, #4







vector:   .word 0b00000000000000000000001000000000 , 0b00000000000000000000010000000000 , 0b00000000000000000000100000000000 , 0b00000000000000100000000000000000 , 0b00000000010000000000000000000000 , 0b00001000000000000000000000000000				
longitud: .word 6

