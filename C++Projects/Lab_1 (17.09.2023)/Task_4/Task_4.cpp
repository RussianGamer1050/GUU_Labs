#include <iostream>

int main()
{
	setlocale(LC_ALL, "Rus");

	long B, P, A = 2013;
	int C;

	B = 0;
	P = 1;

	while (A)
	{
		C = A % 10;
		A = A / 10;
		if (C % 2) B = B + C * P;
		P = P * 10;
	}
	
	std::cout << "B = " << B << std::endl;
	std::cout << "Размер B равен " << sizeof(B) 
		<< " байтам (тип long)" << std::endl;

	return 0;
}
