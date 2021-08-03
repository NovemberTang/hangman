package novembertang.hangman

import scala.collection.SortedSet

case class State(word: String, guessedLetters: SortedSet[Char])

object State {
  def apply(word: String): State = State(word, SortedSet.empty[Char])
}
