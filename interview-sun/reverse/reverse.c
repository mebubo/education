/* The essential pert here is the reverse() function. Everything else
 * merely demonstrates that reverse() actually works. 
 */

#include <stdio.h>
#define MAXSIZE 100
#define SIZES 1, 2, 10

typedef struct elem *elem_p;

struct elem {
   int mark;
   elem_p next;
};

elem_p reverse(elem_p head) {
   
   /* Reverse a singly linked list and return a pointer to its new
    * head.
    */

   elem_p old, tmp;

   old = head->next;
   /* The old head should become a tail */
   head->next = NULL;

   while(old != NULL) {

      tmp = head;
      head = old;
      /* "old" moves along the old, to-be-reversed part of the list */
      old = old->next;
      /* The reversion itself takes place here */
      head->next = tmp;
   };
   return head;
}

void print(elem_p head) {

   /* Given a pointer to a head of singly linked list, print its
    * elements in order.
    */

   while(head != NULL){
      printf("%d ", head->mark);
      head = head->next;
   }
   printf("\n");
}

void init(struct elem array[], int size) {
   
   /* Initialize an array of struct elem structures so that it forms a
    * singly linked list (the order of the list is the same as that of
    * the array for simplicity)
    */

   int i;

   for(i=0; i<size-1; i++) {
      array->next = array+1;
      array->mark = i;
      array++;
   }
   array->next = NULL;
   array->mark = size-1;
}

int main(int argc, char *argv[]) {
   
   struct elem array[MAXSIZE];
   elem_p head;
   int i;
   int size[] = {SIZES};

   /* Create and reverse lists of sizes defined in size[] array */
   for(i=0; i<sizeof(size)/sizeof(int); i++) {

      /* Initialise a list */
      init(array, size[i]);
      
      /* Obtain a pointer to the head of the list */
      head = (elem_p) array;
      /* Print the list */
      printf("Original list of size %d:\n", size[i]);
      print(head);
      /* Reverse */
      head = reverse(head);
      /* See if it was successfull */
      printf("Reversed list:\n");
      print(head);
      printf("\n");
   }

   return 0;
}
