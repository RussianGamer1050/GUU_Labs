#include <iostream>

int main()
{
	setlocale(LC_ALL, "Rus");

	int A, k = 1;
	A = 9;

	if (A % 3) k = k + A / 5;
	else k = k + A / 2;

	std::cout << "k = " << k << std::endl;
	std::cout << "������ k ����� " << sizeof(k)
		<< " ������ (��� int)" << std::endl;

	return 0;
}
