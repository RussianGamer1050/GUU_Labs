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
	std::cout << "������ m ����� "<< sizeof(m)
		<< " ������ (��� int)" << std::endl;

	return 0;
}
