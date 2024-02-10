#include <iostream>

using namespace std;

int vvod(int X);

void rot(int num);

int main() {
	setlocale(LC_ALL, "Rus");

	int X = 12; // Предельное значение
	int k = 3; // Количество чисел
	int n; // Обрабатываемое и вводимое число

	for (int i = 0; i < k; i++) {
		n = vvod(X);
		rot(n);
		cout << endl;
	}

	return 0;
}


// Функция ввода
int vvod(int X) {
	int num;
	cout << "Введите число >" << X << ": ";
	do {
		cin >> num;
		if (num < X) cout << "Вы ввели неверное значение" << endl;
	} while (num < X);
	return num;
}


// Функция разложения числа
void rot(int num) {
	int five = 0; int three = 0; // число пятёрок и троек
	for (five; ; five++) {
		if (five * 5 < num);

		else if (five * 5 > num) {
			five--;
			for (three; (five * 5 + three * 3) != num; three++)
				if ((five * 5 + three * 3) > num) five--;
			break;
		}

		else break;
	}

	if (three == 0) cout << num << " = 5*" << five << endl;
	else if (five == 0) cout << num << " = 3*" << three << endl;
	else cout << num << " = 5*" << five << " + 3*" << three << endl;
}
