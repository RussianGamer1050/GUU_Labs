#include <iostream>

using namespace std;

const short s_arr_m = 5;

class TMyClass {
private:
	char symbol;
	unsigned int* p_num;

	double s_arr[s_arr_m];

	int d_arr_m;
	float* d_arr;

public:
	TMyClass(char symbol_d = 'd', unsigned int p_num_d = 23, double s_arr_e_d = 2.8, int d_arr_m_d = 3, float d_arr_e_d = 7.3);
	TMyClass(const TMyClass& obj);

	void input();
	void print();
	void fff(int k);
	friend void f_input(TMyClass& obj);
};

// Реализации TMyClass
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


class TChild : public TMyClass {
	int i;
	int* p_i;

public:
	TChild(char symbol_d = 'd', unsigned int p_num_d = 23, double s_arr_e_d = 2.8, int d_arr_m_d = 3, float d_arr_e_d = 7.3, int d_i = 5, int d_p_i = 4);
	TChild(const TChild& obj);

	void print();
};

// Реализации TChild
TChild::TChild(char symbol_d, unsigned int p_num_d, double s_arr_e_d, int d_arr_m_d, float d_arr_e_d, int d_i, int d_p_i)
	: TMyClass(symbol_d, p_num_d, s_arr_e_d, d_arr_m_d, d_arr_e_d) {
	i = d_i;
	p_i = new int; *p_i = d_p_i;
}

TChild::TChild(const TChild& obj) : TMyClass(obj) {
	i = obj.i;
	p_i = new int;
	*p_i = *obj.p_i;
}

void TChild::print() {
	TMyClass::print();
	cout << "Собственные значения: " << endl;
	cout << "int = " << i << endl;
	cout << "int* = " << *p_i << endl;
	cout << endl;
}


// Исполнение
int main() {
	setlocale(LC_ALL, "Rus");

	// --------------- TMyClass ---------------
	TMyClass pa('a', 1, 1.1, 1, 1.1); TMyClass pb(pa); TMyClass* pc = new TMyClass;
	
	cout << "$$$Объект pa: " << endl;
	pa.print();
	cout << "$$$Объект pb: " << endl;
	pb.print();
	cout << "$$$Объект pc: " << endl;
	pc->print();


	// --------------- TChild ---------------
	TChild ca('a', 1, 1.1, 1, 1.1, 1, 5); TChild cb(ca); TChild* cc = new TChild;

	cout << "$$$Объект ca: " << endl;
	ca.print();
	cout << "$$$Объект cb: " << endl;
	cb.print();
	cout << "$$$Объект cc: " << endl;
	cc->print();

	cout << "$$$Унаследованный вывод для каждого дочернего элемента: " << endl;
	ca.TMyClass::print();
	cb.TMyClass::print();
	cc->TMyClass::print();

	cout << "$$$Унаследованный ввод: " << endl;
	f_input(ca);
	cout << endl;

	ca.print();
	
	delete pc, cc;

	return 0;
}
