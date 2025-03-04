fun main() {
    println("Введите путь к текстовому файлу:")
    val filePath = readLine() ?: return

    val analyzer = TextAnalyzerAdvanced(filePath)

    while (true) {
        println("\nВыберите действие:")
        println("1. Подсчитать количество символов с пробелами")
        println("2. Подсчитать количество символов без пробелов")
        println("3. Подсчитать количество слов")
        println("4. Найти наиболее частое слово")
        println("5. Найти слово в тексте")
        println("6. Подсчитать количество предложений")
        println("7. Подсчитать частоту слова")
        println("8. Генерация Word Cloud")
        println("9. Сохранить результаты в файл")
        println("0. Выйти")

        when (readLine()) {
            "1" -> println("Количество символов с пробелами: ${analyzer.countCharactersWithSpaces()}")
            "2" -> println("Количество символов без пробелов: ${analyzer.countCharactersWithoutSpaces()}")
            "3" -> println("Количество слов: ${analyzer.countWords()}")
            "4" -> println("Наиболее частое слово: ${analyzer.mostFrequentWord()}")
            "5" -> {
                println("Введите слово для поиска:")
                val word = readLine() ?: ""
                if (analyzer.searchWord(word)) {
                    println("Слово найдено!")
                } else {
                    println("Слово не найдено!")
                }
            }
            "6" -> println("Количество предложений: ${analyzer.countSentences()}")
            "7" -> {
                println("Введите слово для подсчета частоты:")
                val word = readLine() ?: ""
                println("Частота слова '$word': ${analyzer.wordFrequency(word)}")
            }
            "8" -> {
                val wordCloud = analyzer.generateWordCloud()
                println("Word Cloud:")
                wordCloud.forEach { (word, frequency) ->
                    println("$word: $frequency")
                }
            }
            "9" -> {
                println("Введите путь для сохранения файла:")
                val outputFilePath = readLine() ?: return
                val results = buildString {
                    appendLine("Анализ текста из файла: ${filePath}")
                    appendLine("Количество символов с пробелами: ${analyzer.countCharactersWithSpaces()}")
                    appendLine("Количество символов без пробелов: ${analyzer.countCharactersWithoutSpaces()}")
                    appendLine("Количество слов: ${analyzer.countWords()}")
                    appendLine("Наиболее частое слово: ${analyzer.mostFrequentWord()}")
                    appendLine("Количество предложений: ${analyzer.countSentences()}")
                }
                analyzer.saveResultsToFile(results, outputFilePath)
                println("Результаты сохранены в файл $outputFilePath")
            }
            "0" -> break
            else -> println("Некорректный выбор. Попробуйте снова.")
        }
    }
}
