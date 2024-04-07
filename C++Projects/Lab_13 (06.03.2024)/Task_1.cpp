#include <iostream>
using namespace std;

class TOne {
public:
	float a1, a2, * p1, * p2;

	TOne();
	~TOne();
};

// Реализации
TOne::TOne() {
	p1 = new float; p2 = new float;

	a1 = 1.11; // a1 в TOne
}

TOne::~TOne() {
	delete p1; delete p2;
}


class TTwo {
public:
	TOne one;

	TTwo();
};

// Реализация
TTwo::TTwo() {
	*one.p1 = 3.33; // p1 в TTwo
}


int main() {
	setlocale(LC_ALL, "Rus");

	// Выделение мамяти под переменные
	TTwo* ptwo = new TTwo;
	TOne* p3;

	// Присваивание
	ptwo->one.a2 = 2.22; // a2 в main
	*ptwo->one.p2 = 4.44; // p2 в main

	// Присвоение адреса переменной one
	p3 = &ptwo->one; // TOne = TOne

	// Вывод
	cout << "Значение a1: " << ptwo->one.a1 << " с адресом " << &ptwo->one.a1 << endl;
	cout << "Значение a2: " << ptwo->one.a2 << " с адресом " << &ptwo->one.a2 << endl;
	cout << "Значение p1: " << *ptwo->one.p1 << " с адресом " << ptwo->one.p1 << endl;
	cout << "Значение p2: " << *ptwo->one.p2 << " с адресом " << ptwo->one.p2 << endl;
	cout << "Значение адреса p3: " << p3 << endl;

	// Своевременная отчистка памяти
	delete ptwo;

	return 0;
}
