cmake_minimum_required(VERSION 4.0)
project(codaBuzz C)

set(CMAKE_C_STANDARD 11)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)

include_directories(.)

# main program
add_executable(codaBuzz
        codaBuzz.c
        codaBuzz.h
        main.c)

# unit tests
add_executable(coda_tests
        test_codaBuzz.c
        codaBuzz.c
        codaBuzz.h
)