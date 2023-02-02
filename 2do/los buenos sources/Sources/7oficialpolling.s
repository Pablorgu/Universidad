     .include "inter.inc"
 
.text
  mrs r0, cpsr
  mov r0, #0b11010011 @Modo SVC, FIQ&IRQ desact
  msr spsr_cxsf, r0
  add r0, pc, #4
  msr ELR_hyp, r0
  eret
        mov r0, #0b11010011
        msr cpsr_c, r0
        mov sp, #0x08000000 @Habilitamos modo supervisor
        ldr     r4, =GPBASE
        mov       r1,#0b00000000000000000001000000000000
        str    r1, [r4, #GPFSEL0]  @ Configura GPIO 4
        mov   r5, #0b00000000000000000000000000010000
        str r5, [r4, #GPSET0]

bucle:
            mov r2,  #0b00000000000000000000000000000100
            ldr r3, [r4, #GPLEV0]
            tst r3, r2
            beq     pulsador1
            mov r2,  #0b00000000000000000000000000001000
            ldr r3, [r4, #GPLEV0]
            tst r3, r2
            beq pulsador2
            b bucle

pulsador1:
            ldr r0, = STBASE
            ldr r1, = 1908
            bl espera
            str r5, [r4, #GPCLR0]
            bl espera
            str r5, [r4, #GPSET0]
            b bucle

pulsador2:
            ldr r0, = STBASE
            ldr r1, = 1278
            bl espera
            str r5, [r4, #GPCLR0]
            bl espera
            str r5, [r4, #GPSET0]
            b bucle


espera:     push {r4, r5}
             ldr r4,  [r0, #STCLO]
             add r4, r1
ret1:         ldr r5, [r0, #STCLO]
             cmp r5, r4
             blo ret1
             pop {r4, r5}
             bx lr

