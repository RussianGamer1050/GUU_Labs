#include <iostream>

using namespace std;

const short s_arr_m = 5;

class TMyClass {
	char symbol;
	unsigned int* p_num;

	double s_arr[s_arr_m];

	int d_arr_m;
	float* d_arr;
public:
	TMyClass(char symbol_d = 'd', unsigned int p_num_d = 23, double s_arr_e_d = 2.8, int d_arr_m_d = 3, float d_arr_e_d = 7.3);
	TMyClass(const TMyClass& obj);
	~TMyClass();

	void input();
	void print();
	void fff(int k);
	friend void f_input(TMyClass& obj);
};


// Реализации
TMyClass::TMyClass(char symbol_d, unsigned int p_num_d, double s_arr_e_d, int d_arr_m_d, float d_arr_e_d) {
	symbol = symbol_d;
	p_num = new unsigned int; *p_num = p_num_d;

	for (int i = 0; i < s_arr_m; i++)
		s_arr[i] = s_arr_e_d;

	d_arr_m = d_arr_m_d;
	d_arr = new float[d_arr_m];
	for (int i = 0; i < d_arr_m; i++)
		d_arr[i] = d_arr_e_d;
}


TMyClass::TMyClass(const TMyClass& obj) {
	symbol = obj.symbol;

	p_num = new unsigned int;
	*p_num = *obj.p_num;

	for (int i = 0; i < s_arr_m; i++)
		s_arr[i] = obj.s_arr[i];

	d_arr_m = obj.d_arr_m;
	d_arr = new float[obj.d_arr_m];
	for (int i = 0; i < d_arr_m; i++)
		d_arr[i] = obj.d_arr[i];
}


TMyClass::~TMyClass() {
	delete p_num;
	delete[] d_arr;
}


void TMyClass::input() {
	cout << "Введите значения объекта:" << endl;
	cout << "char = "; cin >> symbol;
	cout << "unsigned int* = "; cin >> *p_num;

	cout << "double: "; for (int i = 0; i < s_arr_m; i++) cin >> s_arr[i];
	delete[] d_arr;
	cout << "Введите кол. эл."; cin >> d_arr_m;
	d_arr = new float[d_arr_m];
	cout << "float*: "; for (int i = 0; i < d_arr_m; i++) cin >> d_arr[i];
}


void TMyClass::print() {
	cout << "char = " << symbol << endl;
	cout << "unsigned int* = " << *p_num << endl;

	cout << "double: "; for (int i = 0; i < s_arr_m; i++) cout << s_arr[i] << " ";
	cout << endl;

	cout << "float*: "; for (int i = 0; i < d_arr_m; i++) cout << d_arr[i] << " ";
	cout << endl << endl;
}


void TMyClass::fff(int k) {
	cout << "Все элементы статического массива умножены на " << k << endl;

	for (int i = 0; i < s_arr_m; i++)
		s_arr[i] *= k;

	cout << "double: "; for (int i = 0; i < s_arr_m; i++) cout << s_arr[i] << " ";
	cout << endl << endl;
}


void f_input(TMyClass& obj) {
	cout << "Введите значения объекта:" << endl;
	cout << "char = "; cin >> obj.symbol;
	cout << "unsigned int* = "; cin >> *obj.p_num;

	cout << "double: "; for (int i = 0; i < s_arr_m; i++) cin >> obj.s_arr[i];

	delete[] obj.d_arr;
	cout << "Введите кол. эл."; cin >> obj.d_arr_m;
	obj.d_arr = new float[obj.d_arr_m];
	cout << "float*: "; for (int i = 0; i < obj.d_arr_m; i++) cin >> obj.d_arr[i];
}


// Исполнение
int main() {
	setlocale(LC_ALL, "Rus");

	int k = 5;
	TMyClass b, * px, * py;
	px = new TMyClass;
	py = new TMyClass;

	// b
	cout << "Объект b" << endl;
	b.print();
	b.fff(k);
	b.print();

	// px
	cout << "Объект px" << endl;
	px->input();
	px->print();
	px->fff(k);
	px->print();

	// py
	cout << "Объект py" << endl;
	f_input(*py);
	py->print();
	py->fff(k);
	py->print();

	// a
	cout << "Объект a" << endl;
	TMyClass a(b);
	a.print();
	a.fff(k);
	a.print();

	// Массив объектов
	cout << "Массив объектов:" << endl;
	const int arr_obj = 3;
	TMyClass arr[arr_obj];
	for (int i = 0; i < arr_obj; i++)
		arr[i].print();

	delete px;
	delete py;

	return 0;
}