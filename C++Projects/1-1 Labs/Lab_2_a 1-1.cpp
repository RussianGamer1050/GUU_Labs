#include <iostream>

/*
Составить и отладить программы
С клавиатуры ввести g, h, i
Если i < g*3 или h != 0, i *= 3 g += 1
иначе "Переменным g и i не повезло"
Вывести g, i
*/

int main() {

	setlocale(LC_ALL, "Rus");

	// Объявление переменных
	int g, h, i;

	// Ввод значений трёх переменных
	std::cout << "Введите последовательно 3 числа:" << std::endl;
	std::cout << "g = "; std::cin >> g;
	std::cout << "h = "; std::cin >> h;
	std::cout << "i = "; std::cin >> i;

	// Проверка условий
	if (i < g * 3 || h != 0) { i *= 3; g += 1; }
	else std::cout << "Переменным g и i не повезло" << std::endl;

	// Вывод значений переменных
	std::cout << "g = " << g << ", i = " << i << std::endl;

	return 0;
}
