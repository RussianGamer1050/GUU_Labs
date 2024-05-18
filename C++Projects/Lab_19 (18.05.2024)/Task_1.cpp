#include <iostream>
using namespace std;


// ����� �����
class goods {
	friend  class el;
	friend  class list;
private:
	string name; // ��������
	float price; // ����
	int quantity; // ����������

	goods(string d_name = "Default goods name", float d_price = 0.00, int d_quantity = 0);
public:
	void input(); // ���������� �������
	void print(); // ����� ���������� � ������ �� �����
};

goods::goods(string d_name, float d_price, int d_quantity) {
	name = d_name; price = d_price; quantity = d_quantity;
}

// ���������� �������
void goods::input() {
	cout << "��������: "; cin >> name;
	cout << "����: "; cin >> price;
	cout << "����������: "; cin >> quantity;
	cout << endl;
}

// ����� ���������� � ������ �� �����
void goods::print() {
	cout << "��������: " << name << "\n";
	cout << "����: " << price << "\n";
	cout << "����������: " << quantity << "\n";
	cout << endl;
}


// ����� �������� ������
class el {
	friend class list;
private:
	goods g; // ������ ������ �����
	el* next; // ������ �� ��������� ������� ������
public:
	el(); // next = nullptr

};

el::el() {
	next = nullptr;
}


// ����� ������
class list {
public:
	el* first, * last; // ������ �� ������ � ��������� �������� ������
	el* active; // ��� ������ � ����������

	list(); // active = first = last = nullptr

	void l_create(); // �������� ������ �������
	void l_print(); // ����� ������ �� �����
	void l_delf(); // �������� ������� ��������
	void l_dell(); // �������� ���������� ��������
	void l_above_avr(); // ����� ���������� � �������, ��������� ������� ���� �������
	void l_delete(); // ����������� ������
	
	int l_empty(); // �������� �� ������� ������ ����� �������
};

list::list() {
	active = first = last = nullptr;
}

// �������� ������ �������
void list::l_create() {
	if (first) { cout << "!!! ������ ��� ���������� !!!" << endl; return; } // �������� �� ������������� ������
	
	// ���������������� ���������� ������
	cout << "��������������� ������� ������ � ������: " << endl;
	while (1) {
		active = new el; // ��������� ����� ������ ��� �������� �������

		if (first != nullptr) { // ��������� ������������� ������� ��������
			active->g.input(); // ���� ������ � �������� ������
			last->next = active; // ��������� �� ��������� ������ �� �����������
			last = active; // ����������� �������� �������� ������ ����������
		}

		if (first == nullptr) { // ���� ������ ������
			first = last = active; // ����������� ������� ��������
			active->g.input(); // ���� ������ � ������ �������
		}

		// ����������� ������ �� ����� � ��������� �����
		int choice;
		do {
			cout << "������� ����������? (1 - ���������� / 0 - �����) "; cin >> choice;
			if (choice < 0 || choice > 1) cout << "!!! ������ ������������ ������� !!!\n";
		} while (choice < 0 || choice > 1);
		if (!choice) break;
	}
}

// ����� ������ �� �����
void list::l_print() {
	if (first == nullptr) { cout << "!!! ������ �� ������ !!!" << endl; return; } // �������� �� ��������������� ������
	
	active = first; // ������ ����� �������
	int k = 1; // ������� ��� ������� ������
	while (active) { // ���� active != null
		cout << k++ << ". �������:\n";
		active->g.print();
		active = active->next; // ������� � ���������� ��������
	}
	cout << endl;
}

// �������� ������� ��������
void list::l_delf() {
	if (first == nullptr) { cout << "!!! ������ �� ������ !!!" << endl; return; } // �������� �� ��������������� ������

	active = first; // ������� �������� ������ �������
	first = active->next; // ����� ������ ������� - ������ �������
	delete active; // ������� �������� �������

	cout << "������ ������ ������\n" << endl;
}

// �������� ���������� ��������
void list::l_dell() {
	if (first == nullptr) { cout << "!!! ������ �� ������ !!!" << endl; return; } // �������� �� ��������������� ������

	if (first == last) { l_delf(); return; } // ���� ������ ������� �������� ���������

	active = first; // ������� �������� ������ �������
	while (active->next != last) active = active->next; // ���� �� �������������� �������� ������
	active->next = nullptr;
	delete last;
	last = active;

	cout << "��������� ������ ������\n" << endl;
}

// ����� ���������� � �������, ��������� ������� ���� �������
void list::l_above_avr() {
	if (first == nullptr) { cout << "!!! ������ �� ������ !!!" << endl; return; } // �������� �� ��������������� ������

	int k = 1; // ���������� ��������� ������
	float sum = first->g.price; // ��������� ���� ������� ������, ������� � ����� �������
	
	// ������� ���������� ��������� � �����
	active = first;
	while (active->next) { k++; sum += active->next->g.price; active = active->next; }

	// �������� �� ��������� �������
	int fl = 0; // ���� ������� ���������� ��������� � ������
	active = first;
	// ������� ����� ������
	for (int i = 0; i < k; i++) {
		if (active->g.price > (sum / k)) { active->g.print(); fl = 1; }
		active = active->next;
	}
	if (!fl) cout << "!!! ��� ������ ����� ���������� ��������� !!!" << endl; // ���� ��� ���������� �������
}

// ����������� ������
void list::l_delete() {
	if (first == nullptr) { cout << "!!! ������ �� ������ !!!" << endl; return; } // �������� �� ��������������� ������

	active = first; // ������� �������� ������ �������
	while (active->next != nullptr) {
		first = active->next; // ����� ������ ������� - ������ �������
		delete active; // ������� �������� �������
		active = first; // ������� �������� ������ �������
	}
	delete active; // ���������� ������ ������� � ���� => first != nullptr, ������� ������ �������������
	first = nullptr; // �. �. ����� �� �� ������ ��-����� ������� ������
}

int list::l_empty() {
	if (first != nullptr) return 0;
	return 1;
}


int main() {
	setlocale(LC_ALL, "Rus");

	list a; // ������
	int choice; // ����� ������������ � ����

	while (1) {
		cout << "�������� ����������� ������� (-1 ��� ������):\n"
			<< "1) ������� ������ �������;\n" 
			<< "2) ����������� ������;\n"
			<< "3) ������� ������ ������� ������;\n"
			<< "4) ������� ��������� ������� ������;\n"
			<< "5) ������� ���������� � �������, ��������� ������� ���� �������;\n"
			<< "6) ���������� ������.\n";
		cin >> choice; cout << endl;

		// ����������� ����
		switch (choice) {
		case 1: a.l_create(); break; // ������� ������ �������
		case 2: a.l_print(); break; // ����������� ������
		case 3: a.l_delf(); break; // ������� ������ ������� ������
		case 4: a.l_dell(); break; // ������� ��������� ������� ������
		case 5: a.l_above_avr(); break; // ������� ���������� � �������, ��������� ������� ���� �������
		case 6: a.l_delete(); break; // ���������� ������
		case -1: if (!a.l_empty()) a.l_delete(); return 0; // ����� � ��������� �� ������� ������
		default: cout << "!!! ������ ������������ ������� !!!\n"; // �������� �����
		}
	}

	return 0;
}
