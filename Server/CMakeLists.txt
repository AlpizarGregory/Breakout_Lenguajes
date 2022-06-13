cmake_minimum_required(VERSION 3.22)
project(Server C)

set(CMAKE_C_STANDARD 99)

add_executable(Server main.c jsonManager/jsonParser.c jsonManager/jsonParser.h)
