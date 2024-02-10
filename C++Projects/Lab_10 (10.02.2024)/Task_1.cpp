#include <iostream>

using namespace std;


void vvod(int** a, int m);

void vivod(int** a, int m);

void memory(int** a, int m);

void simm(int** a, int m);


int main() {
	setlocale(LC_ALL, "Rus");

	int m_m1 = 8, m_m2 = 9; // ������� ������

	// �������� ���� ��������
	int** m1 = new int* [m_m1];
	for (int i = 0; i < m_m1; i++)
		m1[i] = new int[m_m1];

	int** m2 = new int* [m_m2];
	for (int i = 0; i < m_m2; i++)
		m2[i] = new int[m_m2];

	// ������ � ������ ��������
	vvod(m1, m_m1);
	vivod(m1, m_m1);
	simm(m1, m_m1);
	memory(m1, m_m1);
	cout << endl << endl;

	// ������ �� ������ ��������
	vvod(m2, m_m2);
	vivod(m2, m_m2);
	simm(m2, m_m2);
	memory(m2, m_m2);

	return 0;
}


// ���� ����� � ������
void vvod(int** a, int m) {
	cout << "������� �������� �������: " << endl;
	for (int i = 0; i < m; i++)
		for (int j = 0; j < m; j++)
			cin >> a[i][j];
	cout << endl;
}


// ����� �������
void vivod(int** a, int m) {
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < m; j++)
			cout << a[i][j] << " ";
		cout << endl;
	}
}


// �������� ������
void memory(int** a, int m) {
	for (int i = 0; i < m; i++)
		delete[] a[i];
	delete[] a;
}


// �������� ���������
void simm(int** a, int m) {
	int flag = 0;
	// �������� ������������ ������� ���
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < m; j++)
			if (a[i][j] != a[j][i]) {
				cout << "������� �� ����������� ������������ ������� ���" << endl;;
				flag = 1; break;
			}
		if (flag) break;
	}
	// �������� ������������ �������� ���
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < m; j++)
			if (a[i][j] != a[m - j - 1][m - i - 1]) {
				cout << "������� �� ����������� ������������ �������� ���" << endl;;
				flag = 1; break;
			}
		if (flag) break;
	}

	if (!flag) cout << "������� ����������� ������������ ����� ����������" << endl;
}