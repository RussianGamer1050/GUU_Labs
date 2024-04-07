#include <iostream>
using namespace std;

class TOne {
public:
	float a1, a2, * p1, * p2;

	TOne();
	~TOne();
};

// ����������
TOne::TOne() {
	p1 = new float; p2 = new float;

	a1 = 1.11; // a1 � TOne
}

TOne::~TOne() {
	delete p1; delete p2;
}


class TTwo {
public:
	TOne one;

	TTwo();
};

// ����������
TTwo::TTwo() {
	*one.p1 = 3.33; // p1 � TTwo
}


int main() {
	setlocale(LC_ALL, "Rus");

	// ��������� ������ ��� ����������
	TTwo* ptwo = new TTwo;
	TOne* p3;

	// ������������
	ptwo->one.a2 = 2.22; // a2 � main
	*ptwo->one.p2 = 4.44; // p2 � main

	// ���������� ������ ���������� one
	p3 = &ptwo->one; // TOne = TOne

	// �����
	cout << "�������� a1: " << ptwo->one.a1 << " � ������� " << &ptwo->one.a1 << endl;
	cout << "�������� a2: " << ptwo->one.a2 << " � ������� " << &ptwo->one.a2 << endl;
	cout << "�������� p1: " << *ptwo->one.p1 << " � ������� " << ptwo->one.p1 << endl;
	cout << "�������� p2: " << *ptwo->one.p2 << " � ������� " << ptwo->one.p2 << endl;
	cout << "�������� ������ p3: " << p3 << endl;

	// ������������� �������� ������
	delete ptwo;

	return 0;
}
