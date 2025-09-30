#ifndef CODA_H
#define CODA_H

typedef void (*ResultHandler)(const char *);

const char *convert(int input);

const char *convert_with_handler(int input, ResultHandler);

const char *convert_without_if(int input);

#endif
