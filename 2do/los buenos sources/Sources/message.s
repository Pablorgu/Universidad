.include "inter.inc"
.data
    vector: .word 1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1, 2, 4, 6, 1, 3, 5
.text 
    ADDEXC 0x18, irq_handler
    mov r0, #0b11010010
    msr cpsr_c, r0
    mov sp, #0x8000
    mrs r0, cpsr
    mov r0, #0b11010011 @Modo SVC, FIQ&IRQ desact
    msr spsr_cxsf, r0
    add r0, pc, #4
    msr ELR_hyp, r0
    eret
    mov r0, #0
    mov   r0, #0b11010011
    msr   cpsr_c, r0
    mov   sp, #0x08000000     @inicializar la pila
    /*        Configurar el GPIO como salida        */
    ldr r0, =GPBASE
/* guia bits           xx999888777666555444333222111000        */
        ldr     r1, =0b00001000000000000000000000000000
        str     r1, [r0, #GPFSEL0]
/* guia bits        xx999888777666555444333222111000        */
        ldr r1,  =0b00000000001000000000000000001001
        str r1, [r0, #GPFSEL1]
/* guia bits        xx999888777666555444333222111000        */
        ldr r1,  =0b00000000001000000000000001000000
        str r1, [r0, #GPFSEL2]
    ldr r2, =vector
    ldr r3, [r2]
    mov r6, #0

bucle:
	bl espera
	cmp r6, #18
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
	
	bl espera
	str r1, [r0, #GPCLR0]
	b bucle

espera: 
        push {r0, r1, r4, r5}
	ldr r0, =STBASE
	ldr r1, =200000
        ldr r4, [r0, #STCLO]
        add r4, r1
retencion: 
            ldr r5, [r0, #STCLO]
            cmp r5, r4
            blo retencion        
pop {r0, r1, r4, r5}
bx lr
