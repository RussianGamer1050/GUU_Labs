#include <iostream>
#include <string.h>
using namespace std;

const int K = 6;

class Journal {
public:
	string name;
	int year;
	int pages[6];

	Journal(string d_name = "Default", int d_year = 2024, int d_pages = 1);
	Journal(const Journal& obj);

	void input();
	void print();

	Journal operator = (const Journal& obj);
	int operator == (const Journal& obj);
	int& operator [] (int n);
	int operator - ();
};

Journal::Journal(string d_name, int d_year, int d_pages) {
	name = d_name; year = d_year;
	for (int i = 0; i < K; i++)
		pages[i] = d_pages;
}

Journal::Journal(const Journal& obj) {
	name = obj.name; year = obj.year;
	for (int i = 0; i < K; i++)
		pages[i] = obj.pages[i];
}

void Journal::input() {
	cout << "���� �������� � ����������:" << endl;
	cout << "��������: "; cin >> name;
	cout << "��� �������: "; cin >> year;
	cout << "���������� ������� � ������ �� 6-�� �������: "; 
	for (int i = 0; i < K; i++)
		cin >> pages[i];
	cout << endl;
}

void Journal::print() {
	cout << "��������: " << name << endl;
	cout << "��� �������: " << year << endl;
	cout << "���������� ������� � ������ �� 6-�� �������:\n[ ";
	for (int i = 0; i < K; i++)
		cout << pages[i] << " ";
	cout << "]" << endl;
}

Journal Journal::operator = (const Journal& obj) {
	if (&obj == this) return *this;
	name = obj.name; year = obj.year;
	for (int i = 0; i < K; i++)
		pages[i] = obj.pages[i];
	return *this;
}

int Journal::operator == (const Journal& obj) {
	if (&obj == this) return 1;
	for (int i = 0; i < K; i++)
		if (pages[i] != obj.pages[i]) return 0;
	if (name != obj.name || year != obj.year) return 0;
	return 1;
}

int& Journal::operator [] (int n) {
	if (n < 0 || n >= K) {
		cout << "������ �������"; exit(-1);
	}
	return pages[n];
}

int Journal::operator - () {
	int max = pages[0], min = pages[0];
	for (int i = 0; i < K; i++) {
		if (max < pages[i]) max = pages[i];
		if (min > pages[i]) min = pages[i];
	}
	return max - min;
}



int main() {
	setlocale(LC_ALL, "Rus");

	int n;
	Journal Default, Test("Test", 9999, -1), Pechat;
	Pechat.input();
	Pechat.print();
	cout << endl;

	// �������� �������� �����
	cout << "___�������� �����___" << endl;
	cout << "Default == Pechat: " << (Default == Pechat) << endl;
	cout << "Test == Test: " << (Test == Test) << endl;
	cout << endl;

	// �������� ��������������
	cout << "___��������������___" << endl;
	cout << "������� ����� �������: "; cin >> n;
	cout << "Pechat: " << Pechat[n-1] << endl;
	cout << endl;

	// �������� �������� ������
	cout << "___������� �����___" << endl;
	cout << "�������� ���������� ������� ����� ����� ������� � ����� ������ ������� : " << -Pechat << endl;
	cout << endl;

	// �������� ������������
	cout << "___�������� ������������___" << endl;
	Default.print();
	Test.print();
	cout << endl;

	cout << "������ ����:" << endl;
	Test = Test;
	Test.print();
	cout << endl;

	cout << "Delault = Test:" << endl;
	Default = Test;
	Default.print();
	Test.print();

	return 0;
}
