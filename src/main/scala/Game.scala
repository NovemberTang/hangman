package novembertang.hangman

import scala.annotation.tailrec
import scala.collection.SortedSet

object Game{

  @tailrec
  def hangman(state: State): Unit = {

    val wordProgress: String = currentWordProgress(state.word, state.guessedLetters)
    val livesLeft: Int = calculateRemainingLives(state)
    val outOfLives = livesLeft == 0
    val finishedWord = wordProgress == state.word

    printCurrentProgress(state.guessedLetters, livesLeft, wordProgress)

    (outOfLives, finishedWord) match {
      case (true, _) => println(s"Out of lives. You lose!\nThe word was ${state.word}")
      case (false, true) => println("You win!")
      case (false, false) =>
        val letter: Char = IO.getLetter(state.guessedLetters)
        val updatedLetterSet = state.guessedLetters + letter
        if (state.word.contains(letter)) {
          println(s"$letter was correct!")
          hangman(State(state.word, updatedLetterSet))
        }
        else {
          println(s"$letter was incorrect")
          hangman(State(state.word, updatedLetterSet))
        }
    }
  }

  private def calculateRemainingLives(state: State) = {
    val incorrectGuesses: SortedSet[Char] = state.guessedLetters -- state.word.toSet
    Ascii.totalLives - incorrectGuesses.size
  }

  private def printCurrentProgress(guessedLetters: SortedSet[Char], lives: Int, wordProgress: String): Unit = {
    println(s"\n\nCurrent Progress: $wordProgress\n$lives ${if (lives==1) "life" else "lives"} remaining")
    println(Ascii.images(lives))

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
