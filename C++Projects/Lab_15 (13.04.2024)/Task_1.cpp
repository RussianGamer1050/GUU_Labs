#include <iostream>
using namespace std;

class TRing {
public:
	double ro, ri;

	TRing(double d_ro = 12.02, double d_ri = 11.34);

	void input();
	void print();

	TRing& operator = (TRing& obj);
	friend int operator == (TRing& obj1, TRing& obj2);
};

TRing::TRing(double d_ro, double d_ri) {
	ro = d_ro; ri = d_ri;
}

void TRing::input() {
	cout << "Введите характеристику кольца:" << endl;
	do {
		cout << "Внешний радиус: "; cin >> ro;
		if (ro <= 0) { cout << "Вы ввели неверное значение" << endl; continue; }
		cout << "Внутренний радиус: "; cin >> ri;
		if (ri <= 0 || ro < ri) { cout << "Вы ввели неверное значение" << endl; continue; }
	} while (ro <= 0 || ri <= 0 || ro < ri);
	cout << endl;
}

void TRing::print() {
	cout << "Характеристика кольца:" << endl;
	cout << "Внешний радиус: " << ro << endl;
	cout << "Внутренний радиус: " << ri << endl;
	cout << endl;
}

TRing& TRing::operator = (TRing& obj) {
	ro = obj.ro; ri = obj.ri;
	return *this;
}

int operator == (TRing& obj1, TRing& obj2) {
	if (obj1.ro != obj2.ro || obj1.ri != obj2.ri) return 0;
	return 1;
}


class TRing_Arr {
public:
	friend class TRing;
	TRing* Ring_Arr;
	int Ring_Arr_m;

	TRing_Arr(int d_Ring_Arr_m = 1);
	~TRing_Arr();

	void input();
	void print();

	TRing_Arr& operator = (TRing_Arr& obj);
	int operator == (TRing_Arr& obj);

	friend TRing_Arr& operator + (TRing_Arr& obj);
	TRing_Arr& operator ++ ();
};

TRing_Arr::TRing_Arr(int d_Ring_Arr_m) {
	Ring_Arr_m = d_Ring_Arr_m;
	TRing d_ring;
	Ring_Arr = new TRing[Ring_Arr_m];
	for (int i = 0; i < Ring_Arr_m; i++) {
		Ring_Arr[i] = d_ring;
	}
}

TRing_Arr::~TRing_Arr() {
	delete[] Ring_Arr;
}

void TRing_Arr::input() {
	delete[] Ring_Arr;
	TRing d;
	cout << "Введите количество колец: "; cin >> Ring_Arr_m;
	Ring_Arr = new TRing[Ring_Arr_m];
	for (int i = 0; i < Ring_Arr_m; i++) {
		d.input();
		Ring_Arr[i] = d;
	}
}

void TRing_Arr::print() {
	for (int i = 0; i < Ring_Arr_m; i++)
		Ring_Arr[i].print();
}

TRing_Arr& TRing_Arr::operator = (TRing_Arr& obj) {
	if (this == &obj) return *this;
	delete[] Ring_Arr; 
	Ring_Arr_m = obj.Ring_Arr_m;
	Ring_Arr = new TRing[obj.Ring_Arr_m];
	for (int i = 0; i < obj.Ring_Arr_m; i++)
		Ring_Arr[i] = obj.Ring_Arr[i];
	return *this;
}

int TRing_Arr::operator == (TRing_Arr& obj) {
	if (Ring_Arr_m != obj.Ring_Arr_m) return 0;
	for (int i = 0; i < Ring_Arr_m; i++)
		if (!(Ring_Arr[i] == obj.Ring_Arr[i])) return 0;
	return 1;
}

TRing_Arr& operator + (TRing_Arr& obj) {
	TRing d_ring;
	for (int i = 0; i < obj.Ring_Arr_m; i++)
		obj.Ring_Arr[i] = d_ring;
	return obj;
}

TRing_Arr& TRing_Arr::operator ++ () {
	TRing d_ring; TRing_Arr t_ring_arr(Ring_Arr_m);
	for (int i = 0; i < Ring_Arr_m; i++)
		t_ring_arr.Ring_Arr[i] = Ring_Arr[i];

	delete[] Ring_Arr; Ring_Arr_m++; Ring_Arr = new TRing[Ring_Arr_m];

	for (int i = 0; i < Ring_Arr_m - 1; i++)
		Ring_Arr[i] = t_ring_arr.Ring_Arr[i];
	Ring_Arr[Ring_Arr_m - 1] = d_ring;

	return *this;
}


int main() {
	setlocale(LC_ALL, "Rus");

	// Создание и заполнение объектов
	TRing a, b(6, 4);
	TRing_Arr c, d;
	cout << "### Введите пожалуйста значения объекта a:" << endl;
	a.input();
	cout << "### Введите пожалуйста значения объекта TRing_Arr:" << endl;
	c.input();


	// Тестирование
	cout << "------------------- Оператор (++) -------------------" << endl;
	cout << "(увеличивает длину массива на 1 элемент и записывает в него кольцо со значениями по умолчанию)" << endl;
	cout << "$$$ Объект TRing_Arr до:" << endl;
	c.print();
	cout << endl;

	++c;

	cout << "$$$ Объект TRing_Arr после:" << endl;
	c.print();
	cout << endl;


	cout << "------------------- Оператор (унарный +) -------------------" << endl;
	cout << "(сбрасывает параметры всех колец массива в значения по умолчанию)" << endl;
	cout << "$$$ Объект TRing_Arr до:" << endl;
	c.print();
	cout << endl;

	+c;

	cout << "$$$ Объект TRing_Arr после:" << endl;
	c.print();
	cout << endl;


	cout << "------------------- Операторы (равенства и присваивания) -------------------" << endl;
	cout << "$$$ Объект a:" << endl;
	a.print();
	cout << endl;
	cout << "$$$ Объект b:" << endl;
	b.print();
	cout << endl;

	cout << "-|- Верно ли, что: a == b? " << (a == b) << endl;
	cout << "~~~~ a = b ~~~~" << endl;
	a = b;
	cout << "-|- Верно ли, что: a == b? " << (a == b) << endl;

	cout << "$$$ Объект a:" << endl;
	a.print();
	cout << endl;
	cout << "$$$ Объект b:" << endl;
	b.print();
	cout << endl;


	cout << "------------------- Операторы (равенства и присваивания) для TRing_Arr -------------------" << endl;
	cout << "$$$ Объект c:" << endl;
	c.print();
	cout << endl;
	cout << "$$$ Объект d:" << endl;
	d.print();
	cout << endl;

	cout << "-|- Верно ли, что: c == d? " << (c == d) << endl;
	cout << "~~~~ c = d ~~~~" << endl;
	c = d;
	cout << "-|- Верно ли, что: c == d? " << (c == d) << endl;

	cout << "$$$ Объект c:" << endl;
	c.print();
	cout << endl;
	cout << "$$$ Объект d:" << endl;
	d.print();
	cout << endl;

	return 0;
}