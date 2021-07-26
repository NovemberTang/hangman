package novembertang.hangman

object Ascii {

  val images: Map[Int, String] = List(
    "",
    """
      |
      |
      |
      |
      |
      |=========
      |""".stripMargin,
    """
      |      |
      |      |
      |      |
      |      |
      |      |
      |=========
      |""".stripMargin,
    """  +---+
      |      |
      |      |
      |      |
      |      |
      |      |
      |=========
      |""".stripMargin,
    """  +---+
      |  |   |
      |      |
      |      |
      |      |
      |      |
      |=========
      |""".stripMargin,
    """  +---+
      |  |   |
      |  O   |
      |      |
      |      |
      |      |
      |=========""".stripMargin,
    """  +---+
      |  |   |
      |  O   |
      |  |   |
      |      |
      |      |
      |=========""".stripMargin,
    """  +---+
      |  |   |
      |  O   |
      | /|   |
      |      |
      |      |
      |=========""".stripMargin,
    """  +---+
      |  |   |
      |  O   |
      | /|\  |
      |      |
      |      |
      |=========""".stripMargin,
    """  +---+
      |  |   |
      |  O   |
      | /|\  |
      | /    |
      |      |
      |=========""".stripMargin,
    """  +---+
      |  |   |
      |  O   |
      | /|\  |
      | / \  |
      |      |
      |=========""".stripMargin

  ).reverse.zipWithIndex.map(t => (t._2, t._1)).toMap

  val totalLives: Int = images.size -1



}
