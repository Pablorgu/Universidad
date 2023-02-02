.include  "inter.inc"
.text
  mrs r0, cpsr
  mov r0, #0b11010011 @Modo SVC, FIQ&IRQ desact
  msr spsr_cxsf, r0
  add r0, pc, #4
  msr ELR_hyp, r0
  eret
mov r0, #0							@ en la RP2 ya está puesto el 0 por defecto
ADDEXC 0x18, irq_handler @manipulador de excepciones fiq

mov r0, #0b11010010 
msr cpsr_c, r0
mov sp, #0x8000 @modo  IRQ
mov r0, #0b11010011 
msr cpsr_c, r0
mov sp, #0x8000000 @modo supervisor SVC

/*  PONEMOS LAS LEDS COMO SALIDA */
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
        mov r2, #0              @r2 a 0 significa que no está encendida

/* Preparamos canal 1 para interrupciones de 500 ms */
       ldr r0, = STBASE
ldr r1, [r0, #STCLO]
ldr r3, = 500000
add r1, r3
str     r1, [r0, #STC1] @ponemos en el canal 1 del timer que se interrumpa a los 500 miliseg

/* Habilito interrupciones */
        ldr     r0, =INTBASE
        mov     r1, #0b0010
        str     r1, [r0, #INTENIRQ1]
        mov     r0, #0b01010011   @ Modo SVC, IRQ activo
        msr     cpsr_c, r0
/* --------- */

infi: b infi

/* Tratamiento de interrupcion */
irq_handler:
        push    {r0, r1}            @ Salvo registros
	
	/*		Encender y apagar GPIOs 		*/
     push    {r0, r1}            @ Salvo registros
        ldr     r0, =GPBASE       
        /* guia bits   10987654321098765432109876543210*/
        ldr     r1, =0b00001000010000100000111000000000
	
        cmp r5, #0
        streq  r1, [r0, #GPSET0] 
        moveq r5, #1
        strne r1, [r0, #GPCLR0]
        movne r5, #0
	
	/*		Limpiar evento de interrupción		*/
ldr r0, =STBASE
mov r1, #0b0010
str r1, [r0, #STCS]
	/*		Reiniciar el timer		*/
        ldr     r1, [r0, #STCLO]
        add     r1, r3    @500 milisegundos
        str     r1, [r0, #STC1]
        pop {r0, r1}
	subs pc, lr, #4
