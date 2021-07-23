package novembertang.hangman

import scala.annotation.tailrec
import scala.collection.SortedSet

object IO {

  @tailrec
  def getLetter(guessedLetters: SortedSet[Char]): Char = {
    println("Guess a letter")
    val input = scala.io.StdIn.readLine()
    val firstLetterFromInput: Option[Char] = input.find(_.isLetter)

    firstLetterFromInput match {
      case Some(value) if guessedLetters.contains(value) =>
        println("You tried that letter already. Try a different one")
        getLetter(guessedLetters)

      case Some(value) => value.toLower

      case None => println("Letter not found in input. Try again.")
        getLetter(guessedLetters)
    }
  }

}
