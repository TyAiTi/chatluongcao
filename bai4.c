#include <stdio.h>
int main(){
	int  a,b;
	printf("Enter a & b: ");scanf("%d %d",&a,&b);
	int divided=a%b;
	printf("The remainder of a divided by b is:%d\n ",divided);
	return 0;
}
