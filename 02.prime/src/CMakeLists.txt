cmake_minimum_required(VERSION 4.0)
project(src C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(src
        prime.c
        prime.h
        test.c)
