#include "stdio.h"
#include "stdlib.h"

void reverse(char* str) {
    if (!str) {
        return;
    }
    int length = 0;
    while (str[length] != '\0') {
        length++;
    }
    for (int i=0; i < length/2; i++) {
        int j = length - i - 1;
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}

void reverse2(char* str) {
    char tmp;
    char* end = str;
    if (str) {
        while(*end) {
            end++;
        }
        end--;
        while (str < end) {
            tmp = *end;
            *(end--) = *str;
            *(str++) = tmp;
        }
    }
}

int main(int argc, char** argv) {
    if (argc != 2) {
        printf("Usage: %s <string>\n", argv[0]);
        exit(1);
    }
    char* str = argv[1];
    reverse(str);
    printf("Reversed: %s\n", str);
}

