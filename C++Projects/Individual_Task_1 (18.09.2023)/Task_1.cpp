#include <iostream>


using namespace std;

int main()
{
	/* 
	   �����: �������� ����������, 
	   ����� �� ����� � ������� ������ �����
	   ����������: ��� ������ ���������� 
	   ������� ����� �� ����� � ��� ������
	   � ����������� ������� �� �����
	*/

	setlocale(LC_ALL, "Rus");

	int n; // n - ���������� ���������
	float p_3, p_2, p_1, p_lux, min;
	string name, typ; // �������� ����������

	cout << "������� ���������� ���������: ";
	cin >> n; cout << endl;

	while (n)
	{
		cout << "�������:" << endl;
		cout << "1) �������� ����������: ";
		cin >> name;
		cout << "2) ����� �� ����� � �������. ������ - ";
		cin >> p_3;
		cout << "3) ����� �� ����� � ��������. ������ - ";
		cin >> p_2;
		cout << "4) ����� �� ����� � ��������. ������ - ";
		cin >> p_1;
		cout << "5) ����� �� ����� � \"����\" ������ - ";
		cin >> p_lux;

		// ���������� ����������� �����
		min = p_lux; typ = "\"����\"";
		if (p_1 <= min) { typ = "��������."; min = p_1; }
		if (p_2 <= min) { typ = "��������."; min = p_2; }
		if (p_3 <= min) { typ = "�������."; min = p_3; }

		cout << "\n� ���������� \"" << name << "\":\n"
			<< "������� ����� �� ����� �����: " 
			<< (p_3 + p_2 + p_1 + p_lux) / 4
			<< "\n����������� ����� - " << min << " �� " 
			<< typ << " �����\n\n" << endl;
		n--;
	}

	return 0;
}
