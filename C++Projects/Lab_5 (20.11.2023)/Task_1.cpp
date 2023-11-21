#include <iostream>
#include <iomanip>

using namespace std;

int main() {

	setlocale(LC_ALL, "Rus");
	srand(time(0));

	int N, M, A, B; // ������ �� �������
	A = -2; B = 2; // ������� ������������

	// ���� ���������� ����� � �������� �������
	cout << "������� ���������� �����: "; cin >> N;
	cout << "������� ���������� ��������: "; cin >> M;

	// �������� ������������ �������
	int** matrix = new int* [N];
	for (int i = 0; i < N; i++) matrix[i] = new int[M];

	// ���������� �������
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			matrix[i][j] = rand() % (B - A + 1) + A;

	// ����� ��������� �������
	cout << "    ";
	for (int i = 1; i <= M; i++) { // ��������������� �������
		cout << setw(5) << i;
	}
	cout << endl;
	cout << "    ";
	for (int i = 1; i <= M; i++) {
		cout << "-----";
	}
	cout << "----" << endl;
	for (int i = 0; i < N; i++) {
		cout << i + 1 << setw(4) << "[ ";
		for (int j = 0; j < M; j++)
			cout << setw(5) << matrix[i][j] << setw(5);
		cout << " ]\n";
	}
	cout << endl << endl;

	// ���������� ������������ �������� �������
	int min_el = 21;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			if (matrix[i][j] < min_el) min_el = matrix[i][j];

	// ����������� ������������� ��������
	int max_el = -21;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			if (matrix[i][j] > max_el) max_el = matrix[i][j];

	// ���������� ������������� ��������
	int fl_repeat = -2;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++)
			if (matrix[i][j] == max_el) fl_repeat++;
		if (fl_repeat >= 1) break;
	}

	// ���� ������������ ������� ���������� - ������ ����. �� ���.
	if (fl_repeat >= 1)
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			if (matrix[i][j] == max_el) matrix[i][j] = min_el;

	// ����� ��������� �������
	if (fl_repeat >= 1) {
		cout << "��� ��� ������������ ������� ������� [ " << max_el <<
			" ] ���������� ����� ������ ����, �������� ��� �� ����������� [ " <<
			min_el << " ]:" << endl;
		cout << "    ";
		for (int i = 1; i <= M; i++) { // ��������������� �������
			cout << setw(5) << i;
		}
		cout << endl;
		cout << "    ";
		for (int i = 1; i <= M; i++) {
			cout << "-----";
		}
		cout << "----" << endl;
		for (int i = 0; i < N; i++) {
			cout << i + 1 << setw(4) << "[ ";
			for (int j = 0; j < M; j++)
				cout << setw(5) << matrix[i][j] << setw(5);
			cout << " ]\n";
		}
	}
	else cout << "������������ ������� �� ���������� ����� ������ ����, " <<
		"������������� ������� �������� ��� �������� �� ���������" << endl;

	return 0;
}
