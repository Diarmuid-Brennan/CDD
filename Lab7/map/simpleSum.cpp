//Diarmuid Brennan
//07/12/2021

// Code:
#include <iostream>
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
#include <limits>

int main(void){
  const unsigned long SIZE=1000000;
  float numberArray[SIZE];
  float sum=0.0;
  /* initialize random seed: */
  srand (time(NULL));
  for(unsigned long long int i=0;i<SIZE;++i){
    /* generate secret number between 1 and 1000: */
    numberArray[i] = rand() % 1000 + 1;
  }
  clock_t begin = clock();
 #pragma omp parallel for reduction (+:sum)
  for (unsigned long i=0; i < SIZE; ++i){
      sum=sum+numberArray[i];
  }//for
  clock_t end = clock();
  double timeSec = (end - begin) / static_cast<double>( CLOCKS_PER_SEC );
  std::cout << timeSec << std::endl;
  std::cout << sum << std::endl;
}//main

//
/// simpleSum.cpp ends here
