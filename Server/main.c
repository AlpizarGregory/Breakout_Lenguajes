#include <stdio.h>
#include <json-c/json.h>

int main(int argc, char **argv) {
    FILE  *fp;
    char buffer[1024];

    struct json_object *parsedJson;
//    struct json_object *name;
//    struct json_object *age;
    struct json_object *blocks;
    struct json_object *parsedBlocks;

    struct json_object *friend;
//    struct json_object *blocks;
    struct json_object *block;
    size_t totalBlocks;

    size_t n_friends;
    size_t i;

    fp = fopen("data//test.json", "r");
    fread(buffer, 1024, 1, fp);
    fclose(fp);

    parsedJson = json_tokener_parse(buffer);
    parsedBlocks = json_tokener_parse(json_object_get_string(parsedJson));

//    json_object_object_get_ex(parsedJson,"blocks", &blocks);
//    totalBlocks= json_object_array_length(blocks);

//    printf("%lu\n", totalBlocks);

//    for (i = 0; i < totalBlocks; i++) {
//        block = json_object_array_get_idx(blocks,i);
//        printf("%lu. &s\n", i+1, json_object_get_string(json_object_array_get_idx(blocks, i)));
//    }

//    json_object_object_get_ex(parsedJson, "name", &name);
//    json_object_object_get_ex(parsedJson, "age", &age);
    json_object_object_get_ex(parsedBlocks, "blocks", &blocks);
//
//    printf("Name: %s\n", json_object_get_string(name));
//    printf("Age: %d\n", json_object_get_int(age));

    n_friends = json_object_array_length(blocks);
//    printf("Found %lu friends\n", n_friends);

    for (i = 0; i < n_friends; i++) {
//        json_object_object_get_ex(blocks, "name", &friend);
        block = json_object_array_get_idx(blocks,i);
        json_object_object_get_ex(block, "age", &friend);
        printf("%s\n", json_object_get_string(friend));
    }
}


//{
//"blocks": ["name", "age", "Lastname"]
//}