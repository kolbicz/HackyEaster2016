bits 64

section .data use64

key: db "012345678912345678",0

section .code use64

global main

main:

	xor rbx, rbx
makekey:
	RDRAND rdx
	shr rdx, 32
	mov  eax, edx
    xor  edx, edx
    mov  ecx, 256
    div  ecx
    mov byte [key+ebx], dl
    inc ebx
    cmp ebx, 18 ;len
    jnz makekey
    mov rdx, 18
    mov rsp, key
    mov rbx, rsp
    
do_again:

	movsx   r8d, BYTE [rsp]
    lea     r10, [rbx+1]
    xor     edi, edi
    xor     esi, esi
    xor     ecx, ecx
    xor     ebx, ebx
    mov     r11d, 1431655766
    mov     r9d, r8d
    jmp     start
do_loop:
    movsx   r8d, BYTE [r10]
    lea     ebx, [rdx+r8]
    add     r9d, r8d
    test    dil, 1
    cmove   ebx, edx
    add     r10, 1
start:
    mov     eax, edi
    imul    r11d
    mov     eax, edi
    sar     eax, 31
    sub     edx, eax
    lea     eax, [rcx+r8]
    lea     edx, [rdx+rdx*2]
    cmp     edi, edx
    cmove   ecx, eax
    mov     eax, edi
    add     r8d, esi
    and     eax, 3
    cmp     eax, 2
    mov     eax, r9d
    cmove   esi, r8d
    sar     eax, 31
    add     edi, 1
    shr     eax, 24
    add     r9d, eax
    movzx   r9d, r9b
    sub     r9d, eax
    mov     eax, ebx
    sar     eax, 31
    shr     eax, 24
    lea     edx, [rbx+rax]
    movzx   edx, dl
    sub     edx, eax
    mov     eax, ecx
    sar     eax, 31
    shr     eax, 24
    add     ecx, eax
    movzx   ecx, cl
    sub     ecx, eax
    mov     eax, esi
    sar     eax, 31
    shr     eax, 24
    add     esi, eax
    movzx   esi, sil
    sub     esi, eax
    cmp     edi, 16
    jne     do_loop
    cmp     r9d, 133
    jne     main
    cmp     edx, 67
    jne     main
    cmp     ecx, 79
    jne     main
    cmp     esi, 176
    jne     main
	int 3
bad:                           
    xor     eax, eax
	ret
