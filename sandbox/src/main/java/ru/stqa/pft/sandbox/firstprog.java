package ru.stqa.pft.sandbox;

public class firstprog {

    public static void main(String[] args) {  //функция, main - имя функции
		hello("world");  //функция
		hello("user"); //функция

        Square s = new Square(5);
		System.out.println("Площадь квадрата " + s.l + "=" + s.area());

		Rectangle r = new Rectangle(4,5);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + "=" + r.area());
	}

	public static void hello(String somebody) {  //функция, hello - имя функции, string somebody - параметр/аргумент функции
		System.out.println("Hello," + somebody + "!");  //содержимое функции с переменной
    }

}

