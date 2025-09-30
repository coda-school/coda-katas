#ifndef CODA_H
#define CODA_H

const char *convert(int input);

typedef void (*ResultHandler)(const char *);

const char *convert_with_handler(int input, ResultHandler);

#endif
