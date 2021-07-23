package novembertang.hangman

import scala.annotation.tailrec
import scala.collection.SortedSet

object Game extends Ascii {

  @tailrec
  def hangman(word: String, guessedLetters: SortedSet[Char] = SortedSet.empty[Char], lives: Int = lives): Unit = {

    val wordProgress: String = currentWordProgress(word, guessedLetters)

    printCurrentProgress(guessedLetters, lives, wordProgress)

    val finishedWord = wordProgress == word
    val livesRemaining = lives > 0

    (livesRemaining, finishedWord) match {
      case (false, _) => println(s"Out of lives. You lose!\nThe word was $word")
      case (true, true) => println("You win!")
      case (true, false) =>
        val letter: Char = IO.getLetter(guessedLetters)
        val updatedLetterSet = guessedLetters + letter
        if (word.contains(letter)) {
          println(s"$letter was correct!")
          hangman(word, updatedLetterSet, lives)
        }
        else {
          println(s"$letter was incorrect")
          hangman(word, updatedLetterSet, lives - 1)
        }
    }
  }

  private def printCurrentProgress(guessedLetters: SortedSet[Char], lives: Int, wordProgress: String): Unit = {
    println(s"\n\nCurrent Progress: $wordProgress\n$lives ${if (lives==1) "life" else "lives"} remaining")
    println(images(lives))

    if (guessedLetters.nonEmpty) {
      print(s"Guessed Letters: ")
      guessedLetters.foreach(x => print(s"$x "))
    }
    println("")
  }

  private def currentWordProgress(word: String, guessedLetters: SortedSet[Char]): String = {

    val underscoreTuple = word
      .toCharArray
      .zip(List.fill(word.length)('_'))

    val wordProgress: String = replaceGuessedLetters(underscoreTuple, guessedLetters)
    wordProgress
  }

  private def replaceGuessedLetters(underscoreTuple: Seq[(Char, Char)], guessedLetters: SortedSet[Char]) =
    underscoreTuple
      .map { case (char, underscore) => if (guessedLetters.contains(char)) char else underscore }
      .mkString

}
