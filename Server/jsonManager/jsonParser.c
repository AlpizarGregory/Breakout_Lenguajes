//······················································································································
// Es necesario instalar librerias en consola para utilizar las funciones json de este archivo
//
// $ sudo apt install libjson-c-dev
//
// Tomado del tutorial: https://youtu.be/dQyXuFWylm4
//
// Comando para ejecutar programa desde consola:
//
// $ gcc fileName.c -ljson-c -o fileName
//
// $ ./fileName
//
// Nota: Es necesario estar en el directorio del archivo para ejecutarlo
//······················································································································

#include <stdio.h>
#include <json-c/json.h>
#include <stdlib.h>
#include <time.h>

size_t charSize = 10240; // Tamaño del char que el server envía al cliente (texto de blocks.json)

// Descripción: Genera un número aleatorio dentro del rango solicitado
// Parámetros: El valor mínimo y el valor máximo que puede tener el número aleatorio
// Salida: Un entero aleatorio
int getRandom(int lower, int upper) {
    int randomNumber = (rand() % (upper - lower + 1)) + lower;
    return randomNumber;
}

// Descripción: Parser del archivo blocks.json
// Salida: El char con toda la info del archivo json parseado
char *parseJson() {
    FILE *fileInfo;
    char *jsonString = malloc(charSize);

    fileInfo = fopen("data//blocks.json", "r");
    fread(jsonString, charSize, 1, fileInfo);
    fclose(fileInfo);

    return jsonString;
}

// Descripción: Reestablece los datos del archivo blocks.json
// Coloca el puntaje de los 80 bloques en 0, y todos los estados (poderes) en "null"
void resetJson() {
    struct json_object *root = json_object_from_file("data//blocks.json");
    struct json_object *blocks = json_object_object_get(root, "blocks");
    struct json_object *block, *points, *state;
    size_t i;

    for (i = 0; i < 80; i++) {
        block = json_object_array_get_idx(blocks, i);
        points = json_object_object_get(block, "points");
        state = json_object_object_get(block, "state");
        json_object_set_int(points, 0);
        json_object_set_string(state, "null");
        json_object_to_file("data//blocks.json", root);
    }
}

// Descripción: Asigna valores de puntuación y poderes a cada uno de los bloques cuando se inicia una nueva partida
void newGame() {
    struct json_object *root = json_object_from_file("data//blocks.json");
    struct json_object *blocks = json_object_object_get(root, "blocks");
    struct json_object *block, *points, *state;
    size_t i, j, counter;
    counter = 0;

    srand(time(0)); // Con esto se obtienen enteros aleatorios distintos en cada ejecución del juego

    for (i = 0; i < 4; i++) { // División por niveles
        int levelPoints = getRandom(10, 25);
        for (j = 0; j < 20; j++) { // Asignaciones para los bloques de un solo nivel (20 en total)
            int powerProbability = getRandom(0, 99);
            block = json_object_array_get_idx(blocks, counter);
            points = json_object_object_get(block, "points");
            state = json_object_object_get(block, "state");
            json_object_set_int(points, levelPoints);

            if (powerProbability < 7) {
                json_object_set_string(state, "moreSpeed");
            } else if (powerProbability < 14) {
                json_object_set_string(state, "lessSpeed");
            } else if (powerProbability < 21) {
                json_object_set_string(state, "doubleSize");
            } else if (powerProbability < 28) {
                json_object_set_string(state, "halfSize");
            } else if (powerProbability < 35) {
                json_object_set_string(state, "addBall");
            } else if (powerProbability < 42) {
                json_object_set_string(state, "addLive");
            } else {
                json_object_set_string(state, "null");
            }

            counter++;
        }
    }

    json_object_to_file("data//blocks.json", root);

}