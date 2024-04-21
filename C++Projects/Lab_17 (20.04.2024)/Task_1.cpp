#include <iostream>
#include <string.h>
using namespace std;

// Абстрактный базовый класс
class Stationary {
public:
	double price; // цена
	string firm; // фирма производитель

	virtual void input(); // ввод
	virtual void print(); // ввывод
	virtual void process() = 0; // описание
};

void Stationary::input() {
	cout << "___ Введите информацию о предмете ___" << endl;
	cout << "Цена: "; cin >> price;
	cout << "Фирма: "; cin >> firm;
}

void Stationary::print() {
	cout << "### Информация о предмете ###" << endl;
	cout << "Цена: " << price << endl;
	cout << "Фирма: " << firm << endl;
}



// Канцтовары которыми пишут
class TCh1 : public Stationary{
public:
	string material; // материал
	string colour; // цвет

	TCh1(double d_price = 2.5, string d_firm = "Default Firm", string d_material = "Wood", string d_colour = "Black");

	virtual void input(); // ввод значений с клавиатуры
	virtual void print(); // вывод значений на экран
	virtual void process(); // описание назначения
};

// Реализации TCh1
TCh1::TCh1(double d_price, string d_firm, string d_material, string d_colour) {
	price = d_price; firm = d_firm; material = d_material; colour = d_colour;
}

void TCh1::input() {
	Stationary::input();
	cout << "Материал: "; cin >> material;
	cout << "Цвет: "; cin >> colour;
}

void TCh1::print() {
	Stationary::print();
	cout << "Материал: " << material << endl;
	cout << "Цвет: " << colour << endl;
}

void TCh1::process() {
	cout << "Это предмет которым пишут" << endl;
}


class Pencil : public TCh1 {
public:
	string hardness; // жесткость

	Pencil(double d_price = 2.5, string d_firm = "Default Firm", string d_material = "Wood", string d_colour = "Black", string d_hardness = "HB");

	void input(); // ввод значений с клавиатуры
	void print(); // вывод значений на экран
	void process(); // описание
};

// Реализации Pencil
Pencil::Pencil(double d_price, string d_firm, string d_material, string d_colour, string d_hardness)
	: TCh1 (d_price, d_firm, d_material, d_colour) {
	hardness = d_hardness;
}

void Pencil::input() {
	TCh1::input();
	cout << "Жесткость: "; cin >> hardness;
}

void Pencil::print() {
	TCh1::print();
	cout << "Жесткость: " << hardness << endl;
}

void Pencil::process() {
	TCh1::process();
	cout << "Ручка - инструмент для письма, использующий чернила" << endl;
}


class Pen : public TCh1 {
public:
	double thickness; // толщина стержня

	Pen(double d_price = 2.5, string d_firm = "Default Firm", string d_material = "Wood", string d_colour = "Black", double d_thickness = 0.5);

	void input(); // ввод значений с клавиатуры
	void print(); // вывод значений на экран
	void process(); // описание
};

// Реализации Pen
Pen::Pen(double d_price, string d_firm, string d_material, string d_colour, double d_thickness)
	: TCh1(d_price, d_firm, d_material, d_colour) {
	thickness = d_thickness;
}

void Pen::input() {
	TCh1::input();
	cout << "Толщина стержня: "; cin >> thickness;
}

void Pen::print() {
	TCh1::print();
	cout << "Толщина стержня: " << thickness << endl;
}

void Pen::process() {
	TCh1::process();
	cout << "Карандаш - инструмент для письма в основе которого находится грифель" << endl;
}




// Канцтовары в которые пишут
class TCh2 : public Stationary {
public:
	int pages; // количество страниц
	int density; // плотность бумаги

	TCh2(double d_price = 2.5, string d_firm = "Default Firm", int d_pages = 1, int d_density = 10);

	virtual void input(); // ввод значений с клавиатуры
	virtual void print(); // вывод значений на экран
	virtual void process(); // описание назначения
};

// Реализации TCh2
TCh2::TCh2(double d_price, string d_firm, int d_pages, int d_density) {
	price = d_price; firm = d_firm; pages = d_pages; density = d_density;
}

void TCh2::input() {
	Stationary::input();
	cout << "Количество страниц: "; cin >> pages;
	cout << "Плотность бумаги: "; cin >> density;
}

void TCh2::print() {
	Stationary::print();
	cout << "Количество страниц: " << pages << endl;
	cout << "Плотность бумаги: " << density << endl;
}

void TCh2::process() {
	cout << "Это предмет на котором пишут" << endl;
}


class Textbook : public TCh2 {
public:
	double cage; // размер клетки

	Textbook(double d_price = 2.5, string d_firm = "Default Firm", int d_pages = 1, int d_density = 10, double d_cage = 2.1);

	void input(); // ввод значений с клавиатуры
	void print(); // вывод значений на экран
	void process(); // описание
};

// Реализации Textbook
Textbook::Textbook(double d_price, string d_firm, int d_pages, int d_density, double d_cage)
	: TCh2(d_price, d_firm, d_pages, d_density) {
	cage = d_cage;
}

void Textbook::input() {
	TCh2::input();
	cout << "Размер клетки: "; cin >> cage;
}

void Textbook::print() {
	TCh2::print();
	cout << "Размер клетки: " << cage << endl;
}

void Textbook::process() {
	cout << "Тетрадь - сшитые листы чистой бумаги в обложке" << endl;
}


class Album : public TCh2 {
public:
	string format; // формат листа

	Album(double d_price = 2.5, string d_firm = "Default Firm", int d_pages = 1, int d_density = 10, string d_format = "A4");

	void input(); // ввод значений с клавиатуры
	void print(); // вывод значений на экран
	void process(); // описание
};

// Реализации Album
Album::Album(double d_price, string d_firm, int d_pages, int d_density, string d_format)
	: TCh2(d_price, d_firm, d_pages, d_density) {
	format = d_format;
}

void Album::input() {
	TCh2::input();
	cout << "Формат: "; cin >> format;
}

void Album::print() {
	TCh2::print();
	cout << "Формат: " << format << endl;
}

void Album::process() {
	cout << "Альбом - прямоугольная тетрадь с листами без линий" << endl;
}




int main() {
	setlocale(LC_ALL, "Rus");

	Stationary* item;

	int choice;
	while (1) {
		cout << "$$$ Введите желаемое действие $$$" << endl;
		cout << "1) Создать карандаш" << endl;
		cout << "2) Создать ручку" << endl;
		cout << "3) Создать тетрадь" << endl;
		cout << "4) Создать альбом" << endl;
		cout << "5) Выход" << endl;
		cin >> choice;

		switch (choice) {
		case 1: item = new Pencil; break;
		case 2: item = new Pen; break;
		case 3: item = new Textbook; break;
		case 4: item = new Album; break;
		case 5: return 0; break;
		default: cout << "Введено неверное действие\n\n\n" << endl; continue;
		}

		item->input();
		item->print();
		item->process();
		cout << endl;
		delete item;
	}

	return 0;
}
