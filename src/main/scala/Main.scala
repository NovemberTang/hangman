package novembertang.hangman

object Main extends App {

  val url = """http://random-word-api.herokuapp.com/word?number=20"""
  val word = WordGenerator.get(url)
  Game.hangman(word)

}
