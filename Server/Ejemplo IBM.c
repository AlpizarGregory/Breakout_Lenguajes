//
// Created by rachel10 on 09/06/22.
//
#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netinet/tcp.h>
#include <unistd.h>
#include <sys/time.h>
#include <string.h>

void main(int argc, char* argv[])
{
    int    portNum = 15482;
    int    server;
    int    client;
    int    address_len;
    int    sendrc;
    int    bndrc;
    char*  greeting;
    struct sockaddr_in  local_Address;
    address_len = sizeof(local_Address);

    memset(&local_Address,0x00,sizeof(local_Address));
    local_Address.sin_family = AF_INET;
    local_Address.sin_port = htons(portNum);
    local_Address.sin_addr.s_addr = htonl(INADDR_ANY);

#pragma convert (819)
    greeting = "Hola amigos de java";
#pragma convert (0)

    /*  Asignar el socket.  */
    if((server = socket(AF_INET, SOCK_STREAM, 0))<0)
    {
        printf("anomalía en la asignación de socket\n");
        perror(NULL);
        exit(-1);
    }

    /* Realizar el enlace (bind). */
    if((bndrc=bind(server,(struct sockaddr*)&local_Address, address_len))<0)
    {
        printf("Enlace fallido\n");
        perror(NULL);
        exit(-1);
    }

    /* Invocar el método listen. */
    listen(server, 1);

    /* Esperar la petición del cliente. */
    if((client = accept(server,(struct sockaddr*)NULL, 0))<0)
    {
        printf("aceptar ha fallado\n");
        perror(NULL);
        exit(-1);
    }

    /* Envía un saludo (greeting) al cliente. */
    if((sendrc = send(client, greeting, strlen(greeting),0))<0)
    {
        printf("Envío fallido\n");
        perror(NULL);
        exit(-1);
    }
/* Envía un saludo (greeting) al cliente. */
    if((sendrc = send(client, greeting, strlen(greeting),0))<0)
    {
        printf("Envío fallido\n");
        perror(NULL);
        exit(-1);
    }
    close(client);
    close(server);
}