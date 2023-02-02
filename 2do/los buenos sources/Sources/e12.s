.include "inter.inc"

.text
  mrs r0, cpsr
  mov r0, #0b11010011 @Modo SVC, FIQ&IRQ desact
  msr spsr_cxsf, r0
  add r0, pc, #4
  msr ELR_hyp, r0
  eret
	
mov r0, #0
ADDEXC 0x18, irq_handler
mov r0, #0b11010010 
msr cpsr_c, r0
mov sp, #0x8000 @modo  IRQ
mov r0, #0b11010011 
msr cpsr_c, r0
mov sp, #0x8000000 @modo supervisor SVC

/* SALIDAS GPIO9 Y GPIO10 */

ldr r0, = GPBASE
ldr r1, 	 =0b00001000000000000000000000000000
str r1, [r0, #GPFSEL0] @GPIO9 como salida
ldr r1, =  0b00001000000000000000000000000001
str r1, [r0, #GPFSEL1] @GPIO10 como salida

/* ENCENDER GPIO9 Y GPIO10 */

ldr    r1 , =0b00000000000000000000011000000000
str r1, [r0, #GPSET0]

/* ACTIVAR INTERRUPCIONES BOTONES GPIO2 Y GPIO3 Y  LUEGO HABILITARLAS  */

mov	r1,	#0b00000000000000000000000000001100
str	r1,	[r0,	#GPFEN0]	
ldr     r0, =INTBASE
mov     r1, #0b00000000000100000000000000000000
str     r1, [r0, #INTENIRQ2]	@ Allow interruptions from any GPIO pin
mov     r0, #0b01010011   @ Modo SVC, IRQ activo
msr     cpsr_c, r0

infi: b infi

/* Tratamiento de interrupcion */

irq_handler:

push  { r0,r1,r2 }
ldr r0, = GPBASE

@GPIO2:
	
ldr	r2,	[r0,	#GPEDS0]	
ands	r2,	#0b00000000000000000000000000000100 @ si no es igual, se ha pulsado GPIO2
ldrne r1, = led_izq
ldrne r1, [r1]
str r1, [r0, #GPSET0] @encendemos GPIO9
ldrne r1, = led_der
ldrne r1, [r1]
str r1, [r0, #GPCLR0] @apagamos GPIO10
movne   r1, #0b00000000000000000000000000000100	
strne   r1, [r0, #GPEDS0]	@ Clear GPIO2 event

@GPIO3:
ldr	r2,	[r0,	#GPEDS0]	
ands	r2,	#0b00000000000000000000000000001000 @ si no es igual, se ha pulsado GPIO3
ldrne r1, = led_izq
ldrne r1, [r1]
str r1, [r0, #GPCLR0] @apagamos GPIO9
ldrne r1, = led_der
ldrne r1, [r1]
str r1, [r0, #GPSET0] @encendemos GPIO10
movne   r1, #0b00000000000000000000000000001000	
strne   r1, [r0, #GPEDS0]	@ Clear GPIO3 event

pop     {r0, r1, r2}
subs    pc, lr, #4

led_izq:  .word 0b00000000000000000000001000000000
led_der: .word 0b00000000000000000000010000000000


