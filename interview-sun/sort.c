#include <stdio.h>

#define SIZE 20

typedef struct elem *elem_p;

struct elem {
   int mark;
   elem_p next;
};

elem_p reverse(elem_p head) {
   
   elem_p new, old, tmp;

   new = head;
   old = head->next;

   head->next = NULL;

   while(old != NULL) {
      
      tmp = new;
      new = old;
      old = old->next;

      new->next = tmp;

   };
      
   return new;

}

void print(elem_p head) {

   while(head != NULL){
      printf("%d ", head->mark);
      head = head->next;
   }
   printf("\n");
}

void init(struct elem array[]) {
   
   int i;

   for(i=0; i<SIZE-1; i++) {
      array[i].next = &(array[i+1]);
      array[i].mark = i;
   }
   
   array[SIZE-1].next = NULL;
   array[SIZE-1].mark = SIZE-1;

}

int main(int argc, char * argv[]) {
   
   //printf( "%s, %s, %s, %s\n", argv[0], argv[1], argv[2], argv[3] );
   
   struct elem array[SIZE];
   elem_p head;

   init(array);
   
   head = &(array[0]);

   print(head);

   head = reverse(head);

   print(head);

   return 0;

}
