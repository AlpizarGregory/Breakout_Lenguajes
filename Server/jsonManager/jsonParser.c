#include <stdio.h>
#include <json-c/json.h>
#include <stdlib.h>
#include <time.h>

size_t charSize = 10240;

int getRandom(int upper) {

    int randomNumber = (rand() % (upper + 1));
    return randomNumber;
}

char *parseJson() {
    FILE *fileInfo;
    char *jsonString = malloc(charSize);

    fileInfo = fopen("data//blocks.json", "r");
    fread(jsonString, charSize, 1, fileInfo);
    fclose(fileInfo);

    return jsonString;
}

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

void newLevel() {
    struct json_object *root = json_object_from_file("data//blocks.json");
    struct json_object *blocks = json_object_object_get(root, "blocks");
    struct json_object *block, *points, *state;
    size_t i, j, counter;
    counter = 0;

    srand(time(0));

    for (i = 0; i < 4; i++) {
        int levelPoints = getRandom(15);
        for (j = 0; j < 20; j++) {
            int powerProbability = getRandom(99);
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

