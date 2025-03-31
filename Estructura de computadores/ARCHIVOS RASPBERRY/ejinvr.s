.include  "inter.inc"
.data
vector: .word 1,3,6,1,2,3,4,5,6,6,5,4,3,2,1
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
	/*		Encender y apagar GPIOs 		*/
     push    {r0, r1}            @ Salvo registros
        ldr     r0, =GPBASE      
	
	cmp r6, #15
	moveq r6, #0
	ldreq r2, =vector
	ldr r3, [r2]
	
       cmp r3, #1
    /* guia bits          10987654321098765432109876543210        */
        ldreq     r1, =0b00000000000000000000001000000000
        streq     r1, [r0, #GPSET0]
    
    cmp r3, #2
    /* guia bits   10987654321098765432109876543210        */
        ldreq     r1, =0b00000000000000000000010000000000
        streq     r1, [r0, #GPSET0]
    
    cmp r3, #3
    /* guia bits   10987654321098765432109876543210        */
        ldreq     r1, =0b00000000000000000000100000000000
        streq     r1, [r0, #GPSET0]

    cmp r3, #4
    /* guia bits   10987654321098765432109876543210        */
        ldreq     r1, =0b00000000000000100000000000000000
        streq     r1, [r0, #GPSET0]
    
    cmp r3, #5
    /* guia bits   10987654321098765432109876543210        */
        ldreq     r1, =0b00000000010000000000000000000000
        streq     r1, [r0, #GPSET0]
    
    cmp r3, #6
    /* guia bits   10987654321098765432109876543210        */
        ldreq     r1, =0b00001000000000000000000000000000
        streq     r1, [r0, #GPSET0]
	
	ldr r3, [r2, #4]!
	add r6, #1
	
        
      str r1, [r0, #GPCLR0]
	
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

	