/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.string.rand;

import dev.kalenchukov.alphabet.EnglishAlphabet;
import dev.kalenchukov.numeralsystem.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Класс содержит статические методы для получения строк случайных символов.
 */
public final class StringRand
{
	/**
	 * Конструктор для {@code StringRand} запрещающий создавать объект класса.
	 */
	private StringRand() {}

	/**
	 * Возвращает строку из символов [0, 1].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String binary(final int length)
	{
		return StringRand.generate(length, BinarySystem.DIGITS);
	}

	/**
	 * Возвращает строку из символов [0-7].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String octal(final int length)
	{
		return StringRand.generate(length, OctalSystem.DIGITS);
	}

	/**
	 * Возвращает строку из символов [0-9].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String decimal(final int length)
	{
		return StringRand.generate(length, DecimalSystem.DIGITS);
	}

	/**
	 * Возвращает строку из символов [0-9A-B].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String duodecimal(final int length)
	{
		return StringRand.generate(length, DuodecimalSystem.DIGITS);
	}

	/**
	 * Возвращает строку из символов [0-9A-F].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String hex(final int length)
	{
		return StringRand.generate(length, HexadecimalSystem.DIGITS);
	}

	/**
	 * Возвращает строку из символов [a-z].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String lower(final int length)
	{
		return StringRand.generate(length, EnglishAlphabet.LETTERS_LOWER_CASE);
	}

	/**
	 * Возвращает строку из символов [A-Z].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String upper(final int length)
	{
		return StringRand.generate(length, EnglishAlphabet.LETTERS_UPPER_CASE);
	}

	/**
	 * Возвращает строку из символов [A-Za-z].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String alpha(final int length)
	{
		return StringRand.generate(length, EnglishAlphabet.LETTERS);
	}

	/**
	 * Возвращает строку из символов [A-Za-z0-9].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String alnum(final int length)
	{
		List<Character> symbols = new ArrayList<>(
			EnglishAlphabet.LETTERS.size() + DecimalSystem.DIGITS.size()
		);
		symbols.addAll(EnglishAlphabet.LETTERS);
		symbols.addAll(DecimalSystem.DIGITS);

		return StringRand.generate(length, symbols);
	}

	/**
	 * Возвращает строку из символов [a-zA-Z0-9!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~].
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	public static String graph(final int length)
	{
		List<Character> symbols = new ArrayList<>(
			EnglishAlphabet.LETTERS.size() + DecimalSystem.DIGITS.size()
		);
		symbols.addAll(EnglishAlphabet.LETTERS);
		symbols.addAll(DecimalSystem.DIGITS);
		symbols.addAll(List.of(
			'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':',
			';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'
		));

		return StringRand.generate(length, symbols);
	}

	/**
	 * Возвращает строку из указанных наборов символов.
	 *
	 * @param length Количество символов в возвращаемой строке.
	 * @param symbols Символы из которых должна состоять строка.
	 * @return Строку со случайным порядком символов.
	 */
	@NotNull
	private static String generate(@NotNull final Integer length,
								   @NotNull final List<@NotNull Character> symbols)
	{
		Objects.requireNonNull(symbols);

		StringBuilder string = new StringBuilder();
		Random random = new Random();

		for (int l = 0; l < length; l++)
		{
			int position = random.nextInt(symbols.size());

			string.append(symbols.get(position));
		}

		return string.toString();
	}
}