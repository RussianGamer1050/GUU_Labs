#include <iostream>

int main()
{
	setlocale(LC_ALL, "Rus"); // ���������� ����������� �������� �����

	int i = 12, j = 5;
	float x, y = 0;

	x = (float)(i / j);
	y = (float)(i % j);

	std::cout << "x = " << x << "; y = " << y << std::endl;
	std::cout << "������ x � y �������������� ����� " << sizeof(x)
		<< " � " << sizeof(y) << " ���� (��� float)" << std::endl;

	return 0;
}
