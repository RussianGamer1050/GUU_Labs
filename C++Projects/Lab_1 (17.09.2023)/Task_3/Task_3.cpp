#include <iostream>

int main() 
{
	setlocale(LC_ALL, "Rus");

	int m = 6 % 3;
	
	switch (m = 0) 
	{
	case 2: m++; break;
	case 1: m++; break;
	case 3: m++;
	}
	
	std::cout << "m = " << m << std::endl;
	std::cout << "Размер m равен "<< sizeof(m)
		<< " байтам (тип int)" << std::endl;

	return 0;
}
