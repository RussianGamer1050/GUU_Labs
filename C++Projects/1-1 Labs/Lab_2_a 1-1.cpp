#include <iostream>

/*
��������� � �������� ���������
� ���������� ������ g, h, i
���� i < g*3 ��� h != 0, i *= 3 g += 1
����� "���������� g � i �� �������"
������� g, i
*/

int main() {

	setlocale(LC_ALL, "Rus");

	// ���������� ����������
	int g, h, i;

	// ���� �������� ��� ����������
	std::cout << "������� ��������������� 3 �����:" << std::endl;
	std::cout << "g = "; std::cin >> g;
	std::cout << "h = "; std::cin >> h;
	std::cout << "i = "; std::cin >> i;

	// �������� �������
	if (i < g * 3 || h != 0) { i *= 3; g += 1; }
	else std::cout << "���������� g � i �� �������" << std::endl;

	// ����� �������� ����������
	std::cout << "g = " << g << ", i = " << i << std::endl;

	return 0;
}
