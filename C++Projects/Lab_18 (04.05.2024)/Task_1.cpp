#include <iostream>
#include <fstream>
#include <iomanip> // setw()

using namespace std;

const int M = 5; // ���������� �������������� ����

// ******************************** �����, ��������������� ��� ********************************
class Factory {
public:
	friend class File_Factory;
	int number; // ����� ����
	string name; // ��������
	string supervisor; // �.�.�. ����������
	int filling[M]; // ������������������ �� ������ ������������� (%)
	string plan; // ���������������� ����
	int completion[4]; // ���������� ����� �� ������ ������� ���� (%)

	Factory(int d_number = 0, string d_name = "Default Firm", string d_supervisor = "Ivanov Ivan Ivanovich",
		int d_filling = 0, string d_plan = "Test", int d_completion = 0);
	Factory(Factory& obj);

	void title(); // ����� ������
	void add(); // ���� �������� � ����������

	Factory& operator = (Factory& obj); // ���������� ������������ Factory = Factory
	friend ostream& operator << (ostream& o, Factory& obj); // ���������� ������
	friend istream& operator >> (istream& i, Factory& obj); // ���������� ������
};

// �����������
Factory::Factory(int d_number, string d_name, string d_supervisor,
	int d_filling, string d_plan, int d_completion) {
	number = d_number;
	name = d_name;
	supervisor = d_supervisor;
	for (int i = 0; i < M; i++) filling[i] = d_filling;
	plan = d_plan;
	for (int i = 0; i < 4; i++) completion[i] = d_completion;
}

// �����
Factory::Factory(Factory& obj) {
	number = obj.number;
	name = obj.name;
	supervisor = obj.supervisor;
	for (int i = 0; i < M; i++) filling[i] = obj.filling[i];
	plan = obj.plan;
	for (int i = 0; i < 4; i++) completion[i] = obj.completion[i];
}

// ����� ������
void Factory::title() {
	cout << "\n  � |    ��������    |        �.�.�. ����������       |������������������ |      ����      |���������� �����|" << endl;
}

// ���� �������� � ����������
void Factory::add() {
	cout << " $$$$$$$$$ ������� �������� ���� � ���������� $$$$$$$$$ " << endl;
	
	do {
		cout << "����� ����: "; cin >> number;
		if (number < 1 || number > 999) cout << " !!!!! �� ����� ������������ �������� !!!!! " << endl;
	} while (number < 1 || number > 999);
	
	do {
		cout << "��������: "; cin >> name;
		if (size(name) > 16) cout << " !!!!! �� ����� ������������ �������� !!!!! " << endl;
	} while (size(name) > 16); // size() ���������� ���������� �������� ������
	
	do {
		cout << "�.�.�. ����������: "; cin >> supervisor;
		if (size(supervisor) > 32) cout << " !!!!! �� ����� ������������ �������� !!!!! " << endl;
	} while (size(supervisor) > 32); // size() ���������� ���������� �������� ������
	
	for (int i = 0; i < M; i++) { 
		do {
			cout << "������������������ " << i + 1 << " �������������: ";
			cin >> filling[i];
			if (filling[i] < 0 || filling[i] > 100) cout << " !!!!! �� ����� ������������ �������� !!!!! " << endl;
		} while (filling[i] < 0 || filling[i] > 100);
	}
	
	do {
		cout << "����: "; cin >> plan;
		if (size(plan) > 16) cout << " !!!!! �� ����� ������������ �������� !!!!! " << endl;
	} while (size(plan) > 16); // size() ���������� ���������� �������� ������

	for (int i = 0; i < 4; i++) { 
		do {
			cout << "���������� ����� �� " << i + 1 << " �������: "; 
			cin >> completion[i];
			if (completion[i] < 0 || completion[i] > 100) cout << " !!!!! �� ����� ������������ �������� !!!!! " << endl;
		} while (completion[i] < 0 || completion[i] > 100);
	}
}

// ���������� ������������ Factory = Factory
Factory& Factory::operator = (Factory& obj) {
	number = obj.number;
	name = obj.name;
	supervisor = obj.supervisor;
	for (int i = 0; i < M; i++) filling[i] = obj.filling[i];
	plan = obj.plan;
	for (int i = 0; i < 4; i++) completion[i] = obj.completion[i];
	return *this;
}

// ���������� ������
ostream& operator << (ostream& o, Factory& obj) {
	o << " " << setw(3) << obj.number << " " << setw(16) << obj.name << " " << setw(32) << obj.supervisor;
	for (int i = 0; i < M; i++) o << " " << setw(3) << obj.filling[i];
	o << " " << setw(16) << obj.plan;
	for (int i = 0; i < 4; i++) o << " " << setw(3) << obj.completion[i];
	o << endl;
	return o;
}

// ���������� �����
istream& operator >> (istream& i, Factory& obj) {
	i >> obj.number >> obj.name >> obj.supervisor;
	for (int j = 0; j < M; j++) i >> obj.filling[j];
	i >> obj.plan;
	for (int j = 0; j < 4; j++) i >> obj.completion[j];
	return i;
}



// ******************************** �����, ��������������� ���� ������ ********************************
class File_Factory {
public:
	string file_name; // ��� ������������� �����
	Factory f;

	File_Factory(string d_file_name = "Default File Name.guulabextention");

	void file_create(); // ������ � ���� ������ ���������� � ����
	void file_read(); // ������ � ����� �� ����� ���� ������� �����
	void file_add(); // ���������� ������ � ���� �����
	void file_find(int n); // ����� � ����� ���� � ��������� �������
};

// �����������
File_Factory::File_Factory(string d_file_name) {
	file_name = d_file_name;
	Factory d_f; f = d_f;
}

// ������ � ���� ������ ���������� � ����
void File_Factory::file_create() {
	ofstream ff(file_name); if (!ff) exit(-1);
	f.add(); ff << f;
	ff.close();
}

// ������ � ����� �� ����� ���� ������� �����
void File_Factory::file_read() {
	ifstream ff(file_name); if (!ff) exit(-1);
	f.title();
	while (ff >> f) { // ������ f.eof(), �.�. ������ ������� ��������� ������� ��� ����
		cout << f;
	}
	ff.close();
}

// ���������� ������ � ���� �����
void File_Factory::file_add() {
	ofstream ff(file_name, ios::app); if (!ff) exit(-1);
	f.add(); ff << f;
	ff.close();
}

// ����� � ����� ���� � ��������� �������
void File_Factory::file_find(int n) {
	ifstream ff(file_name); if (!ff) exit(-1);
	int k = 0;

	while (ff >> f) if (f.number == n) k++; // �������� ������� ���������� ������� � �����

	if (k) {
		ff.clear(); ff.seekg(0); // ���������� �������� ������ � ������ �����
		f.title();
		while (ff >> f) {
			if (f.number == n) cout << f;
		}
	}
	else cout << " !!!! ���������� � ����� � ����� ������� �� ������� !!!! \n" << endl;
	
	ff.close();
}



int main() {
	setlocale(LC_ALL, "Rus");

	File_Factory a;

	while (1) {
		cout << "\n $$$$$$$$$ �������� ������� �� ����������� ������ $$$$$$$$$ " << endl;
		cout << "1) ������� � �������� � ���� ������� ����������;\n"
			"2) ����������� ��� ������ �� ����� ������;\n"
			"3) �������� ������ � ���� ������;\n"
			"4) ������ ������� � ����� � ��������� �������;\n"
			"5) �����;\n"<< endl;
		int c; cin >> c;
		
		switch (c) {
		case 1: a.file_create(); break; // �������� �����
		case 2: a.file_read(); break; // ������ �����
		case 3: a.file_add(); break; // ���������� ������ � ����
		case 4: // ����� ������ ���� � ��������� �������
			while (1) {
				int f_n;
				cout << "������� ����� ���� ��� \"-1 ��� �������� �����\": "; cin >> f_n;
				if (f_n == -1) break; 
				a.file_find(f_n);
			} break;
		case 5: return 0; // ����� �� ���������
		default: cout << " !!!!! ������ �������� ������� !!!!! \n" << endl;
		}
	}

	return 0;
}

// �������� � �.�.�. ��������� ��� ��������