#include <iostream>

int main()
{
	setlocale(LC_ALL, "Rus"); // Корректное отображение русского языка

	int i = 12, j = 5;
	float x, y = 0;

	x = (float)(i / j);
	y = (float)(i % j);

	std::cout << "x = " << x << "; y = " << y << std::endl;
	std::cout << "Размер x и y соответственно равны " << sizeof(x)
		<< " и " << sizeof(y) << " байт (тип float)" << std::endl;

	return 0;
}
