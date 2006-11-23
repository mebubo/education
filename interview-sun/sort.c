#include <stdio.h>
#define SIZE 20

typedef struct elem *elem_p;

struct elem {
   int mark;
   elem_p next;
};

elem_p reverse(elem_p head) {
   
   /* Reverse a singly linked list and return a pointer to its new
    * head.
    */

   elem_p new, old, tmp;

   new = head;
   old = head->next;

   head->next = NULL;

   while(old != NULL) {

      tmp = new;
      new = old;
      /* "old" moves along the old list */
      old = old->next;
      /* The reversion itself takes place here */
      new->next = tmp;
   };
   return new;
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

void init(struct elem array[]) {
   
   /* Initialize an array of struct elem structures so that it forms a
    * singly linked list (the order of the list is the same as that of
    * the array for simplicity)
    */

   int i;

   for(i=0; i<SIZE-1; i++) {
      array->next = array+1;
      array->mark = i;
      array++;
   }
   array->next = NULL;
   array->mark = SIZE-1;
}

int main(int argc, char * argv[]) {
   
   struct elem array[SIZE];
   elem_p head;

   /* Initialise a list */
   init(array);
   
   /* Obtain a pointer to the head of the list */
   head = (elem_p) array;
   /* Print the list */
   print(head);
   /* Reverse */
   head = reverse(head);
   /* See if it was successfull */
   print(head);

   return 0;
}
