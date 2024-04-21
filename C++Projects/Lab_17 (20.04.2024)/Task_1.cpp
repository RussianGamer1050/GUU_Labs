#include <iostream>
#include <string.h>
using namespace std;

// ����������� ������� �����
class Stationary {
public:
	double price; // ����
	string firm; // ����� �������������

	virtual void input(); // ����
	virtual void print(); // ������
	virtual void process() = 0; // ��������
};

void Stationary::input() {
	cout << "___ ������� ���������� � �������� ___" << endl;
	cout << "����: "; cin >> price;
	cout << "�����: "; cin >> firm;
}

void Stationary::print() {
	cout << "### ���������� � �������� ###" << endl;
	cout << "����: " << price << endl;
	cout << "�����: " << firm << endl;
}



// ���������� �������� �����
class TCh1 : public Stationary{
public:
	string material; // ��������
	string colour; // ����

	TCh1(double d_price = 2.5, string d_firm = "Default Firm", string d_material = "Wood", string d_colour = "Black");

	virtual void input(); // ���� �������� � ����������
	virtual void print(); // ����� �������� �� �����
	virtual void process(); // �������� ����������
};

// ���������� TCh1
TCh1::TCh1(double d_price, string d_firm, string d_material, string d_colour) {
	price = d_price; firm = d_firm; material = d_material; colour = d_colour;
}

void TCh1::input() {
	Stationary::input();
	cout << "��������: "; cin >> material;
	cout << "����: "; cin >> colour;
}

void TCh1::print() {
	Stationary::print();
	cout << "��������: " << material << endl;
	cout << "����: " << colour << endl;
}

void TCh1::process() {
	cout << "��� ������� ������� �����" << endl;
}


class Pencil : public TCh1 {
public:
	string hardness; // ���������

	Pencil(double d_price = 2.5, string d_firm = "Default Firm", string d_material = "Wood", string d_colour = "Black", string d_hardness = "HB");

	void input(); // ���� �������� � ����������
	void print(); // ����� �������� �� �����
	void process(); // ��������
};

// ���������� Pencil
Pencil::Pencil(double d_price, string d_firm, string d_material, string d_colour, string d_hardness)
	: TCh1 (d_price, d_firm, d_material, d_colour) {
	hardness = d_hardness;
}

void Pencil::input() {
	TCh1::input();
	cout << "���������: "; cin >> hardness;
}

void Pencil::print() {
	TCh1::print();
	cout << "���������: " << hardness << endl;
}

void Pencil::process() {
	TCh1::process();
	cout << "����� - ���������� ��� ������, ������������ �������" << endl;
}


class Pen : public TCh1 {
public:
	double thickness; // ������� �������

	Pen(double d_price = 2.5, string d_firm = "Default Firm", string d_material = "Wood", string d_colour = "Black", double d_thickness = 0.5);

	void input(); // ���� �������� � ����������
	void print(); // ����� �������� �� �����
	void process(); // ��������
};

// ���������� Pen
Pen::Pen(double d_price, string d_firm, string d_material, string d_colour, double d_thickness)
	: TCh1(d_price, d_firm, d_material, d_colour) {
	thickness = d_thickness;
}

void Pen::input() {
	TCh1::input();
	cout << "������� �������: "; cin >> thickness;
}

void Pen::print() {
	TCh1::print();
	cout << "������� �������: " << thickness << endl;
}

void Pen::process() {
	TCh1::process();
	cout << "�������� - ���������� ��� ������ � ������ �������� ��������� �������" << endl;
}




// ���������� � ������� �����
class TCh2 : public Stationary {
public:
	int pages; // ���������� �������
	int density; // ��������� ������

	TCh2(double d_price = 2.5, string d_firm = "Default Firm", int d_pages = 1, int d_density = 10);

	virtual void input(); // ���� �������� � ����������
	virtual void print(); // ����� �������� �� �����
	virtual void process(); // �������� ����������
};

// ���������� TCh2
TCh2::TCh2(double d_price, string d_firm, int d_pages, int d_density) {
	price = d_price; firm = d_firm; pages = d_pages; density = d_density;
}

void TCh2::input() {
	Stationary::input();
	cout << "���������� �������: "; cin >> pages;
	cout << "��������� ������: "; cin >> density;
}

void TCh2::print() {
	Stationary::print();
	cout << "���������� �������: " << pages << endl;
	cout << "��������� ������: " << density << endl;
}

void TCh2::process() {
	cout << "��� ������� �� ������� �����" << endl;
}


class Textbook : public TCh2 {
public:
	double cage; // ������ ������

	Textbook(double d_price = 2.5, string d_firm = "Default Firm", int d_pages = 1, int d_density = 10, double d_cage = 2.1);

	void input(); // ���� �������� � ����������
	void print(); // ����� �������� �� �����
	void process(); // ��������
};

// ���������� Textbook
Textbook::Textbook(double d_price, string d_firm, int d_pages, int d_density, double d_cage)
	: TCh2(d_price, d_firm, d_pages, d_density) {
	cage = d_cage;
}

void Textbook::input() {
	TCh2::input();
	cout << "������ ������: "; cin >> cage;
}

void Textbook::print() {
	TCh2::print();
	cout << "������ ������: " << cage << endl;
}

void Textbook::process() {
	cout << "������� - ������ ����� ������ ������ � �������" << endl;
}


class Album : public TCh2 {
public:
	string format; // ������ �����

	Album(double d_price = 2.5, string d_firm = "Default Firm", int d_pages = 1, int d_density = 10, string d_format = "A4");

	void input(); // ���� �������� � ����������
	void print(); // ����� �������� �� �����
	void process(); // ��������
};

// ���������� Album
Album::Album(double d_price, string d_firm, int d_pages, int d_density, string d_format)
	: TCh2(d_price, d_firm, d_pages, d_density) {
	format = d_format;
}

void Album::input() {
	TCh2::input();
	cout << "������: "; cin >> format;
}

void Album::print() {
	TCh2::print();
	cout << "������: " << format << endl;
}

void Album::process() {
	cout << "������ - ������������� ������� � ������� ��� �����" << endl;
}




int main() {
	setlocale(LC_ALL, "Rus");

	Stationary* item;

	int choice;
	while (1) {
		cout << "$$$ ������� �������� �������� $$$" << endl;
		cout << "1) ������� ��������" << endl;
		cout << "2) ������� �����" << endl;
		cout << "3) ������� �������" << endl;
		cout << "4) ������� ������" << endl;
		cout << "5) �����" << endl;
		cin >> choice;

		switch (choice) {
		case 1: item = new Pencil; break;
		case 2: item = new Pen; break;
		case 3: item = new Textbook; break;
		case 4: item = new Album; break;
		case 5: return 0; break;
		default: cout << "������� �������� ��������\n\n\n" << endl; continue;
		}

		item->input();
		item->print();
		item->process();
		cout << endl;
		delete item;
	}

	return 0;
}
