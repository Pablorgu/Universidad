       .include "inter.inc"
.text
  mrs r0, cpsr
  mov r0, #0b11010011 @Modo SVC, FIQ&IRQ desact
  msr spsr_cxsf, r0
  add r0, pc, #4
  msr ELR_hyp, r0
  eret
	mov 	r0, #0b11010011
	msr	cpsr_c, r0
	mov 	sp, #0x8000000	@ Inicializ. pila en modo SVC
	
        ldr     r4, =GPBASE
/* guia bits                  xx999888777666555444333222111000*/
        mov   	r5, #0b00000000000000000001000000000000
        str	r5, [r4, #GPFSEL0]  @ Configura GPIO 4
/* guia bits          10987654321098765432109876543210*/
        mov	r5, #0b00000000000000000000000000011100
        ldr	r0, =STBASE	@ r0 es un parametro de sonido (dir base ST)

bucle:	bl     	sonido		@ Salta a rutina de sonido
	ldr	r1, [r4, #GPLEV0]
	tst	r2, r1, #0b00000000000000000000000000000100
	beq	pulsador1
	tst	r2, r1, #0b00000000000000000000000000001000
	beq	pulsador2
	b 	bucle
	
pulsador1:	
	ldr	r1, =1908	@ r1 es un parametro de sonido (periodo/2)
	bl     	sonido 		@ Salta a rutina de sonido
	str    	r5, [r4, #GPSET0]
	bl     	sonido 		@ Salta a rutina de sonido
        str     r5, [r4, #GPCLR0]
	b bucle
pulsador2:
	ldr	r1, =1278	@ r1 es un parametro de sonido (periodo/2)
	bl     	sonido 		@ Salta a rutina de sonido
	str    	r5, [r4, #GPSET0]
        bl     	sonido 		@ Salta a rutina de sonido
        str     r5, [r4, #GPCLR0]
	b bucle
/* rutina que espera r1 microsegundos */
sonido: 
	push	{r4,r5}
        ldr     r4, [r0, #STCLO]  @ Lee contador en r4
        add    	r4, r1    	  @ r4= r4 + perido/2
ret1: 	ldr     r5, [r0, #STCLO]
        cmp	r5, r4            @ Leemos CLO hasta alcanzar
        blo     ret1              @ el valor de r4
	pop	{r4,r5}
        bx      lr