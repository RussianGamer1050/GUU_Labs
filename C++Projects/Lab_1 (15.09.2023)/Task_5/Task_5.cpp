#include <iostream>
#include <math.h>

int main()
{
	setlocale(LC_ALL, "Rus");

	float x, y, r, A = 1;
	int c;

	std::cout << "������� X: ";
	std::cin >> x;
	std::cout << "������� Y: ";
	std::cin >> y;
	
	r = sqrt(x*x + y*y); // ��������� �� ������ ����� (������ ���� ������ ��� ������)
	c = (y >= -2*A); // ������ ������� ������������ (����� ������ ���� ����)

	// y = -fabs(x) + 2*A - �������� �������� ������� ������������
	c = c && (y <= -fabs(x) + 2*A) && (r >= A);

	if (c) std::cout << "����� � ������� \n";
	else std::cout << "����� ��� ������� \n";

	return 0;
}
