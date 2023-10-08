#include <iostream>

/*
������ ��� ����� �����
��� ������ switch:
1) ������� ����������
2) ������� ��� �������
3) ��������� ������� ��������������
����� - ������� ������ �����
*/

int main() {

	setlocale(LC_ALL, "Rus");

	// ���������� ����������
	int a, b, c, to_do, t;

	// ���� �������� ��� ����������
	std::cout << "������� ��������������� 3 �����:" << std::endl;
	std::cout << "a = "; std::cin >> a;
	std::cout << "b = "; std::cin >> b;
	std::cout << "c = "; std::cin >> c;

	// ����� ��������� � ���� ��������
	std::cout << "��� �� ������ �������?" << std::endl;
	std::cout << "1) ������� ���������� �����" << std::endl;
	std::cout << "2) ������� ��� ������� �����" << std::endl;
	std::cout << "3) ��������� ������� �������������� �������� �����" << std::endl;
	std::cin >> to_do;

	// ���� switch
	switch (to_do) {
	case 1: 
		if (a > c) a = c; 
		if (a > b) a = b; 
		std::cout << "���������� �������� - " << a << std::endl; break;
	case 2: 
		if (a > c) { t = c; c = a; a = t; }
		if (a > b) { t = b; b = a; a = t; }
		if (b > c) { b = c; }
		std::cout << "��� ������� ����� - " << a << " � " << b << std::endl; break;
	case 3: 
		std::cout << "������� �������������� - " << (a + b + c) / 3 << std::endl; break;
	default: std::cout << "������ ������" << std::endl;
	}

	return 0;
}
