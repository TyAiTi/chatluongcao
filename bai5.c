#include <stdio.h>
int main(){
	int h,m,s;
	printf("Enter hour, minute, second: ");scanf("%d %d %d",&h,&m,&s);
	printf("%dh %dh %ds = ",h,m,s);
	int tong=h*3600 + m*60 + s;
	printf("%d*3600 + %d*60 + %d=%ds\n  ",h,m,s,tong);
	return 0;
}
