#include <iostream>

/*
Ввести три целых числа
При помощи switch:
1) Вывести наименьшее
2) Вывести два меньших
3) Вычислить среднее арифметическое
иначе - вывести ошибку ввода
*/

int main() {

	setlocale(LC_ALL, "Rus");

	// Объявление переменных
	int a, b, c, to_do, t;

	// Ввод значений трёх переменных
	std::cout << "Введите последовательно 3 числа:" << std::endl;
	std::cout << "a = "; std::cin >> a;
	std::cout << "b = "; std::cin >> b;
	std::cout << "c = "; std::cin >> c;

	// Вывод вариантов и приём действия
	std::cout << "Что вы хотите сделать?" << std::endl;
	std::cout << "1) Вывести наименьшее число" << std::endl;
	std::cout << "2) Вывести два меньших числа" << std::endl;
	std::cout << "3) Вычислить среднее арифметическое введённых чисел" << std::endl;
	std::cin >> to_do;

	// Меню switch
	switch (to_do) {
	case 1: 
		if (a > c) a = c; 
		if (a > b) a = b; 
		std::cout << "Наименьшее значение - " << a << std::endl; break;
	case 2: 
		if (a > c) { t = c; c = a; a = t; }
		if (a > b) { t = b; b = a; a = t; }
		if (b > c) { b = c; }
		std::cout << "Два меньших числа - " << a << " и " << b << std::endl; break;
	case 3: 
		std::cout << "Среднее арифметическое - " << (a + b + c) / 3 << std::endl; break;
	default: std::cout << "Ошибка выбора" << std::endl;
	}

	return 0;
}
