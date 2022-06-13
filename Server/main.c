#include <stdio.h>
#include <json-c/json.h>

void readJson() {
    FILE  *fp;
    char buffer[2048];

    struct json_object *parsedJson;
    struct json_object *blocks;
    struct json_object *parsedBlocks;

    struct json_object *friend;
    struct json_object *block;

    size_t n_friends;
    size_t i;

    fp = fopen("data//blocks.json", "r");
    fread(buffer, 1024, 1, fp);
    fclose(fp);

    printf("%s", buffer);

//    parsedJson = json_tokener_parse(buffer);
//    parsedBlocks = json_tokener_parse(json_object_get_string(parsedJson));
//
//    json_object_object_get_ex(parsedBlocks, "blocks", &blocks);
//
//    n_friends = json_object_array_length(blocks);
//
//
//    struct json_object *number;
//    json_object_set_int((struct json_object *) &number, 5);
//
//    for (i = 0; i < n_friends; i++) {
//        block = json_object_array_get_idx(blocks,i);
//        json_object_object_get_ex(block, "color", &friend);
//        printf("%s\n", json_object_get_string(friend));
//    }
}

void setJson() {
    struct json_object *root = json_object_from_file("data//blocks.json");
    printf("%s\n", json_object_get_string(root));
    struct json_object *blocks = json_object_object_get(root, "blocks");
    struct json_object *block = json_object_array_get_idx(blocks, 0);
    struct json_object *points = json_object_object_get(block, "resistance");
//    json_object_set_int(points, 35);
//    json_object_to_file("data//blocks.json", root);
}

int main(int argc, char **argv) {
//    readJson();
    setJson();
}


// Comando para ejecutar programa desde consola
// gcc main.c -ljson-c -o main
// ./main


