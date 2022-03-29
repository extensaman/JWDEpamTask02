 <h2>Information handling</h2>
 
 Develop an application that parses and processes text.
 <p>
 You need to create an application that parses text from a programming textbook from a file
 and allowing you to perform three different operations on text.
 <p>
 General requirements for the project:
 
 - The parsed text should be represented as an object (text) containing,
 for example, sentences and code blocks, a sentence can contain the words of the sentence.
 - The words of a sentence (parts of a sentence) can be, for example, simple words and
 punctuation marks. These classes are entity classes and should not be
 overloaded with logic methods.
 - The parsed text must be restored in its original form, for
 excluding spaces between elements. Spaces and tabs in parsing can
 replaced with a single space.
 - To divide the text into sentences and other components, use
 regular expressions. Don't forget that application regular expressions are
 literal constants.
 - The code that breaks the text into its component parts should be developed in
 the form of parser classes.
 - When developing parsers that parse text, you need to keep track of the number of
 created parser objects.
 - When implementing a task, you can use such programming patterns as Composite and Chain of
 Responsibility.
 - When handling exceptions, the application must use
 logger Log4j.
 - The created application should allow the implementation of a group of tasks for working on
 text (tasks are given below) without “rewriting” existing code.
 
 1. Find the largest number of text sentences that have the same
 words.
 2. Display all sentences of the given text in ascending order
 the number of words in each.
 3. Find a word in the first sentence that is not in any of the others
 offers.
 4. In all interrogative sentences of the text, find and print without repetition
 words of a given length.
 5. In each sentence of the text, swap the first word with the last, do not
 changing the length of the sentence.
 6. Type the words of the text in alphabetical order first
 letter. Words beginning with a new letter should be printed in red.
 7. Sort the words of the text in ascending proportion of vowels (ratio
 number of vowels to the total number of letters in a word).
 8. Sort the words of the text starting with vowels in alphabetical order by
 the first consonant of the word.
 9. Sort all the words of the text in ascending order of the number of the given letter in the word.
 Arrange words with the same number of letters in alphabetical order.
 10. There is a text and a list of words. For each word from the given list find,
 how many times it occurs in each sentence, and sort the words by
 descending total number of occurrences.
 11. In each sentence of the text, exclude a substring of the maximum length,
 starting and ending with the given characters.
 12. Remove all words of a given length that begin with a consonant.
 13. Sort the words in the text in descending order of the number of occurrences of a given
 symbol, and in case of equality - alphabetically.
 14. In the given text, find a substring of maximum length that is
 palindrome, i.e. read from left to right and from right to left the same.
 15. Convert each word in the text, removing all subsequent ones from it
 (previous) occurrences of the first (last) letter of this word.
 16. In some sentence of the text, words of a given length are replaced by the specified
 a substring whose length may not match the length of the word.
 
 <h2>Разработать приложение, разбирающее и обрабатывающее текст.</h2>
 
 Необходимо создать приложение, разбирающее текст из учебника по
 программированию из файла и позволяющее выполнять с текстом три различных операции.
 
 Общие требования к проекту:
 
 Разобранный текст должен быть представлен в виде объекта (текста), содержащего,
 например, предложения и блоки кода, предложение может содержать слова предложения.
 
 Слова предложения (части предложения), могут быть, например, простыми словами и
 знаками препинания. Данные классы являются классами сущностей и не должны быть
 перегружены методами логики.
 
 Разобранный текст необходимо восстановить в первоначальном виде, за
 исключением пробелов между элементами. Пробелы и знаки табуляции при разборе могут
 заменяться одним пробелом.
 
 Для деления текста на предложения и другие составляющие следует использовать
 регулярные выражения. Не забывать, что регулярные выражения для приложения являются
 литеральными константами.
 
 Код, выполняющий разбитие текста на составляющие части, следует оформить в
 виде классов-парсеров.
 
 При разработке парсеров, разбирающих текст, необходимо следить за количеством
 создаваемых объектов-парсеров.
 
 При реализации задания можно использовать шаблоны Composite и Chain of
 Responsibility.
 
 При обработке исключительных ситуаций приложение необходимо использовать
 логгер Log4j.
 
 Созданное приложение должно позволять реализовывать группу задач по работе над
 текстом (задачи приведены ниже) без “переписывания” существующего кода.
 
 <h5>Функциональные возможности, варианты для реализации.</h5>
 
 1. Найти наибольшее количество предложений текста, в которых есть одинаковые
 слова.
 2. Вывести все предложения заданного текста в порядке возрастания
 количества слов в каждом из них.
 3. Найти такое слово в первом предложении, которого нет ни в одном из остальных
 предложений.
 4. Во всех вопросительных предложениях текста найти и напечатать без повторений
 слова заданной длины.
 5. В каждом предложении текста поменять местами первое слово с последним, не
 изменяя длины предложения.
 6. Напечатать слова текста в алфавитном порядке по первой
 букве. Слова, начинающиеся с новой буквы, печатать с красной строки.
 7. Рассортировать слова текста по возрастанию доли гласных букв (отношение
 количества гласных к общему количеству букв в слове).
 8. Слова текста, начинающиеся с гласных букв, рассортировать в алфавитном порядке по
 первой согласной букве слова.
 9. Все слова текста рассортировать по возрастанию количества заданной буквы в слове.
 Слова с одинаковым количеством букв расположить в алфавитном порядке.
 10. Существует текст и список слов. Для каждого слова из заданного списка найти,
 сколько раз оно встречается в каждом предложении, и рассортировать слова по
 убыванию общего количества вхождений.
 11. В каждом предложении текста исключить подстроку максимальной длины,
 начинающуюся и заканчивающуюся заданными символами.
 12. Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
 13. Отсортировать слова в тексте по убыванию количества вхождений заданного
 символа, а в случае равенства – по алфавиту.
 14. В заданном тексте найти подстроку максимальной длины, являющуюся
 палиндромом, т.е. читающуюся слева направо и справа налево одинаково.
 15. Преобразовать каждое слово в тексте, удалив из него все последующие
 (предыдущие) вхождения первой (последней) буквы этого слова.
 16. В некотором предложении текста слова заданной длины заменить указанной
 подстрокой, длина которой может не совпадать с длиной слова.