#include <stdio.h>
int main(){
	float r;
	float PI=3.14;
	printf("Enter the radius: ");scanf("%f",&r);
	float S=PI*r*r;
	printf("The area of circle:%.2f \n",S);
	return 0;
}
