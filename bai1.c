#include <stdio.h>
int main(){
	int a,b;
	printf("Please enter width: ");scanf("%d",&a);
	printf("Please enter height: ");scanf("%d",&b);
	int r=(a+b)*2;
	printf("Perimeter of rectangle is %d :\n ",r);
	return 0;
}
