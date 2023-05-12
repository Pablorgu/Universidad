.include "inter.inc"
 
.text	
  mrs r0, cpsr
  mov r0, #0b11010011 @Modo SVC, FIQ&IRQ desact
  msr spsr_cxsf, r0
  add r0, pc, #4
  msr ELR_hyp, r0
  eret
        
mov r0, #0
ADDEXC 0x18, irq_handler @manipulador de excepciones fiq

mov r0, #0b11010010 
msr cpsr_c, r0
mov sp, #0x8000 @modo  IRQ
mov r0, #0b11010011 
msr cpsr_c, r0
mov sp, #0x8000000 @modo supervisor SVC

ldr r0, =GPBASE
mov r1, #0b00001000000000000000000000000000
str r1, [r0, #GPFSEL0] @GPIO9 como salida

ldr r0, = STBASE
ldr r1, [r0, #STCLO]
add r1, #0x400000
str     r1, [r0, #STC1] @ponemos en el canal 1 del timer 

/* Habilito interrupciones */
        ldr     r0, =INTBASE
        mov     r1, #0b0010
        str     r1, [r0, #INTENIRQ1]
        mov     r0, #0b01010011   @ Modo SVC, IRQ activo
        msr     cpsr_c, r0
/* --------- */

infi:        b infi

irq_handler:
	push{r0,r1}
ldr     r0, =GPBASE
ldr     r1, =0b00000000000000000000001000000000
        str     r1, [r0, #GPSET0] @ Enciendo LED
        pop     {r0, r1}          @ Recupero registros
		subs    pc, lr, #4 