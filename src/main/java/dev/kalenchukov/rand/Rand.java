/*
 * Copyright © 2021 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.rand;

import org.apache.commons.lang3.ArrayUtils;

public final class Rand
{
	private static final char[] DIGIT = {
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
	};

	private static final char[] LOWER = {
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
	};

	private static final char[] UPPER = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	};

	private static final char[] GRAPH = {
		'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':',
		';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'
	};

	private Rand()
	{

	}

	/**
	 * Возвращает строку из символов [0-9]
	 */
	public static String digit(int length)
	{
		return generate(length, DIGIT);
	}

	/**
	 * Возвращает строку из символов [a-z]
	 */
	public static String lower(int length)
	{
		return generate(length, LOWER);
	}

	/**
	 * Возвращает строку из символов [A-Z]
	 */
	public static String upper(int length)
	{
		return generate(length, UPPER);
	}

	/**
	 * Возвращает строку из символов [A-Za-z]
	 */
	public static String alpha(int length)
	{
		return generate(length, ArrayUtils.addAll(UPPER, LOWER));
	}

	/**
	 * Возвращает строку из символов [A-Za-z0-9]
	 */
	public static String alnum(int length)
	{
		return generate(
			length,
			ArrayUtils.addAll(
				ArrayUtils.addAll(UPPER, LOWER),
				DIGIT)
		);
	}

	/**
	 * Возвращает строку из символов [a-zA-Z0-9!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~]
	 */
	public static String graph(int length)
	{
		return generate(length, ArrayUtils.addAll(
				ArrayUtils.addAll(UPPER, LOWER),
				ArrayUtils.addAll(DIGIT, GRAPH)
			)
		);
	}

	private static String generate(int length, char[] symbols)
	{
		StringBuilder randStr = new StringBuilder();

		for (int l = 0; l < length; l++)
		{
			randStr.append(symbols[(int)(Math.random() * symbols.length)]);
		}

		return randStr.toString();
	}
}