/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.stringrand;

import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Класс содержит статические методы для получения строк случайных символов.
 */
public final class StringRand
{
	/**
	 * Набор двоичной системы счисления.
	 */
	private static final char[] BINARY = {
		'0', '1'
	};

	/**
	 * Набор восьмеричной системы счисления.
	 */
	private static final char[] OCTAL = {
		'0', '1', '2', '3', '4', '5', '6', '7'
	};

	/**
	 * Набор десятеричной системы счисления.
	 */
	private static final char[] DECIMAL = {
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
	};

	/**
	 * Набор двенадцатеричной системы счисления.
	 */
	private static final char[] DUODECIMAL = {
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B'
	};

	/**
	 * Набор шестнадцатеричной системы счисления.
	 */
	private static final char[] HEX = {
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
	};

	/**
	 * Набор прописных букв латинского алфавита.
	 */
	private static final char[] LOWER = {
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
	};

	/**
	 * Набор строчных букв латинского алфавита.
	 */
	private static final char[] UPPER = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	};

	/**
	 * Набор символов печатаемых с клавиатуры
	 */
	private static final char[] GRAPH = {
		'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':',
		';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'
	};

	/**
	 * Конструктор для {@code Rand} запрещающий создавать объект класса.
	 */
	private StringRand() {}

	/**
	 * Возвращает строку из символов [0, 1].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String binary(int length)
	{
		return StringRand.generate(length, BINARY);
	}

	/**
	 * Возвращает строку из символов [0-7].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String octal(int length)
	{
		return StringRand.generate(length, OCTAL);
	}

	/**
	 * Возвращает строку из символов [0-9].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String decimal(int length)
	{
		return StringRand.generate(length, DECIMAL);
	}

	/**
	 * Возвращает строку из символов [0-9A-B].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String duodecimal(int length)
	{
		return StringRand.generate(length, DUODECIMAL);
	}

	/**
	 * Возвращает строку из символов [0-9A-F].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String hex(int length)
	{
		return StringRand.generate(length, HEX);
	}

	/**
	 * Возвращает строку из символов [a-z].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String lower(int length)
	{
		return StringRand.generate(length, LOWER);
	}

	/**
	 * Возвращает строку из символов [A-Z].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String upper(int length)
	{
		return StringRand.generate(length, UPPER);
	}

	/**
	 * Возвращает строку из символов [A-Za-z].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String alpha(int length)
	{
		return StringRand.generate(length, ArrayUtils.addAll(UPPER, LOWER));
	}

	/**
	 * Возвращает строку из символов [A-Za-z0-9].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String alnum(int length)
	{
		return StringRand.generate(
			length,
			ArrayUtils.addAll(
				ArrayUtils.addAll(UPPER, LOWER), DECIMAL)
		);
	}

	/**
	 * Возвращает строку из символов [a-zA-Z0-9!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String graph(int length)
	{
		return StringRand.generate(length, ArrayUtils.addAll(
				ArrayUtils.addAll(UPPER, LOWER),
				ArrayUtils.addAll(DECIMAL, GRAPH)
			)
		);
	}

	/**
	 * Возвращает строку из указанного набора символов.
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @param symbols Набор символов из которых должна состоять строка.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	private static String generate(int length, char[] symbols)
	{
		StringBuilder string = new StringBuilder();

		for (int l = 0; l < length; l++) {
			string.append(symbols[(int)(Math.random() * symbols.length)]);
		}

		return string.toString();
	}
}