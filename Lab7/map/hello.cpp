/**
 *
 * @author Diarmuid Brennan
 * 04/12/2021
 * Demonstrate omp
 */
#include <omp.h>
#include <stdio.h>
int main(int argc, char *argv[]){
  /* sequential code */
    printf("before\n");
#pragma omp parallel
{
  printf("I am a parallel region.\n");
}
/* sequential code */
 printf("after\n");
return 0;
}
