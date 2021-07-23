package novembertang.hangman

import io.circe.parser._
import requests.Response

import scala.annotation.tailrec
import scala.util.{Success, Try}

object WordGenerator {

  @tailrec
  def get(url: String): String = {
    lazy val defaultWord = "consternation"
    val r= Try(requests.get(url, connectTimeout = 500))

    r match {
      case x: Success[Response] if x.value.is2xx =>
        val word = findFirstLongWord(x.value.data.toString())
        if (word.isDefined) word.get else get(url)
      case _ => defaultWord
    }

  }

  private def findFirstLongWord(json: String): Option[String] = {
    val wordList = decode[List[String]](json).toOption
    val firstLongWord = wordList.flatMap(_.find(_.length >= 7))
    firstLongWord
  }
}
